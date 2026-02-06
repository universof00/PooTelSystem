/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.quarto.entity;

import br.com.ifba.funcionario.entity.Funcionario;
import br.com.ifba.hotel.entity.Hotel;
import br.com.ifba.quarto.ennum.EstadoQuarto;
import br.com.ifba.quarto.ennum.TipoQuarto;
import br.com.ifba.servico.entity.ServicoAdicional;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author igo
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "quartos")
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private int capacidade;
    private BigDecimal precoDiaria;
    
    @Enumerated(EnumType.STRING)
    private TipoQuarto tipo;
    
    @Enumerated(EnumType.STRING)
    private EstadoQuarto estado;
    
    @ManyToOne
    @JoinColumn(name = "hotel_cnpj")
    private Hotel hotel;
    
    @ManyToMany
     @JoinTable(
    name = "quarto_servico",
    joinColumns = @JoinColumn(name = "quarto_id"),
    inverseJoinColumns = @JoinColumn(name = "servico_id")
    )
    private List<ServicoAdicional> servicos;
    
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario responsavel;
    
    @Override
    public String toString() {
        return "Quarto " + this.numero + " - Diária: R$ " + this.precoDiaria;
    }
}
