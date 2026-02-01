/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.funcionario.entity;

import br.com.ifba.hotel.entity.Hotel;
import br.com.ifba.pessoa.entity.Pessoa;
import br.com.ifba.quarto.entity.Quarto;
import br.com.ifba.servico.entity.ServicoAdicional;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author raiii
 */
@Getter
@Setter
@Entity
public class Funcionario extends Pessoa{
    private BigDecimal salario;
    private String servico;
    
    @OneToOne
    @JoinColumn(name = "hotelCnpj")
    private Hotel hotel;
    
    @OneToMany
    @JoinColumn(name = "quartoId")
    private List<Quarto> quartos;
    
    @OneToOne
    @JoinColumn(name = "servicoId")
    private List<ServicoAdicional> servicos;
    
}
