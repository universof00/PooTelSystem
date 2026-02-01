/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.servico.entity;

import br.com.ifba.funcionario.entity.Funcionario;
import br.com.ifba.quarto.entity.Quarto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author crisl
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ServicoAdicional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String descricao;
    private BigDecimal preco;
    
    @ManyToMany(mappedBy = "servicos")
    private List<Quarto> quartos;
    
    @ManyToMany(mappedBy = "servicos")
    private List<Funcionario> funcionarios;
}
