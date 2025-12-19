/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.reserva.controller;

import br.com.ifba.reserva.entity.Reserva;
import java.util.List;

/**
 *
 * @author raiii
 */
public interface ReservaIController {
    void save(Reserva reserva);
    void cancelarReserva(Long idReserva);
    List<Reserva> findByCliente(Long idCliente);
}

