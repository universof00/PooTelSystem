/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.funcionario.controller;

import br.com.ifba.funcionario.entity.Funcionario;
import java.util.List;

/**
 *
 * @author raiii
 */
public interface FuncionarioIController {
    public Funcionario save(Funcionario funcionario) throws RuntimeException;
    public void delete(Funcionario funcionario) throws RuntimeException;
    public Funcionario update(Funcionario funcionario) throws RuntimeException;
    public List<Funcionario> findAll() throws RuntimeException;
    public Funcionario funcionarioById(Long id) throws RuntimeException;
}
