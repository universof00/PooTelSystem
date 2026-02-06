
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.reserva.service;

import br.com.ifba.reserva.entity.Reserva;
import java.util.List;

/**
 *
 * @author raiii
 */ 
public interface ReservaIService {
    
    void save(Reserva reserva);
    void cancelarReserva(Long idReserva);
    List<Reserva> findByCliente(Long idCliente);
    public Reserva findById(Long id);

    // Métodos extras do CRUD
    Reserva criarReserva(Reserva reserva);
    List<Reserva> listarReservas();
    Reserva lerReserva(Long id);
    Reserva atualizarReserva(Long id, Reserva novaReserva);
    public void adicionarReserva(Long idCliente, Reserva reserva);
    boolean deletarReserva(Long id);
}
