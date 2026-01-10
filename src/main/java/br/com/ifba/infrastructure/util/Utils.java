/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author raiii
 */
public class Utils {
    private Utils() {}

    // ===== TELAS ====
    public static void aplicarTemaTela(JFrame frame) {
        frame.getContentPane().setBackground(TemaUtil.FUNDO_TELA);
        aplicarFonteRecursiva(frame.getContentPane());
    }

    // ===== TÍTULOS =====
    public static void estilizarTitulo(JLabel label) {
        label.setFont(TemaUtil.FONTE_TITULO);
        label.setForeground(TemaUtil.TEXTO_PADRAO);
    }

    // ===== BOTÕES =====
    public static void estilizarBotao(JButton botao) {
        botao.setBackground(TemaUtil.COR_PRIMARIA);
        botao.setForeground(TemaUtil.TEXTO_CLARO);
        botao.setFocusPainted(false);
    }

    // ===== TABELAS =====
    public static void estilizarTabela(JTable tabela) {
        tabela.setBackground(TemaUtil.FUNDO_TABELA);
        tabela.setForeground(TemaUtil.TEXTO_PADRAO);
        tabela.setFont(TemaUtil.FONTE_PADRAO);
        tabela.setRowHeight(26);

        JTableHeader header = tabela.getTableHeader();
        header.setBackground(TemaUtil.COR_PRIMARIA);
        header.setForeground(Color.WHITE);
        header.setFont(TemaUtil.FONTE_PADRAO);
    }

    // ===== TELAS DE ERRO =====
    public static void aplicarTemaErro(JDialog dialog) {
        dialog.getContentPane().setBackground(TemaUtil.ERRO_FUNDO);
        aplicarFonteRecursiva(dialog.getContentPane());
    }

    // ===== MÉTODO INTERNO =====
    private static void aplicarFonteRecursiva(Container container) {
        for (Component c : container.getComponents()) {
            c.setFont(TemaUtil.FONTE_PADRAO);
            if (c instanceof Container) {
                aplicarFonteRecursiva((Container) c);
            }
        }
    }
    
    public static void mostrarErro(Component parent, String mensagem) {

        UIManager.put("OptionPane.background", TemaUtil.ERRO_FUNDO);
        UIManager.put("Panel.background", TemaUtil.ERRO_FUNDO);
        UIManager.put("OptionPane.messageForeground", TemaUtil.ERRO_TEXTO);

        JOptionPane.showMessageDialog(
            parent,
            mensagem,
            "Erro",
            JOptionPane.ERROR_MESSAGE
        );
    }

    public static void mostrarAviso(Component parent, String mensagem) {
        JOptionPane.showMessageDialog(
            parent,
            mensagem,
            "Validação",
            JOptionPane.WARNING_MESSAGE
        );
    }

    public static void mostrarSucesso(Component parent, String mensagem) {
        JOptionPane.showMessageDialog(
            parent,
            mensagem,
            "Sucesso",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
