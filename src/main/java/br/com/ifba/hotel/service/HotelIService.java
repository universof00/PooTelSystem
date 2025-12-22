/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.hotel.service;

import br.com.ifba.hotel.entity.Hotel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author igo
 */
@Service
public interface HotelIService {
    Hotel save(Hotel hotel);
    Hotel update(Hotel hotel);
    void delete(String cnpj);
    Hotel findByCnpj(String cnpj);
    Hotel findByNome(String nome);
    List<Hotel> findAll();
}
