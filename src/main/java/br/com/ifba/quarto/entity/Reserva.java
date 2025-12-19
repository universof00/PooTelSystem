/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.quarto.entity;

/**
 *
 * @author User
 */
    import java.time.LocalDate;
    public class Reserva {
    private int id;
    private Cliente cliente;
    private Quarto quarto;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String status; // Ex: "Ativa", "Cancelada"
    
    public Reserva(int id, Cliente cliente, Quarto quarto, LocalDate dataInicio, LocalDate dataFim) {
        this.id = id; this.cliente = cliente;
        this.quarto = quarto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = "Ativa";
        // Bloqueia o quarto ao criar reserva
        if (quarto.isEstaDisponivel()) {
            quarto.setEstaDisponivel(false);
        }
    }
    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Quarto getQuarto() { return quarto; }
    public void setQuarto(Quarto quarto) { this.quarto = quarto; }
    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", cliente=" + cliente.getNome() + ", quarto=" + quarto.getNumero() + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", status='" + status + "'}";
    }
}
