/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.quarto.controller;

/**
 *
 * @author User
 */
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import br.com.ifba.quarto.entity.Cliente;
import br.com.ifba.quarto.service.ClienteService;
import java.util.List;

public class ClienteController {
    private ClienteService service = new ClienteService();

    public void criarCliente(int id, String nome, String cpf, String email, String telefone) {
        Cliente cliente = new Cliente(id, nome, cpf, email, telefone);
        service.criarCliente(cliente);
    }

    public Cliente buscarCliente(int id) {
        return service.buscarCliente(id);
    }

    public List<Cliente> listarClientes() {
        return service.listarClientes();
    }

    public void atualizarCliente(int id, String nome, String cpf, String email, String telefone) {
        Cliente cliente = service.buscarCliente(id);
        if (cliente != null) {
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setEmail(email);
            cliente.setTelefone(telefone);
            service.atualizarCliente(cliente);
        }
    }

    public void deletarCliente(int id) {
        service.deletarCliente(id);
    }
}
