/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.cliente.service;

import br.com.ifba.auditoria.AuditoriaService;
import br.com.ifba.cliente.entity.Cliente;
import br.com.ifba.cliente.repository.ClienteRepository;
import br.com.ifba.reserva.repository.ReservaRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author raiii
 */
@AllArgsConstructor
@Service
public class ClienteService implements ClienteIService{

    private final ClienteRepository clienteRepository;
        
    private final ReservaRepository reservaRepository;
    
    @Override
    public Cliente save(Cliente cliente) throws RuntimeException {
        if(cliente == null){
           throw new RuntimeException("Dados do " + "cliente não preenchidos.");
        } else if (cliente.getId() != null){
           throw new RuntimeException("Cliente " + "já existente no banco de dados.");
        }else {
           AuditoriaService.registrar(cliente.getNome(), "SALVAR", "Salvando Dados" + cliente.getId());
           return clienteRepository.save(cliente);
       }
    }

    @Override
    public void delete(Cliente cliente) throws RuntimeException {
        if (cliente == null){
            throw new RuntimeException("Dados do " + "cliente não preenchidos.");
        }else if (cliente.getId() == null){
            throw new RuntimeException("Cliente " + "não existente no banco de dados.");
        }else {
            AuditoriaService.registrar(cliente.getNome(), "EXCLUIR", "Excluindo dados do cliente" + cliente.getId());
            clienteRepository.delete(cliente);
        }
    }

    @Override
    public Cliente update(Cliente cliente) throws RuntimeException {
        if (cliente == null){
            throw new RuntimeException("Dados do " + "cliente não preenchidos.");
        }else {
            AuditoriaService.registrar(cliente.getNome(), "ATUALIZAR", "Atualizando dados do cliente" + cliente.getId());
            return clienteRepository.save(cliente);
        }
    }

    @Override
    public List<Cliente> findAll() throws RuntimeException {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) throws RuntimeException {
        return clienteRepository.findById(id).orElse(null);
    }
    
}
