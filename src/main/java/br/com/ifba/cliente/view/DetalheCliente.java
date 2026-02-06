/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.cliente.view;

import br.com.ifba.cliente.controller.ClienteIController;
import br.com.ifba.cliente.entity.Cliente;
import br.com.ifba.reserva.controller.ReservaIController;
import br.com.ifba.reserva.entity.Reserva;
import br.com.ifba.usuario.controller.UsuarioIController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import br.com.ifba.infrastructure.windowmanager.WindowManager;
import br.com.ifba.usuario.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @author raiii
 */
@Component
@Lazy
public class DetalheCliente extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DetalheCliente.class.getName());
    @Autowired
    private WindowManager windowManager;
    private Cliente cliente;
    private Usuario user;
    @Autowired
    private ClienteIController clienteIController;
    /*@Autowired
    private ClienteAtualizadoListener clienteAtualizadoListener;*/
    @Autowired
    private ReservaIController reservaIController;
    @Autowired
    private UsuarioIController usuarioIController;
    
    public DetalheCliente() {
        initComponents();
        configurarTabelaReservas();
        setLocationRelativeTo(null);
    }
    
    public void initCliente() {
        this.user = windowManager.getUsuarioSelecionado();
        this.cliente = (Cliente) user.getPessoa();
        if (this.cliente != null) {
            carregarDados();
            carregarReservas();
        }
    }
    
    
    private void carregarDados() {
        lblNome.setText("Nome: " + cliente.getNome());
        lblCpf.setText("CPF: " + cliente.getCpf());
        lblTelefone.setText("Telefone: " + cliente.getTelefone());
    }

    public void atualizarDados() {
        lblNome.setText("Nome: " + cliente.getNome());
        lblCpf.setText("CPF: " + cliente.getCpf());
        lblTelefone.setText("Telefone: " + cliente.getTelefone());

        /*if (clienteAtualizadoListener != null) {
            clienteAtualizadoListener.onClienteAtualizado();
        }*/
    }
    
    private void configurarTabelaReservas() {
        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"ID", "Entrada", "Saída", "Valor", "Status"},
            0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblListaReserva.setModel(model);
    }
    
    public void carregarReservas() {
        List<Reserva> reservas = reservaIController.findByCliente(cliente.getId());

        DefaultTableModel model = (DefaultTableModel) tblListaReserva.getModel();
        model.setRowCount(0);

        for (Reserva r : reservas) {
            model.addRow(new Object[]{
                r.getId(),
                r.getDataEntrada(),
                r.getDataSaida(),
                r.getValorTotal(),
                r.isStatus() ? "ATIVA" : "CANCELADA"
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaReserva = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAdicionarReserva = new javax.swing.JButton();
        btnCancelarReserva = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 501));

        tblListaReserva.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblListaReserva);

        lblTitulo.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lblTitulo.setText("Detalhes do Cliente");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("Nome: ");

        lblCpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCpf.setText("CPF: ");

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefone.setText("Telefone: ");

        btnEditar.setText("Editar Cliente");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir Cliente");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAdicionarReserva.setText("Adicionar Reserva");
        btnAdicionarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarReservaActionPerformed(evt);
            }
        });

        btnCancelarReserva.setText("Cancelar Reserva");
        btnCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarReservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdicionarReserva)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarReserva))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblTelefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addComponent(lblNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(169, 169, 169))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        windowManager.setClienteSelecionado(cliente);
        EditarClientes telaEdicao = windowManager.navigate(this, EditarClientes.class);
        telaEdicao.init();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int opc = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente excluir este cliente?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
        );

        if (opc == JOptionPane.YES_OPTION) {
            clienteIController.delete(cliente);
            /*if (clienteAtualizadoListener != null) {
                clienteAtualizadoListener.onClienteAtualizado();
            }*/
            JOptionPane.showMessageDialog(this, "Cliente excluído!");
            dispose(); // fecha a tela de detalhes
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAdicionarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarReservaActionPerformed
        windowManager.setClienteSelecionado(cliente);
        AdicionarReservas telaReserva = windowManager.navigate(this, AdicionarReservas.class);
        telaReserva.init();
        carregarReservas();
    }//GEN-LAST:event_btnAdicionarReservaActionPerformed

    private void btnCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarReservaActionPerformed
        int linha = tblListaReserva.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma reserva.");
            return;
        }

        Long idReserva = (Long) tblListaReserva.getValueAt(linha, 0);
        String status = (String) tblListaReserva.getValueAt(linha, 4);

        if ("CANCELADA".equals(status)) {
            JOptionPane.showMessageDialog(this, "Reserva já está cancelada.");
            return;
        }

        int opc = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente cancelar esta reserva?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
        );

        if (opc == JOptionPane.YES_OPTION) {
            reservaIController.cancelarReserva(idReserva);
            carregarReservas();
            JOptionPane.showMessageDialog(this, "Reserva cancelada com sucesso!");
        }
    }//GEN-LAST:event_btnCancelarReservaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarReserva;
    private javax.swing.JButton btnCancelarReserva;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblListaReserva;
    // End of variables declaration//GEN-END:variables
}
