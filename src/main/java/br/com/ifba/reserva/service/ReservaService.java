/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.reserva.service;

import br.com.ifba.reserva.entity.Reserva;
import br.com.ifba.reserva.repository.ReservaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author raiii
 */
@Service
public class ReservaService implements ReservaIService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public void save(Reserva reserva) {
        reservaRepository.save(reserva);
    }
    
    @Override
    public void cancelarReserva(Long idReserva) {
        Reserva reserva = reservaRepository.findById(idReserva)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        reserva.setStatus(false); // cancelada
        reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> findByCliente(Long idCliente) {
        return reservaRepository.findByClienteId(idCliente);
    }
}
