/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.quarto.service;

import br.com.ifba.auditoria.AuditoriaService;
import br.com.ifba.quarto.entity.Quarto;
import br.com.ifba.quarto.repository.QuartoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author igo
 */
@Service
public class QuartoService implements QuartoIService {
    
    @Autowired
    private QuartoRepository repository;

    public Quarto save(Quarto quarto) {
        AuditoriaService.registrar(quarto.getNumero(), "SALVAR", "Salvando Dados" + quarto.getId());
        return repository.save(quarto);
    }

    public void delete(Long id) {
        AuditoriaService.registrar(findById(id).getNumero(), "EXCLUIR", "Excluindo Dados" + id);
        repository.deleteById(id);
    }

    public Quarto update(Quarto quarto) {
        AuditoriaService.registrar(quarto.getNumero(), "ATUALIZAR", "Atualizando Dados" + quarto.getId());
        return repository.save(quarto);
    }

    public List<Quarto> findAll() {
        return repository.findAll();
    }

    public Quarto findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Quarto não encontrado"));
    }

    public Quarto findBynumero(String numero) {
        return repository.findBynumero(numero);
    }
}
