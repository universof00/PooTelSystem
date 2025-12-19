/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.quarto.service;

/**
 *
 * @author PedroLucas
 */
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import br.com.ifba.quarto.entity.Reserva;
import br.com.ifba.quarto.entity.Quarto;
import br.com.ifba.quarto.entity.Cliente;
import br.com.ifba.quarto.repository.ReservaRepository;
import br.com.ifba.quarto.repository.ReservaRepositoryImpl;
import br.com.ifba.quarto.repository.QuartoRepository;
import br.com.ifba.quarto.repository.QuartoRepositoryImpl;
import br.com.ifba.quarto.repository.ClienteRepository;
import br.com.ifba.quarto.repository.ClienteRepositoryImpl;
import java.util.List;

public class ReservaService {
    private ReservaRepository reservaRepository = new ReservaRepositoryImpl();
    private QuartoRepository quartoRepository = new QuartoRepositoryImpl();
    private ClienteRepository clienteRepository = new ClienteRepositoryImpl();

    public void criarReserva(Reserva reserva) {
        // Validação: Verificar se o quarto está disponível
        Quarto quarto = reserva.getQuarto();
        if (!quarto.isEstaDisponivel()) {
            throw new IllegalArgumentException("Quarto não está disponível!");
        }
        // Verificar se o cliente existe
        Cliente cliente = reserva.getCliente();
        if (clienteRepository.findById(cliente.getId()) == null) {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }
        reservaRepository.save(reserva);
    }

    public Reserva buscarReserva(int id) {
        return reservaRepository.findById(id);
    }

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public void atualizarReserva(Reserva reserva) {
        reservaRepository.update(reserva);
    }

    public void deletarReserva(int id) {
        Reserva reserva = reservaRepository.findById(id);
        if (reserva != null) {
            // Liberar o quarto ao deletar reserva
            reserva.getQuarto().setEstaDisponivel(true);
            reservaRepository.delete(id);
        }
    }

    public Quarto buscarQuarto(int quartoNumero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Cliente buscarCliente(int clienteId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
