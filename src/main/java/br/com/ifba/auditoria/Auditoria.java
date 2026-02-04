/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.auditoria;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Auditoria {
    private String usuario;
    private String acao;
    private LocalDateTime dataHora;
    private String descricao;

    public Auditoria(String usuario, String acao, String descricao) {
        this.usuario = usuario;
        this.acao = acao;
        this.descricao = descricao;
        this.dataHora = LocalDateTime.now();
        
    }
    
    @Override
    public String toString() {
        return "[" + dataHora + "] " + usuario + " - " + acao + " → " + descricao;
    }
}
