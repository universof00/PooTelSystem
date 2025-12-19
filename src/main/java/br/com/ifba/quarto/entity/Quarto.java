/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.quarto.entity;

public class Quarto {
    private int numero;
    private String tipo; // Ex: "Simples", "Luxo"
    private double precoDiaria;
    private boolean estaDisponivel;

    public Quarto(int numero, String tipo, double precoDiaria) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoDiaria = precoDiaria;
        this.estaDisponivel = true; // Por padrão, disponível
    }

    // Getters e Setters
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getPrecoDiaria() { return precoDiaria; }
    public void setPrecoDiaria(double precoDiaria) { this.precoDiaria = precoDiaria; }

    public boolean isEstaDisponivel() { return estaDisponivel; }
    public void setEstaDisponivel(boolean estaDisponivel) { this.estaDisponivel = estaDisponivel; }

    @Override
    public String toString() {
        return "Quarto{" + "numero=" + numero + ", tipo='" + tipo + "', precoDiaria=" + precoDiaria + ", estaDisponivel=" + estaDisponivel + '}';
    }
}
