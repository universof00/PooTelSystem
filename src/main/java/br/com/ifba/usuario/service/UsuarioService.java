/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.service;

import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.repository.UsuarioRepository;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

/**
 *
 * @author raiii
 */
@Service
public class UsuarioService implements UsuarioIService{
    private final UsuarioRepository usuarioRepository;
    
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
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
