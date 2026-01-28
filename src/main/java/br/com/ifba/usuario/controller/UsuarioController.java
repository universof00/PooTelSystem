/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.controller;

import br.com.ifba.pessoa.entity.Pessoa;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.service.UsuarioIService;
import java.util.List;
import org.springframework.stereotype.Controller;

/**
 *
 * @author raiii
 */
@Controller
public class UsuarioController implements UsuarioIController{
    private final UsuarioIService usuarioIService;
    
    public UsuarioController(UsuarioIService usuarioIService){
        this.usuarioIService = usuarioIService;
    }
    
    @Override
    public void update(Pessoa pessoa, Usuario usuario) throws RuntimeException{
        usuarioIService.update(pessoa, usuario);
    }
    
    @Override
    public void cadastroPublico(Pessoa pessoa, Usuario usuario) {
        usuarioIService.cadastroPublico(pessoa, usuario);
    }
    
    @Override
    public Usuario save(Usuario usuario) throws RuntimeException{
        return usuarioIService.save(usuario);
    }
    
    @Override
    public void delete(Usuario usuario) throws RuntimeException{
        usuarioIService.delete(usuario);
    }
    
    @Override
    public Usuario update(Usuario usuario) throws RuntimeException{
        return usuarioIService.update(usuario);
    }
    
    @Override
    public Usuario findByEmail(String email) throws RuntimeException{
        return usuarioIService.findByEmail(email);
    }
    
    @Override
    public Usuario authenticate(String email, String senha) throws RuntimeException{
        return usuarioIService.authenticate(email, senha);
    }
}
