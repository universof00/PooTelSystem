/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.hotel.entity;

import br.com.ifba.cliente.entity.Cliente;
import br.com.ifba.funcionario.entity.Funcionario;
import br.com.ifba.quarto.entity.Quarto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
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
@Getter @Setter
public class Hotel {
    @Id
    private String cnpj;
    private String nome;
    private String endereco;
    private int classificacao;
    
    @OneToMany(mappedBy = "hotel")
    private List<Cliente> clientes;
    
    @OneToMany(mappedBy = "hotel")
    private List<Funcionario> funcionarios;
    
    @OneToMany(mappedBy = "hotel")
    private List<Quarto> quartos;
    
    @Override
    public String toString() {
        return nome + " (" + cnpj + ")";
    }

}
