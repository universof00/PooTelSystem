/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.cliente.service;

import br.com.ifba.cliente.entity.Cliente;
import br.com.ifba.reserva.entity.Reserva;
import java.util.List;

/**
 *
 * @author raiii
 */
public interface ClienteIService {
    public Cliente save(Cliente cliente) throws RuntimeException;
    public void delete(Cliente cliente) throws RuntimeException;
    public Cliente update(Cliente cliente) throws RuntimeException;
    public List<Cliente> findAll() throws RuntimeException;
    public Cliente findById(Long id) throws RuntimeException;
   
}
