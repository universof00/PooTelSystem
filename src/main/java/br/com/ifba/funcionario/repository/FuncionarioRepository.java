/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.funcionario.repository;

import br.com.ifba.funcionario.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author raiii
 */
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    
}
