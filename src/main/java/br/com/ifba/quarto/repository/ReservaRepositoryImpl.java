/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.quarto.repository;

/**
 *
 * @author PedroLucas
 */
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import br.com.ifba.quarto.entity.Reserva;
import java.util.ArrayList;
import java.util.List;

public class ReservaRepositoryImpl implements ReservaRepository {
    private List<Reserva> reservas = new ArrayList<>();

    @Override
    public void save(Reserva reserva) {
        reservas.add(reserva);
    }

    @Override
    public Reserva findById(int id) {
        return reservas.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Reserva> findAll() {
        return reservas;
    }

    @Override
    public void update(Reserva reserva) {
        Reserva existing = findById(reserva.getId());
        if (existing != null) {
            existing.setCliente(reserva.getCliente());
            existing.setQuarto(reserva.getQuarto());
            existing.setDataInicio(reserva.getDataInicio());
            existing.setDataFim(reserva.getDataFim());
            existing.setStatus(reserva.getStatus());
        }
    }

    @Override
    public void delete(int id) {
        reservas.removeIf(r -> r.getId() == id);
    }
}
