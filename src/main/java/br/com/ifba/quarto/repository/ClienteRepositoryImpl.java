/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.quarto.repository;

/**
 *
 * @author PedroLucas
 */
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import br.com.ifba.quarto.entity.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepository {
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void save(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente findById(int id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Cliente> findAll() {
        return clientes;
    }

    @Override
    public void update(Cliente cliente) {
        Cliente existing = findById(cliente.getId());
        if (existing != null) {
            existing.setNome(cliente.getNome());
            existing.setCpf(cliente.getCpf());
            existing.setEmail(cliente.getEmail());
            existing.setTelefone(cliente.getTelefone());
        }
    }

    @Override
    public void delete(int id) {
        clientes.removeIf(c -> c.getId() == id);
    }
}
