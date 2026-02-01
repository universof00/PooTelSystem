/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.hotel.view;

import br.com.ifba.hotel.controller.HotelIController;
import br.com.ifba.hotel.entity.Hotel;
import br.com.ifba.infrastructure.viewlistener.HotelAtualizadoListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author raiii
 */
@Component
public class HotelDetalhes extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(HotelDetalhes.class.getName());

    @Autowired
    private ApplicationContext applicationContext;
    private Hotel hotel;
    @Autowired 
    private HotelIController hotelIController;
    private HotelAtualizadoListener hotelAtualizadoListener;
    
    public void setHotelAtualizadoListener(HotelAtualizadoListener listener) {
        this.hotelAtualizadoListener = listener;
    }
    
    public HotelDetalhes() {
        initComponents();
        configurarTabela();
        setLocationRelativeTo(null);
    }
    
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
        carregarHotel();
    }
    
    private void configurarTabela() {
        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"Campo", "Valor"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblDetalhesHotel.setModel(model);
    }
    
    private void carregarHotel() {
        DefaultTableModel model = (DefaultTableModel) tblDetalhesHotel.getModel();
        model.setRowCount(0);

        model.addRow(new Object[]{"CNPJ", hotel.getCnpj()});
        model.addRow(new Object[]{"Nome", hotel.getNome()});
        model.addRow(new Object[]{"Endereço", hotel.getEndereco()});
        model.addRow(new Object[]{"Classificação", hotel.getClassificacao()});
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalhesHotel = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblDetalhesHotel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDetalhesHotel);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setText("Detalhes Hotel ");

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setText("Editar Hotel");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir Hotel");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(190, 190, 190))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addGap(69, 69, 69)
                        .addComponent(btnExcluir)
                        .addGap(144, 144, 144))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(69, 69, 69)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        HotelAtualizar tela = applicationContext.getBean(HotelAtualizar.class);

        tela.setHotelSelecionado(hotel);
        tela.setHotelAtualizadoListener(hotelAtualizadoListener); // 👈 ESSENCIAL
        tela.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            int confirmacao = JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente excluir este hotel?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
            );

            if (confirmacao == JOptionPane.YES_OPTION) {
                hotelIController.delete(hotel.getCnpj());

                if (hotelAtualizadoListener != null) {
                    hotelAtualizadoListener.onHotelAtualizado();
                }

                JOptionPane.showMessageDialog(this, "Hotel excluído com sucesso!");
                dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this,
                "Erro ao excluir hotel: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_btnExcluirActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDetalhesHotel;
    // End of variables declaration//GEN-END:variables
}
