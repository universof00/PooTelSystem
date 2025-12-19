/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.cliente.controller;

import br.com.ifba.cliente.entity.Cliente;
import java.util.List;

/**
 *
 * @author raiii
 */
public interface ClienteIController {
    public Cliente save(Cliente cliente) throws RuntimeException;
    public void delete(Cliente cliente) throws RuntimeException;
    public Cliente update(Cliente cliente) throws RuntimeException;
    public List<Cliente> findAll() throws RuntimeException;
    public Cliente findById(Long id) throws RuntimeException;
}
