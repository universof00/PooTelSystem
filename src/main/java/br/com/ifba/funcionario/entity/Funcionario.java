/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.funcionario.entity;

import br.com.ifba.pessoa.entity.Pessoa;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author raiii
 */
@Getter
@Setter
@Entity
public class Funcionario extends Pessoa{
    private Long salario;
    private String servico;
}
