/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.funcionario.controller;

import br.com.ifba.funcionario.entity.Funcionario;
import br.com.ifba.funcionario.service.FuncionarioIService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 *
 * @author raiii
 */
@AllArgsConstructor
@Controller
public class FuncionarioController implements FuncionarioIController{
    private final FuncionarioIService funcionarioIService;

    @Override
    public Funcionario save(Funcionario funcionario) throws RuntimeException {
        return funcionarioIService.save(funcionario);
    }

    @Override
    public void delete(Funcionario funcionario) throws RuntimeException {
        funcionarioIService.delete(funcionario);
    }

    @Override
    public Funcionario update(Funcionario funcionario) throws RuntimeException {
        return funcionarioIService.update(funcionario);
    }

    @Override
    public List<Funcionario> findAll() throws RuntimeException {
        return funcionarioIService.findAll();
    }

    @Override
    public Funcionario findById(Long id) throws RuntimeException {
        return funcionarioIService.findById(id);
    }
    
}
