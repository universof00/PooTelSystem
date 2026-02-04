/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.auditoria;

import java.util.ArrayList;
import java.util.List;


public class AuditoriaService {
    private static final List<Auditoria> registros = new ArrayList<>();
    private static final List<Runnable> listeners = new ArrayList<>();

    public static void registrar(String usuario, String acao, String descricao) {
        Auditoria a = new Auditoria(usuario, acao, descricao);
        registros.add(a);
        
        notificar();
    }

    public static List<Auditoria> listar() {
        return new ArrayList<>(registros);
    }

    public static void addListener(Runnable listener) {
        listeners.add(listener);
    }

    private static void notificar() {
        for (Runnable r : listeners) {
            r.run();
        }
    }
    
}
