/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.quarto.repository;

import br.com.ifba.quarto.entity.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author igo
 */

public interface QuartoRepository extends JpaRepository<Quarto, Long>{
    public Quarto findBynumero(String numero);
    public Quarto findByid(Long id);
}
