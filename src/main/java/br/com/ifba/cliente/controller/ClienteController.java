/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.cliente.controller;

import br.com.ifba.cliente.entity.Cliente;
import br.com.ifba.cliente.service.ClienteIService;
import java.util.List;
import org.springframework.stereotype.Controller;

/**
 *
 * @author raiii
 */
@Controller
public class ClienteController implements ClienteIController{
    
    private final ClienteIService clienteIService;
    
    public ClienteController(ClienteIService clienteIService){
        this.clienteIService = clienteIService;
    }
    
    @Override
    public Cliente save(Cliente cliente) throws RuntimeException{
        return clienteIService.save(cliente);
    }
    
    @Override
    public void delete(Cliente cliente) throws RuntimeException{
        clienteIService.delete(cliente);
    }
    
    @Override
    public Cliente update(Cliente cliente) throws RuntimeException{
        return clienteIService.update(cliente);
    }
    
    @Override 
    public List<Cliente> findAll() throws RuntimeException{
        return clienteIService.findAll();
    }
    
    @Override 
    public Cliente findById(Long id) throws RuntimeException{
        return clienteIService.findById(id);
    }
}
