package br.com.ifba.reserva.service;

import br.com.ifba.reserva.entity.Reserva;
import br.com.ifba.reserva.repository.ReservaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author crisl
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
    
    // Criar reserva 
    public Reserva criarReserva(Reserva reserva){ 
        return reservaRepository.save(reserva); 
    }

    // Listar todas as reservas
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    // Buscar reserva por ID
    public Reserva lerReserva(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    // Atualizar reserva
    public Reserva atualizarReserva(Long id, Reserva novaReserva) {
        Optional<Reserva> opt = reservaRepository.findById(id);
        if (opt.isEmpty()) return null;

        Reserva reserva = opt.get();
        reserva.setDataEntrada(novaReserva.getDataEntrada());
        reserva.setDataSaida(novaReserva.getDataSaida());
        reserva.setStatus(novaReserva.isStatus());

        return reservaRepository.save(reserva);
    }

    // Deletar reserva
    public boolean deletarReserva(Long id) {
        if (reservaRepository.existsById(id)) {
            reservaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
