/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.auditoria;

import static java.lang.Character.FORMAT;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Auditoria {
    private String usuario;
    private String acao;
    private LocalDateTime dataHora;
    private String descricao;
    
    private static final DateTimeFormatter FORMATO =
            DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");


    public Auditoria(String usuario, String acao, String descricao) {
        this.usuario = usuario;
        this.acao = acao;
        this.descricao = descricao;
        this.dataHora = LocalDateTime.now();
        
    }
    
    @Override
    public String toString() {
        String dataMelhorada = dataHora.format(FORMATO);
        return "[" + dataMelhorada + "] " + usuario + " - " + acao + " → " + descricao;
    }
}
