/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.service;

import br.com.ifba.cliente.entity.Cliente;
import br.com.ifba.cliente.repository.ClienteRepository;
import br.com.ifba.enums.TipoPerfil;
import br.com.ifba.infrastructure.util.ValidacaoUtil;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.repository.UsuarioRepository;
import java.util.NoSuchElementException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author raiii
 */
@AllArgsConstructor
@Service
public class UsuarioService implements UsuarioIService{
    
    private final UsuarioRepository usuarioRepository;
    private final ClienteRepository clienteRepository;
    
    @Override
    public void cadastroPublico(Cliente cliente, Usuario usuario){
         if (!ValidacaoUtil.emailValido(usuario.getEmail())) {
            throw new IllegalStateException("Email Inválido.");
        }

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalStateException("Email já cadastrado.");
        }
        
        if (usuario.getSenha().length() < 9) {
            throw new IllegalStateException("Senha muito curta.");
        }
        
        if (!ValidacaoUtil.telefoneValido(cliente.getTelefone())) {
            throw new IllegalStateException("Telefone inválido.");
        }
        usuario.setPerfil(TipoPerfil.CLIENTE);
        
        clienteRepository.save(cliente);
        usuarioRepository.save(usuario);
    }
    
    @Override
    public Usuario save(Usuario usuario) throws RuntimeException{
        Usuario usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        
        if(usuarioExistente != null){
           throw new IllegalStateException("Já existe usuário com esse email.");
        }

        return usuarioRepository.save(usuario);
    }
    
    @Override
    public Usuario update(Usuario usuario){
        if(usuarioRepository.findById(usuario.getId()) == null){
            throw new NoSuchElementException("Usuário não encontrado.");
        }
        return usuarioRepository.save(usuario);
    }
    
    @Override
    public Usuario findByEmail(String email){
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null){
            throw new NoSuchElementException("Usuário não encontrado.");
        }
        return usuario;
    }
    
    @Override
    public Usuario authenticate(String email, String senha){
        Usuario usuario = usuarioRepository.findByEmail(email);
        if(usuario == null){
            throw new NoSuchElementException("Usuário não encontrado.");
        }
        
        if (!usuario.getSenha().equals(senha)){
            throw new IllegalArgumentException("Email ou senha inválidos.");
        }else if(!usuario.getEmail().equals(email)){
            throw new IllegalArgumentException("Email ou senha inválidos.");
        }
        
        return usuario;
    }
    
    @Override
    public void delete(Usuario usuario) throws RuntimeException{
        if(usuario == null){
            throw new RuntimeException("Dados do " + "usuário não preenchidos.");
        }else if (usuario.getId() == null){
            throw new NoSuchElementException("Usuário não encontrado.");
        }else{
            usuarioRepository.delete(usuario);
        }
    }
}
