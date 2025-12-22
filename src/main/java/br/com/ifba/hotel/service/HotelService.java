/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.hotel.service;

import br.com.ifba.hotel.entity.Hotel;
import br.com.ifba.hotel.repository.HotelRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author igo
 */
@Service
@RequiredArgsConstructor
public class HotelService implements HotelIService {
    @Autowired
    private HotelRepository repository;

    @Override
    public Hotel save(Hotel hotel) {
        return repository.save(hotel);
    }

    @Override
    public Hotel update(Hotel hotel) {
        if (repository.existsById(hotel.getCnpj())) {
            return repository.save(hotel);
        }
        throw new RuntimeException("Hotel não encontrado para atualização.");
    }

    @Override
    public void delete(String cnpj) {
        repository.deleteById(cnpj);
    }

    @Override
    public Hotel findByCnpj(String cnpj) {
        return repository.findById(cnpj).orElse(null);
    }

    @Override
    public Hotel findByNome(String nome) {
        return repository.findBynome(nome);
    }

    @Override
    public List<Hotel> findAll() {
        return repository.findAll();
    }
}
