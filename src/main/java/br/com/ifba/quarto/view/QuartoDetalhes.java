/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.quarto.view;

import br.com.ifba.infrastructure.viewlistener.QuartoAtualizadoListener;
import br.com.ifba.quarto.controller.QuartoIController;
import br.com.ifba.quarto.entity.Quarto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author raiii
 */
@Component
@Scope("prototype")
public class QuartoDetalhes extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(QuartoDetalhes.class.getName());

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private QuartoIController quartoController;

    private Quarto quarto;
    private QuartoAtualizadoListener quartoAtualizadoListener;

    public QuartoDetalhes() {
        initComponents();
    }
    
     public void setQuartoAtualizadoListener(QuartoAtualizadoListener listener) {
        this.quartoAtualizadoListener = listener;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
        carregarQuarto();
    }
    
    private void carregarQuarto() {
        DefaultTableModel model = (DefaultTableModel) tblDetalhesQuarto.getModel();
        model.setRowCount(0);

        model.addRow(new Object[]{"Número", quarto.getNumero()});
        model.addRow(new Object[]{"Tipo", quarto.getTipo()});
        model.addRow(new Object[]{"Capacidade", quarto.getCapacidade()});
        model.addRow(new Object[]{"Diária", quarto.getPrecoDiaria()});
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalhesQuarto = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblDetalhesQuarto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Campo", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tblDetalhesQuarto);

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setText("Editar Dados do Quarto");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir Quarto");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setText("Detalhes do Quarto ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btnEditar)
                        .addGap(67, 67, 67)
                        .addComponent(btnExcluir)))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(166, 166, 166))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        QuartoAtualizar tela = applicationContext.getBean(QuartoAtualizar.class);

        tela.setQuarto(quarto);
        tela.setQuartoAtualizadoListener(quartoAtualizadoListener); // ESSENCIAL
        tela.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int confirmacao = JOptionPane.showConfirmDialog(
        this,
        "Deseja realmente excluir este quarto?",
        "Confirmação",
        JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            try {
                quartoController.deleteById(quarto.getId()); // ✅ AQUI

                if (quartoAtualizadoListener != null) {
                    quartoAtualizadoListener.onQuartoAtualizado();
                }

                JOptionPane.showMessageDialog(this, "Quarto excluído com sucesso!");
                dispose();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                    this,
                    "Erro ao excluir quarto: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDetalhesQuarto;
    // End of variables declaration//GEN-END:variables
}
