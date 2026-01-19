/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

/**
 *
 * @author raiii
 */
public class ValidacaoUtil {
    private ValidacaoUtil() {} // impede instância

    // EMAIL
    public static boolean emailValido(String email) {
        if (email == null || email.isBlank()) return false;

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }

    //TELEFONE (BR)
    public static boolean telefoneValido(String telefone) {
        if (telefone == null || telefone.isBlank()) return false;

        String numeros = telefone.replaceAll("\\D", "");
        return numeros.length() == 10 || numeros.length() == 11;
    }
}
