/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.dashboard;

import br.com.ifba.auditoria.view.AuditoriaLog;
import br.com.ifba.cliente.view.ListarCliente;
import br.com.ifba.funcionario.view.ListarFuncionarios;
import br.com.ifba.hotel.view.HotelLitar;
import br.com.ifba.infrastructure.windowmanager.WindowManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author igo
 */
@Component
public class DashAdmin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DashAdmin.class.getName());

    private AuditoriaLog auditoriaLog;
    
    @Autowired
    private WindowManager windowManager;
    
    public DashAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAuditoria = new javax.swing.JButton();
        lblImagemAuditoria = new javax.swing.JLabel();
        lblBemVindo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        meMenuPrincipal = new javax.swing.JMenu();
        meCiente = new javax.swing.JMenuItem();
        meFuncionario = new javax.swing.JMenuItem();
        meHotel = new javax.swing.JMenuItem();
        meSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAuditoria.setFont(new java.awt.Font("Liberation Sans", 0, 25)); // NOI18N
        btnAuditoria.setText("Log de Auditoria");
        btnAuditoria.addActionListener(this::btnAuditoriaActionPerformed);

        lblImagemAuditoria.setFont(new java.awt.Font("Liberation Sans", 0, 25)); // NOI18N
        lblImagemAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pootelimag5 (1).jpg"))); // NOI18N

        lblBemVindo.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        lblBemVindo.setText("Seja Bem-Vindo, ");

        jMenuBar1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N

        meMenuPrincipal.setText("Menu");
        meMenuPrincipal.setFont(new java.awt.Font("Liberation Sans", 0, 25)); // NOI18N

        meCiente.setFont(new java.awt.Font("Liberation Sans", 0, 25)); // NOI18N
        meCiente.setText("Cliente");
        meCiente.addActionListener(this::meCienteActionPerformed);
        meMenuPrincipal.add(meCiente);

        meFuncionario.setFont(new java.awt.Font("Liberation Sans", 0, 25)); // NOI18N
        meFuncionario.setText("Funcionario");
        meFuncionario.addActionListener(this::meFuncionarioActionPerformed);
        meMenuPrincipal.add(meFuncionario);

        meHotel.setFont(new java.awt.Font("Liberation Sans", 0, 25)); // NOI18N
        meHotel.setText("Hotel");
        meHotel.addActionListener(this::meHotelActionPerformed);
        meMenuPrincipal.add(meHotel);

        meSobre.setFont(new java.awt.Font("Liberation Sans", 0, 25)); // NOI18N
        meSobre.setText("Sobre");
        meMenuPrincipal.add(meSobre);

        jMenuBar1.add(meMenuPrincipal);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 227, Short.MAX_VALUE)
                .addComponent(lblImagemAuditoria)
                .addGap(221, 221, 221))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lblBemVindo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(362, 362, 362)
                        .addComponent(btnAuditoria)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblBemVindo)
                .addGap(112, 112, 112)
                .addComponent(lblImagemAuditoria)
                .addGap(73, 73, 73)
                .addComponent(btnAuditoria)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuditoriaActionPerformed

        windowManager.navigate(this, AuditoriaLog.class);
    }//GEN-LAST:event_btnAuditoriaActionPerformed

    private void meHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meHotelActionPerformed
        // TODO add your handling code here:
        windowManager.navigate(this, HotelLitar.class);
    }//GEN-LAST:event_meHotelActionPerformed

    private void meFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meFuncionarioActionPerformed
        // TODO add your handling code here:
        windowManager.navigate(this, ListarFuncionarios.class);
    }//GEN-LAST:event_meFuncionarioActionPerformed

    private void meCienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meCienteActionPerformed
        // TODO add your handling code here:
        windowManager.navigate(this, ListarCliente.class);
    }//GEN-LAST:event_meCienteActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAuditoria;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JLabel lblImagemAuditoria;
    private javax.swing.JMenuItem meCiente;
    private javax.swing.JMenuItem meFuncionario;
    private javax.swing.JMenuItem meHotel;
    private javax.swing.JMenu meMenuPrincipal;
    private javax.swing.JMenuItem meSobre;
    // End of variables declaration//GEN-END:variables
}
