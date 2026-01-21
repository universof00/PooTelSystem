/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.servico.service;

import br.com.ifba.servico.entity.ServicoAdicional;
import br.com.ifba.servico.repository.ServicoAdicionalRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author crisl
 */
@Service
public class ServicoAdicionalService implements ServicoAdicionalIService{
    
   private final ServicoAdicionalRepository repository;

public ServicoAdicionalService(ServicoAdicionalRepository repository) {
    this.repository = repository;
}

// Criar
public ServicoAdicional salvar(ServicoAdicional servico) {
    return repository.save(servico);
}

// Ler todos
public List<ServicoAdicional> listarTodos() {
    return repository.findAll();
}

// Ler por ID
public ServicoAdicional buscarPorId(Long id) {
    return repository.findById(id).orElse(null);
}

// Atualizar
public ServicoAdicional atualizar(Long id, ServicoAdicional novo) {
    ServicoAdicional servico = repository.findById(id).orElseThrow();
    servico.setNome(novo.getNome());
    servico.setDescricao(novo.getDescricao());
    servico.setPreco(novo.getPreco());
    return repository.save(servico);
}

// Deletar
public void deletar(Long id) {
    repository.deleteById(id);
}

}
