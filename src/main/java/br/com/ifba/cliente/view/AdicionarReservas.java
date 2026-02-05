/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.cliente.view;

import br.com.ifba.cliente.entity.Cliente;
import br.com.ifba.infrastructure.util.Utils;
import br.com.ifba.infrastructure.viewlistener.ReservaAlteradaListener;
import br.com.ifba.infrastructure.windowmanager.WindowManager;
import br.com.ifba.reserva.controller.ReservaIController;
import br.com.ifba.reserva.entity.Reserva;
import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdicionarReservas extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdicionarReservas.class.getName());
    
    
    @Autowired
    private WindowManager windowManager;
    
    private Cliente cliente;
    @Autowired
    private ReservaIController reservaIController;
    /*@Autowired
    private ReservaAlteradaListener reservaAlteradaListener;*/
    public AdicionarReservas() {
        initComponents();
    }
    
     @PostConstruct
    private void init() {
        this.cliente = windowManager.getClienteSelecionado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblValorTotal = new javax.swing.JLabel();
        lblDataEntrada = new javax.swing.JLabel();
        lblDataSaida = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        txtDataEntrada = new javax.swing.JTextField();
        txtDataSaida = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lblTitulo.setText("Adicionar Reservas");

        lblValorTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblValorTotal.setText("Valor Total: ");

        lblDataEntrada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDataEntrada.setText("Data de Entrada: ");

        lblDataSaida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDataSaida.setText("Data de Saída: ");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Adicionar Reserva");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblValorTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDataEntrada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataEntrada))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDataSaida)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataSaida)))))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(221, 221, 221))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorTotal)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataEntrada)
                    .addComponent(txtDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataSaida)
                    .addComponent(txtDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (cliente == null) {
            Utils.mostrarErro(this, "Cliente não informado.");
            return;
        }  
        String valorTxt = txtValorTotal.getText().trim();
        String dataEntradaTxt = txtDataEntrada.getText().trim();
        String dataSaidaTxt = txtDataSaida.getText().trim();

        if (valorTxt.isEmpty() || dataEntradaTxt.isEmpty() || dataSaidaTxt.isEmpty()) {
            Utils.mostrarAviso(this, "Preencha todos os campos.");
            return;
        }

        double valorTotal;
        try {
            valorTotal = Double.parseDouble(valorTxt.replace(",", "."));
        } catch (NumberFormatException e) {
            Utils.mostrarErro(this, "Valor total inválido.");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataEntrada;
        LocalDate dataSaida;

        try {
            dataEntrada = LocalDate.parse(dataEntradaTxt, formatter);
            dataSaida = LocalDate.parse(dataSaidaTxt, formatter);
        } catch (DateTimeParseException e) {
            Utils.mostrarErro(this, "Data inválida. Use o formato dd/MM/yyyy.");
            return;
        }

        Reserva reserva = new Reserva();
        //reserva.setValorTotal(valorTotal);
        reserva.setDataEntrada(dataEntrada);
        reserva.setDataSaida(dataSaida);
        reserva.setStatus(true);
        reserva.setCliente(cliente);

        try {
            reservaIController.save(reserva);
            /*if (reservaAlteradaListener != null) {
                reservaAlteradaListener.onReservaAlterada();
            }*/

            Utils.mostrarSucesso(this, "Reserva cadastrada com sucesso!");
            dispose();

        } catch (RuntimeException e) {
            Utils.mostrarErro(this,
            "Erro ao cadastrar reserva: " + e.getMessage());
}
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblDataEntrada;
    private javax.swing.JLabel lblDataSaida;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JTextField txtDataEntrada;
    private javax.swing.JTextField txtDataSaida;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
