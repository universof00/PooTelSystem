/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.login.termosUso;

import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author igo
 */
public class TermosUso {
    public void abrirTermos() {
        try {
            File pdf = new File("src/main/java/br/com/ifba/login/termosUso/TermosUso.pdf");
            if (pdf.exists()) {
                Desktop.getDesktop().open(pdf);
            } else {
                JOptionPane.showMessageDialog(null, "PDF não encontrado", "ERRO 666", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
