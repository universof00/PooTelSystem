/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.quarto.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import br.com.ifba.quarto.entity.Quarto;
import br.com.ifba.quarto.service.QuartoService;
import java.util.List;

public class QuartoController {
    private QuartoService service = new QuartoService();

    public void criarQuarto(int numero, String tipo, double precoDiaria) {
        Quarto quarto = new Quarto(numero, tipo, precoDiaria);
        service.criarQuarto(quarto);
    }

    public Quarto buscarQuarto(int numero) {
        return service.buscarQuarto(numero);
    }

    public List<Quarto> listarQuartos() {
        return service.listarQuartos();
    }

    public void atualizarQuarto(int numero, String tipo, double precoDiaria, boolean disponivel) {
        Quarto quarto = service.buscarQuarto(numero);
        if (quarto != null) {
            quarto.setTipo(tipo);
            quarto.setPrecoDiaria(precoDiaria);
            quarto.setEstaDisponivel(disponivel);
            service.atualizarQuarto(quarto);
        }
    }

    public void deletarQuarto(int numero) {
        service.deletarQuarto(numero);
    }
}
