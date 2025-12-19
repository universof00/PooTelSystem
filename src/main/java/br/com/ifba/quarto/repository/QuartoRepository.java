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

import br.com.ifba.quarto.entity.Quarto;
import java.util.List;

public interface QuartoRepository {
    void save(Quarto quarto);
    Quarto findById(int numero);
    List<Quarto> findAll();
    void update(Quarto quarto);
    void delete(int numero);
}