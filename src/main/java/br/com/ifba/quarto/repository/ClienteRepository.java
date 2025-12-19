/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
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
import java.util.List;

public interface ClienteRepository {
    void save(Cliente cliente);
    Cliente findById(int id);
    List<Cliente> findAll();
    void update(Cliente cliente);
    void delete(int id);
}
