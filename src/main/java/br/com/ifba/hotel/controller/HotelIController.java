/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.hotel.controller;

import br.com.ifba.hotel.entity.Hotel;
import java.util.List;
import org.springframework.stereotype.Controller;

/**
 *
 * @author igo
 */
@Controller
public interface HotelIController {
    Hotel save(Hotel hotel);
    Hotel update(Hotel hotel);
    void delete(String cnpj);
    Hotel findBycnpj(String cnpj);
    Hotel findByNome(String nome);
    List<Hotel> findAll();
}
