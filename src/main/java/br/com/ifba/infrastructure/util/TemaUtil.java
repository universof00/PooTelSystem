/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author raiii
 */
public class TemaUtil {
    // ===== CORES PRINCIPAIS =====
    public static final Color FUNDO_TELA = new Color(225, 230, 235);
    public static final Color COR_PRIMARIA = new Color(44, 62, 80);
    public static final Color FUNDO_TABELA = Color.WHITE;
    public static final Color TABELA_LINHA_ALTERNADA = new Color(236, 240, 241);
    public static final Color TEXTO_PADRAO = Color.DARK_GRAY;
    public static final Color TEXTO_CLARO = Color.WHITE;

    // ===== CORES DE ERRO =====
    public static final Color ERRO_FUNDO = new Color(180, 40, 40);
    public static final Color ERRO_TEXTO = Color.WHITE;

    // ===== FONTES =====
    public static final Font FONTE_PADRAO =
            new Font("Segoe UI", Font.PLAIN, 14);
    public static final Font FONTE_TITULO =
            new Font("Segoe UI", Font.BOLD, 18);

    private TemaUtil() {}
}
