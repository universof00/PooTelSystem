/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.funcionario.service;

import br.com.ifba.funcionario.entity.Funcionario;
import br.com.ifba.funcionario.repository.FuncionarioRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author raiii
 */
@AllArgsConstructor
@Service
public class FuncionarioService implements FuncionarioIService{
    private final FuncionarioRepository funcionarioRepository;
    private static final Logger log = LoggerFactory.getLogger(FuncionarioService.class);

    @Override
    public Funcionario save(Funcionario funcionario) throws RuntimeException {
        if(funcionario == null){
           throw new RuntimeException("Dados do " + "funcionário não preenchidos.");
        } else if (funcionario.getId() != null){
           throw new RuntimeException("Funcionário " + "já existente no banco de dados.");
        }else {
           log.info("Salvando funcionário!");
           return funcionarioRepository.save(funcionario);   
        }
    }

    @Override
    public void delete(Funcionario funcionario) throws RuntimeException {
        if (funcionario == null){
            throw new RuntimeException("Dados do " + "funcionário não preenchidos.");
        }else if (funcionario.getId() == null){
            throw new RuntimeException("Funcionário " + "não existente no banco de dados.");
        }else {
            log.info("Excluindo cliente!");
            funcionarioRepository.delete(funcionario);
        }    
    }

    @Override
    public Funcionario update(Funcionario funcionario) throws RuntimeException {
        if (funcionario == null){
            throw new RuntimeException("Dados do " + "funcionário não preenchidos.");
        }else {
            log.info("Atualizando dados do funcionário!");
            return funcionarioRepository.save(funcionario);
        }    }

    @Override
    public List<Funcionario> findAll() throws RuntimeException {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario findById(Long id) throws RuntimeException {
        return funcionarioRepository.findById(id).orElse(null);    }
    
}
