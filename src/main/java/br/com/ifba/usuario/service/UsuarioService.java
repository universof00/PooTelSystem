/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.service;

import br.com.ifba.auditoria.AuditoriaService;
import br.com.ifba.cliente.entity.Cliente;
import br.com.ifba.cliente.repository.ClienteRepository;
import br.com.ifba.enums.TipoPerfil;
import br.com.ifba.funcionario.entity.Funcionario;
import br.com.ifba.funcionario.repository.FuncionarioRepository;
import br.com.ifba.infrastructure.util.ValidacaoUtil;
import br.com.ifba.pessoa.entity.Pessoa;
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
    private final FuncionarioRepository funcionarioRepository;
    
    @Override
    public void cadastroPublico(Pessoa pessoa, Usuario usuario) {

        if (!ValidacaoUtil.emailValido(usuario.getEmail())) {
            throw new IllegalStateException("Email Inválido.");
        }

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalStateException("Email já cadastrado.");
        }

        if (usuario.getSenha().length() < 9) {
            throw new IllegalStateException("Senha muito curta.");
        }

        // Remova ou condicione os sets fixos
        if (pessoa instanceof Cliente cliente) {
    // Só define como CLIENTE se o perfil vier vazio da tela
            if (usuario.getPerfil() == null) {
                usuario.setPerfil(TipoPerfil.CLIENTE);
            }
            clienteRepository.save(cliente);
        } else if (pessoa instanceof Funcionario funcionario) {
    // Se veio algo da tela (como ADMIN), ele não entra aqui e mantém o ADMIN
            if (usuario.getPerfil() == null) {
                usuario.setPerfil(TipoPerfil.FUNCIONARIO);
            }
        funcionarioRepository.save(funcionario);
        }
        AuditoriaService.registrar(usuario.getEmail(), "SALVAR", "Salvando Dados" + usuario.getId());
        usuarioRepository.save(usuario);
    }
    
    @Override
    public void update(Pessoa pessoa, Usuario usuario) {
        if (!ValidacaoUtil.emailValido(usuario.getEmail())) {
            throw new IllegalStateException("Email Inválido.");
        }

        if (!ValidacaoUtil.telefoneValido(pessoa.getTelefone())) {
            throw new IllegalStateException("Telefone inválido.");
        }

    // regras específicas por tipo
        if (pessoa instanceof Cliente cliente) {
            usuario.setPerfil(TipoPerfil.CLIENTE);
            AuditoriaService.registrar(cliente.getNome(), "ATUALIZAR", "Atualizando Dados" + cliente.getId());
            clienteRepository.save(cliente);

        } else if (pessoa instanceof Funcionario funcionario) {
            usuario.setPerfil(TipoPerfil.FUNCIONARIO);            
            AuditoriaService.registrar(funcionario.getNome(), "ATUALIZAR", "Atualizando Dados" + funcionario.getId());
            funcionarioRepository.save(funcionario);

        } else {
            throw new IllegalStateException("Tipo de pessoa inválido.");
        }
        AuditoriaService.registrar(usuario.getEmail(), "ATUALIZAR", "Atualizando Dados" + usuario.getId());
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
            AuditoriaService.registrar(usuario.getEmail(), "EXCLUIR", "Excluindo Dados" + usuario.getId());
            usuarioRepository.delete(usuario);
        }
    }
}
