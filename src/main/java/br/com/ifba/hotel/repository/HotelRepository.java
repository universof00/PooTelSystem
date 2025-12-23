/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.hotel.repository;

import br.com.ifba.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author igo
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, String>{
    public Hotel findBynome(String nome);
}
