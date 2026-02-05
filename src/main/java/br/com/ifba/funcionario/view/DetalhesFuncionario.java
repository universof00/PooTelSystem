/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.funcionario.view;

import br.com.ifba.cliente.view.*;
import br.com.ifba.cliente.controller.ClienteIController;
import br.com.ifba.cliente.entity.Cliente;
import br.com.ifba.funcionario.controller.FuncionarioIController;
import br.com.ifba.funcionario.entity.Funcionario;
import br.com.ifba.reserva.controller.ReservaIController;
import br.com.ifba.reserva.entity.Reserva;
import br.com.ifba.usuario.controller.UsuarioIController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import br.com.ifba.infrastructure.viewlistener.FuncionarioAlteradoListener;
import br.com.ifba.infrastructure.viewlistener.FuncionarioAtualizadoListener;
import br.com.ifba.infrastructure.windowmanager.WindowManager;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DetalhesFuncionario extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DetalhesFuncionario.class.getName());
    
    @Autowired
    private WindowManager windowManager;
    private Funcionario funcionario;
    @Autowired
    private FuncionarioIController funcionarioIController;
    @Autowired
    private UsuarioIController usuarioIController;
    /*@Autowired
    private FuncionarioAtualizadoListener funcionarioAtualizadoListener;*/
    public DetalhesFuncionario() {     
        initComponents();
        configurarTabelaFuncionarios();
    }
    

    private void initCliente() {
        this.funcionario = windowManager.getFuncionarioSelecionado();
        carregarFuncionario(funcionario);
        carregarDados();
    }
    
    private void carregarDados() {
        lblNome.setText("Nome: " + funcionario.getNome());
        lblCpf.setText("CPF: " + funcionario.getCpf());
        lblTelefone.setText("Telefone: " + funcionario.getTelefone());
    }

    public void atualizarDados() {
        lblNome.setText("Nome: " + funcionario.getNome());
        lblCpf.setText("CPF: " + funcionario.getCpf());
        lblTelefone.setText("Telefone: " + funcionario.getTelefone());
    }
    
    private void configurarTabelaFuncionarios() {
        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"Serviço", "Salário"},
            0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblDetalhes.setModel(model);
    }

    
    public void carregarFuncionario(Funcionario funcionario) {
        DefaultTableModel model = (DefaultTableModel) tblDetalhes.getModel();
        model.setRowCount(0);

        model.addRow(new Object[]{
            funcionario.getServico(),
            funcionario.getSalario()
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalhes = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblDetalhes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDetalhes);

        lblTitulo.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lblTitulo.setText("Detalhes do Funcionário");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("Nome: ");

        lblCpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCpf.setText("CPF: ");

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefone.setText("Telefone: ");

        btnEditar.setText("Editar Funcionário");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir Funcionário");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblTelefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                    .addComponent(lblNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(143, 143, 143)
                            .addComponent(lblTitulo)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(btnEditar)
                        .addGap(50, 50, 50)
                        .addComponent(btnExcluir)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        windowManager.setFuncionarioSelecionado(funcionario);
        windowManager.navigate(this, EditarFuncionario.class);
        atualizarDados();
        configurarTabelaFuncionarios();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int opc = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente excluir este funcionário?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
        );

        if (opc == JOptionPane.YES_OPTION) {
            funcionarioIController.delete(funcionario);
            /*if (funcionarioAtualizadoListener != null) {
                funcionarioAtualizadoListener.onFuncionarioAtualizado();
            }*/
            JOptionPane.showMessageDialog(this, "Funcionário excluído!");
            dispose(); // fecha a tela de detalhes
        }
    }//GEN-LAST:event_btnExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblDetalhes;
    // End of variables declaration//GEN-END:variables
}
