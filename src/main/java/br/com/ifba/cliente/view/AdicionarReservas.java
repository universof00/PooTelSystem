/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.cliente.view;

import br.com.ifba.cliente.entity.Cliente;
import br.com.ifba.hotel.controller.HotelIController;
import br.com.ifba.hotel.entity.Hotel;
import br.com.ifba.infrastructure.windowmanager.WindowManager;
import br.com.ifba.quarto.entity.Quarto;
import br.com.ifba.reserva.controller.ReservaIController;
import br.com.ifba.reserva.entity.Reserva;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdicionarReservas extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdicionarReservas.class.getName());
    
    
    @Autowired
    private WindowManager windowManager;
    @Autowired
    private HotelIController otelcontroller;
    
    private Cliente cliente;
    
    private Quarto quarto;
    
    private Hotel otel;
    
    private BigDecimal total;
    @Autowired
    private ReservaIController reservaIController;
    /*@Autowired
    private ReservaAlteradaListener reservaAlteradaListener;*/
    public AdicionarReservas(HotelIController otelcontroller) {
        this.windowManager =windowManager;
        initComponents();
    }
    
    public void init() {
        this.cliente = windowManager.getClienteSelecionado();
        this.quarto = quarto;
        this.otel = otel;
        this.total = total;
        
        List<Hotel> hoteis = otelcontroller.findAll();

        cbHotel.removeAllItems();
        for (Hotel h : hoteis) {
            cbHotel.addItem(h);
        }     
        cbQuarto.addActionListener(e -> atualizarPrecoTotal());
        jcDataEntrada.addPropertyChangeListener("date", evt -> atualizarPrecoTotal());
        jcDataSaida.addPropertyChangeListener("date", evt -> atualizarPrecoTotal());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblDataEntrada = new javax.swing.JLabel();
        lblHotel = new javax.swing.JLabel();
        btnSavarReserva = new javax.swing.JButton();
        jcDataEntrada = new com.toedter.calendar.JDateChooser();
        jcDataSaida = new com.toedter.calendar.JDateChooser();
        lblDataSaida = new javax.swing.JLabel();
        cbHotel = new javax.swing.JComboBox<>();
        lblQuarto = new javax.swing.JLabel();
        cbQuarto = new javax.swing.JComboBox<>();
        lblPreco = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(607, 607));

        lblTitulo.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lblTitulo.setText("Adicionar Reservas");

        lblDataEntrada.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblDataEntrada.setText("Data de Entrada: ");

        lblHotel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblHotel.setText("Hotel:");

        btnSavarReserva.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSavarReserva.setText("Adicionar Reserva");
        btnSavarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavarReservaActionPerformed(evt);
            }
        });

        jcDataEntrada.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        jcDataSaida.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        lblDataSaida.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblDataSaida.setText("Data de Saída: ");

        cbHotel.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        cbHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHotelActionPerformed(evt);
            }
        });

        lblQuarto.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblQuarto.setText("Quarto:");

        cbQuarto.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        lblPreco.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblPreco.setText("Preço:");

        lblTotal.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N
        lblTotal.setText("jLabel1");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDataEntrada)
                            .addComponent(lblDataSaida)
                            .addComponent(lblHotel)
                            .addComponent(lblQuarto)
                            .addComponent(lblPreco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jcDataEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                .addComponent(jcDataSaida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbHotel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cbQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(btnSavarReserva)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblTitulo)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDataEntrada)
                            .addComponent(jcDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(jcDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblDataSaida))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHotel)
                    .addComponent(cbHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuarto)
                    .addComponent(cbQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPreco)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(btnSavarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void atualizarPrecoTotal() {
        try {
            if (jcDataEntrada.getDate() != null && jcDataSaida.getDate() != null && cbQuarto.getSelectedItem() != null) {
                LocalDate entrada = jcDataEntrada.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate saida = jcDataSaida.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                Quarto q = (Quarto) cbQuarto.getSelectedItem();

                if (saida.isAfter(entrada)) {
                    long dias = ChronoUnit.DAYS.between(entrada, saida);
                    if (dias == 0) {
                        dias = 1;
                    }
                    total = q.getPrecoDiaria().multiply(new BigDecimal(dias));
                    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                    lblTotal.setText(nf.format(total));
                } else {
                    lblTotal.setText("Data Inválida");
                }
            }
        } catch (Exception e) {
            lblTotal.setText("---");
        }
    }
    private void btnSavarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavarReservaActionPerformed
        try {
            Reserva reserva = new Reserva();
            reserva.setDataEntrada(jcDataEntrada.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            reserva.setDataSaida(jcDataSaida.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            reserva.setQuarto((Quarto) cbQuarto.getSelectedItem());
            reserva.setCliente(this.cliente);
            reserva.setHotel(this.otel);
            reserva.setStatus(true);
           
            reserva.setValorTotal(total);

            reservaIController.save(reserva);
            JOptionPane.showMessageDialog(this, "Reserva Salva com Sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSavarReservaActionPerformed

    private void cbHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHotelActionPerformed
        // TODO add your handling code here:
        otel = (Hotel) cbHotel.getSelectedItem();
        cbQuarto.removeAllItems();
        if (otel != null) {
            List<Quarto> quartos = otelcontroller.findQuartosByHotel(otel);
            for (Quarto q : quartos) cbQuarto.addItem(q);
        }
    }//GEN-LAST:event_cbHotelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSavarReserva;
    private javax.swing.JComboBox<Hotel> cbHotel;
    private javax.swing.JComboBox<Quarto> cbQuarto;
    private com.toedter.calendar.JDateChooser jcDataEntrada;
    private com.toedter.calendar.JDateChooser jcDataSaida;
    private javax.swing.JLabel lblDataEntrada;
    private javax.swing.JLabel lblDataSaida;
    private javax.swing.JLabel lblHotel;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblQuarto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    // End of variables declaration//GEN-END:variables
}
