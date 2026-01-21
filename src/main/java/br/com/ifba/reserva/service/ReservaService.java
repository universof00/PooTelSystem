package br.com.ifba.reserva.service;

import br.com.ifba.cliente.entity.Cliente;
import br.com.ifba.cliente.repository.ClienteRepository;
import br.com.ifba.cliente.service.ClienteService;
import br.com.ifba.reserva.entity.Reserva;
import br.com.ifba.reserva.repository.ReservaRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author crisl
 */
@AllArgsConstructor
@Service
public class ReservaService implements ReservaIService {

    
    @Autowired
    private ReservaRepository reservaRepository;

    private final ClienteRepository clienteRepository;
    
    private static final Logger log = LoggerFactory.getLogger(ClienteService.class);

    @Override
    public void save(Reserva reserva) {
        reservaRepository.save(reserva);
    }
    
    
    public void adicionarReserva(Long idCliente, Reserva reserva){
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow();
        
        if (reserva.getDataSaida().isBefore(reserva.getDataEntrada())) {
        throw new IllegalArgumentException(
            "A data de saída deve ser depois da data de entrada.");
        }
        reserva.setCliente(cliente);
        reserva.setStatus(true);
        log.info("Reserva realizada!");
        reservaRepository.save(reserva);
    }
    
      @Override
    public void cancelarReserva(Long idReserva){
        Reserva reserva = reservaRepository.findById(idReserva).orElseThrow();
        reserva.setStatus(false);
        log.info("Reserva cancelada!");
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
