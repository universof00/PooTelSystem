/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.cliente.repository;

import br.com.ifba.cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author raiii
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
