/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.servico.controller;

import br.com.ifba.servico.entity.ServicoAdicional;
import br.com.ifba.servico.service.ServicoAdicionalService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author crisl
 */
@RestController 
@RequestMapping("/servicos")
public class ServicoAdicionalController {
    
    private final ServicoAdicionalService service;

public ServicoAdicionalController(ServicoAdicionalService service) {
    this.service = service;
}

@PostMapping
public ServicoAdicional salvar(@RequestBody ServicoAdicional servico) {
    return service.salvar(servico);
}

@GetMapping
public List<ServicoAdicional> listarTodos() {
    return service.listarTodos();
}

@GetMapping("/{id}")
public ServicoAdicional buscarPorId(@PathVariable Long id) {
    return service.buscarPorId(id);
}

@PutMapping("/{id}")
public ServicoAdicional atualizar(
        @PathVariable Long id,
        @RequestBody ServicoAdicional novo) {
    return service.atualizar(id, novo);
}

@DeleteMapping("/{id}")
public void deletar(@PathVariable Long id) {
    service.deletar(id);
}
    
}
