/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.servico.repository;

import br.com.ifba.servico.entity.ServicoAdicional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author crisl
 */
@Repository
public interface ServicoAdicionalRepository extends JpaRepository<ServicoAdicional, Long>{
    
}
