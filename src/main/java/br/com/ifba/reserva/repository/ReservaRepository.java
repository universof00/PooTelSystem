/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.reserva.repository;

import br.com.ifba.reserva.entity.Reserva;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author raiii
 */
public interface ReservaRepository extends JpaRepository<Reserva, Long>{
    List<Reserva> findByClienteId(Long idCliente);
}
