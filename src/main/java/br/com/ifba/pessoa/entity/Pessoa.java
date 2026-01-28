/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.pessoa.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import br.com.ifba.usuario.entity.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author raiii
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // mapeia herança criando uma tabela para a classe pai e uma tabela para cada subclasse, ligadas pelo mesmo ID.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pessoa extends PersistenceEntity{
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;
    
    @OneToOne(mappedBy = "pessoa")
    private Usuario usuario;
}
