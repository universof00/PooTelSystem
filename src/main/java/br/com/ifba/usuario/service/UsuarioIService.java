/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.usuario.service;

import br.com.ifba.pessoa.entity.Pessoa;
import br.com.ifba.usuario.entity.Usuario;

/**
 *
 * @author raiii
 */
public interface UsuarioIService {
    public void update(Pessoa pessoa, Usuario usuario);
    public void cadastroPublico(Pessoa pessoa, Usuario usuario);
    public Usuario save(Usuario usuario) throws RuntimeException;
    public Usuario update(Usuario usuario);
    public Usuario findByEmail(String email);
    public Usuario authenticate(String email, String senha);
    public void delete(Usuario usuario);
}
