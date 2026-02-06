/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.hotel.controller;

import br.com.ifba.hotel.entity.Hotel;
import br.com.ifba.hotel.service.HotelIService;
import br.com.ifba.quarto.entity.Quarto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author igo
 */
@Controller
public class HotelController implements HotelIController {
    @Autowired
    private HotelIService service;

    @Override
    public Hotel save(Hotel hotel) {
        return service.save(hotel);
    }

    @Override
    public Hotel update(Hotel hotel) {
        return service.update(hotel);
    }

    @Override
    public void delete(String cnpj) {
        service.delete(cnpj);
    }

    @Override
    public Hotel findBycnpj(String cnpj) {
        return service.findByCnpj(cnpj);
    }

    @Override
    public Hotel findByNome(String nome) {
        return service.findByNome(nome);
    }

    @Override
    public List<Hotel> findAll() {
        return service.findAll();
    }

    @Override
    public List<Quarto> findQuartosByHotel(Hotel otel) {
        return service.findQuartosByHotel(otel);
    }
}
