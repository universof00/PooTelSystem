/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.quarto.controller;

import br.com.ifba.quarto.entity.Quarto;
import java.util.List;

/**
 *
 * @author igo
 */
public interface QuartoIController {
    public Quarto save(Quarto quarto) throws RuntimeException;
    public void deleteById(Long id) throws RuntimeException;
    public Quarto update(Quarto quarto) throws RuntimeException;
    public List<Quarto> findAll() throws RuntimeException;
    public Quarto findById(Long id) throws RuntimeException;
    public Quarto findBynumero(String numero)throws RuntimeException;
}
