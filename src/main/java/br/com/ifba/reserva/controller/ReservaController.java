/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.reserva.controller;

import br.com.ifba.reserva.entity.Reserva;
import br.com.ifba.reserva.service.ReservaIService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author raiii
 */

@Controller
public class ReservaController implements ReservaIController {

    @Autowired
    private ReservaIService reservaIService;

    @Override
    public void save(Reserva reserva) {
        reservaIService.save(reserva);
    }
    
    @Override
    public void cancelarReserva(Long idReserva) {
        reservaIService.cancelarReserva(idReserva);
    }

    @Override
    public List<Reserva> findByCliente(Long idCliente) {
        return reservaIService.findByCliente(idCliente);
    }
    
    @Override
    public Reserva findById(Long id) {
        return reservaIService.findById(id);
    }
}
