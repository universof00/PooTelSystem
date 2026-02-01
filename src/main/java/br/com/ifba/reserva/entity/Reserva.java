/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.reserva.entity;

import br.com.ifba.cliente.entity.Cliente;
import br.com.ifba.hotel.entity.Hotel;
import br.com.ifba.infrastructure.entity.PersistenceEntity;
import br.com.ifba.quarto.entity.Quarto;
import br.com.ifba.servico.entity.ServicoAdicional;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author raiii
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reserva extends PersistenceEntity{
    
    @ManyToOne
    @JoinColumn(name = "quarto_id")
    private Quarto quarto; 

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
        name = "reserva_servico_adicional",
        joinColumns = @JoinColumn(name = "reserva_id"),
        inverseJoinColumns = @JoinColumn(name = "servico_id")
    )
    private List<ServicoAdicional> servicosAdicionais;

    private boolean status;
    private BigDecimal valorTotal;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    @ManyToOne
    @JoinColumn(name = "hotel_cnpj")
    private Hotel hotel;
}
