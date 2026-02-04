/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.cliente.entity;

import br.com.ifba.hotel.entity.Hotel;
import br.com.ifba.pessoa.entity.Pessoa;
import br.com.ifba.reserva.entity.Reserva;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
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
public class Cliente extends Pessoa{
    private String numeroCartao;
    
    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;
    
    @ManyToOne
    @JoinColumn(name = "hotel_cnpj")
    private Hotel hotel;
}
