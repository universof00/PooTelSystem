/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.usuario.entity;

import br.com.ifba.enums.TipoPerfil;
import br.com.ifba.infrastructure.entity.PersistenceEntity;
import br.com.ifba.pessoa.entity.Pessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author raiii
 */
@Getter
@Setter
@Entity
public class Usuario extends PersistenceEntity{
    private String email;
    private String senha;
    
    @Enumerated(EnumType.STRING)
    private TipoPerfil perfil;
    
    @OneToOne
    private Pessoa pessoa;
}
