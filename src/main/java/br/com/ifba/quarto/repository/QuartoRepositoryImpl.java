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
import br.com.ifba.quarto.entity.Quarto;
import java.util.ArrayList;
import java.util.List;

public class QuartoRepositoryImpl implements QuartoRepository {
    private List<Quarto> quartos = new ArrayList<>();

    @Override
    public void save(Quarto quarto) {
        quartos.add(quarto);
    }

    @Override
    public Quarto findById(int numero) {
        return quartos.stream().filter(q -> q.getNumero() == numero).findFirst().orElse(null);
    }

    @Override
    public List<Quarto> findAll() {
        return quartos;
    }

    @Override
    public void update(Quarto quarto) {
        Quarto existing = findById(quarto.getNumero());
        if (existing != null) {
            existing.setTipo(quarto.getTipo());
            existing.setPrecoDiaria(quarto.getPrecoDiaria());
            existing.setEstaDisponivel(quarto.isEstaDisponivel());
        }
    }

    @Override
    public void delete(int numero) {
        quartos.removeIf(q -> q.getNumero() == numero);
    }
}
