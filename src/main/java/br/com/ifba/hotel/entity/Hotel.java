/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 *
 * @author igo
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hoteis")
@Component
public class Hotel {
    @Id
    @Getter @Setter private String cnpj;
    @Getter @Setter private String nome;
    @Getter @Setter private String endereco;
    @Getter @Setter private int classificacao;
}
