/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.usuario.controller;

import br.com.ifba.cliente.entity.Cliente;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.service.UsuarioIService;

/**
 *
 * @author raiii
 */
public interface UsuarioIController {
    void cadastroPublico(Cliente cliente, Usuario usuario);
    public Usuario save(Usuario usuario) throws RuntimeException;
    public void delete(Usuario usuario) throws RuntimeException;
    public Usuario update(Usuario usuario) throws RuntimeException;
    public Usuario findByEmail(String email) throws RuntimeException;
    public Usuario authenticate(String email, String senha) throws RuntimeException;
}
