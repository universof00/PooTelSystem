/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.quarto.service;

/**
 *
 * @author PedroLucas
 */
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import br.com.ifba.quarto.entity.Cliente;
import br.com.ifba.quarto.repository.ClienteRepository;
import br.com.ifba.quarto.repository.ClienteRepositoryImpl;
import java.util.List;

public class ClienteService {
    private ClienteRepository repository = new ClienteRepositoryImpl();

    public void criarCliente(Cliente cliente) {
        repository.save(cliente);
    }

    public Cliente buscarCliente(int id) {
        return repository.findById(id);
    }

    public List<Cliente> listarClientes() {
        return repository.findAll();
    }

    public void atualizarCliente(Cliente cliente) {
        repository.update(cliente);
    }

    public void deletarCliente(int id) {
        repository.delete(id);
    }
}
