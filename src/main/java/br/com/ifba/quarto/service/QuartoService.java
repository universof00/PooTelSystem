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
import br.com.ifba.quarto.entity.Quarto;
import br.com.ifba.quarto.repository.QuartoRepository;
import br.com.ifba.quarto.repository.QuartoRepositoryImpl;
import java.util.List;

public class QuartoService {
    private QuartoRepository repository = new QuartoRepositoryImpl();

    public void criarQuarto(Quarto quarto) {
        repository.save(quarto);
    }

    public Quarto buscarQuarto(int numero) {
        return repository.findById(numero);
    }

    public List<Quarto> listarQuartos() {
        return repository.findAll();
    }

    public void atualizarQuarto(Quarto quarto) {
        repository.update(quarto);
    }

    public void deletarQuarto(int numero) {
        repository.delete(numero);
    }
}