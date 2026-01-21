/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.servico.service;

import br.com.ifba.servico.entity.ServicoAdicional;
import java.util.List;

/**
 *
 * @author crisl
 */
public interface ServicoAdicionalIService {
    
    ServicoAdicional salvar(ServicoAdicional servico);
    List<ServicoAdicional> listarTodos();
    ServicoAdicional buscarPorId(Long id);
    ServicoAdicional atualizar(Long id, ServicoAdicional novo);
    void deletar(Long id);
}
