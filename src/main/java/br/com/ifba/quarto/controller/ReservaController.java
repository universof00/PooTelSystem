/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.quarto.controller;

/**
 *
 * @author User
 */
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import br.com.ifba.quarto.entity.Reserva;
import br.com.ifba.quarto.entity.Cliente;
import br.com.ifba.quarto.entity.Quarto;
import br.com.ifba.quarto.service.ReservaService;
import java.time.LocalDate;
import java.util.List;

public class ReservaController {
    private ReservaService service = new ReservaService();

    public void criarReserva(int id, int clienteId, int quartoNumero, LocalDate dataInicio, LocalDate dataFim) {
        Cliente cliente = service.buscarCliente(clienteId); // Assumindo que ReservaService tem acesso
        Quarto quarto = service.buscarQuarto(quartoNumero); // Assumindo que ReservaService tem acesso
        if (cliente == null || quarto == null) {
            throw new IllegalArgumentException("Cliente ou Quarto não encontrado!");
        }
        Reserva reserva = new Reserva(id, cliente, quarto, dataInicio, dataFim);
        service.criarReserva(reserva);
    }

    public Reserva buscarReserva(int id) {
        return service.buscarReserva(id);
    }

    public List<Reserva> listarReservas() {
        return service.listarReservas();
    }

    public void atualizarReserva(int id, int clienteId, int quartoNumero, LocalDate dataInicio, LocalDate dataFim, String status) {
        Reserva reserva = service.buscarReserva(id);
        if (reserva != null) {
            Cliente cliente = service.buscarCliente(clienteId);
            Quarto quarto = service.buscarQuarto(quartoNumero);
            if (cliente != null && quarto != null) {
                reserva.setCliente(cliente);
                reserva.setQuarto(quarto);
                reserva.setDataInicio(dataInicio);
                reserva.setDataFim(dataFim);
                reserva.setStatus(status);
                service.atualizarReserva(reserva);
            }
        }
    }

    public void deletarReserva(int id) {
        service.deletarReserva(id);
    }
}
