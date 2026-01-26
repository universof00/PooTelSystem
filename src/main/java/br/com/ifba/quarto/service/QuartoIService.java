/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.quarto.service;

import br.com.ifba.quarto.entity.Quarto;
import java.util.List;

/**
 *
 * @author igo
 */
public interface QuartoIService {
    Quarto save(Quarto quarto);
    Quarto update(Quarto quarto);
    void delete(Long id);
    List<Quarto> findAll();
    Quarto findById(Long id);
    Quarto findBynumero(String numero);
}
