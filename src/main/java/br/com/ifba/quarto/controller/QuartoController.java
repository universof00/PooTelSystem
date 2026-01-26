/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.quarto.controller;

import br.com.ifba.quarto.entity.Quarto;
import br.com.ifba.quarto.service.QuartoIService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author igo
 */
@Controller
public class QuartoController implements QuartoIController {
    
     @Autowired
    private QuartoIService service;

    public Quarto save(Quarto quarto) {
        return service.save(quarto);
    }

    public void deleteById(Long id) {
        service.delete(id);
    }

    public Quarto update(Quarto quarto) {
        return service.update(quarto);
    }

    public List<Quarto> findAll() {
        return service.findAll();
    }

    public Quarto findById(Long id) {
        return service.findById(id);
    }

    public Quarto findBynumero(String numero) {
        return service.findBynumero(numero);
    }
}
