/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.quarto.view;

import br.com.ifba.infrastructure.viewlistener.QuartoAtualizadoListener;
import br.com.ifba.infrastructure.windowmanager.WindowManager;
import br.com.ifba.quarto.controller.QuartoIController;
import br.com.ifba.quarto.ennum.EstadoQuarto;
import br.com.ifba.quarto.entity.Quarto;
import br.com.ifba.quarto.ennum.TipoQuarto;
import java.math.BigDecimal;
import javax.swing.DefaultComboBoxModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @author igo
 */

@Component
@Lazy
public class QuartoAtualizar extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(QuartoAtualizar.class.getName());

    @Autowired
    private WindowManager windowManager;
    private Quarto quarto;
    
    @Autowired
    private QuartoIController quartoControler;

    public QuartoAtualizar() {
        initComponents(); 
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(TipoQuarto.values()));
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(EstadoQuarto.values()));
        
    }
    
    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
        preencherCampos();
    }

    public void init() {
        this.quarto = windowManager.getQuartoSelecionado();

        if (quarto != null) {
            setQuarto(quarto);
        }
    }
    
    private void preencherCampos() {
        txtNumero.setText(quarto.getNumero());
        txtNumero.setEnabled(false); // número NÃO muda

        cbTipo.setSelectedItem(quarto.getTipo());
        txtCapacidade.setText(String.valueOf(quarto.getCapacidade()));
        txtPrecoDiaria.setText(quarto.getPrecoDiaria().toString());
        cbEstado.setSelectedItem(quarto.getEstado());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblQuartoTexto = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        txtCapacidade = new javax.swing.JTextField();
        lblPrecoDiaria = new javax.swing.JLabel();
        txtPrecoDiaria = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        cbTipo = new javax.swing.JComboBox<>();
        lblEstado = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblQuartoTexto.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lblQuartoTexto.setText(" Atualizar Quarto");

        lblNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNumero.setText("Número: ");

        lblTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTipo.setText("Tipo do Quarto");

        lblQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblQuantidade.setText("Capacidade");

        lblPrecoDiaria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPrecoDiaria.setText("Preco Diaria");

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalvar.setText("Salvar Novos Dados");
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);

        lblEstado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEstado.setText("Estado do Quarto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, 309, Short.MAX_VALUE)
                                .addComponent(lblEstado, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNumero, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 40, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTipo)
                            .addComponent(lblNumero)
                            .addComponent(lblPrecoDiaria)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, 309, Short.MAX_VALUE)
                                .addComponent(txtPrecoDiaria, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(lblQuantidade))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblQuartoTexto)
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addGap(118, 118, 118))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblQuartoTexto)
                .addGap(18, 18, 18)
                .addComponent(lblNumero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblQuantidade)
                .addGap(18, 18, 18)
                .addComponent(txtCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPrecoDiaria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecoDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnSalvar)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        quarto.setTipo((TipoQuarto) cbTipo.getSelectedItem());
        quarto.setCapacidade(Integer.parseInt(txtCapacidade.getText().trim()));
        quarto.setPrecoDiaria(new BigDecimal(txtPrecoDiaria.getText().trim()));
        quarto.setEstado((EstadoQuarto) cbEstado.getSelectedItem());

        quartoControler.save(quarto); // UPDATE real


        dispose();    
    }//GEN-LAST:event_btnSalvarActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<EstadoQuarto> cbEstado;
    private javax.swing.JComboBox<TipoQuarto> cbTipo;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblPrecoDiaria;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblQuartoTexto;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTextField txtCapacidade;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPrecoDiaria;
    // End of variables declaration//GEN-END:variables
}
