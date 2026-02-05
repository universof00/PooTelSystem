/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.cliente.view;

import br.com.ifba.cliente.controller.ClienteIController;
import br.com.ifba.cliente.entity.Cliente;
import br.com.ifba.infrastructure.util.Utils;
import br.com.ifba.usuario.controller.UsuarioIController;
import br.com.ifba.usuario.entity.Usuario;
import javax.swing.JOptionPane;
import org.springframework.stereotype.Component;
import br.com.ifba.infrastructure.viewlistener.ClienteAlteradoListener;
import br.com.ifba.infrastructure.viewlistener.ClienteAtualizadoListener;
import br.com.ifba.infrastructure.windowmanager.WindowManager;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class EditarClientes extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EditarClientes.class.getName());
    
    @Autowired
    private WindowManager windowManager;
    
    private Cliente cliente;
    @Autowired
    private UsuarioIController usuarioIController;
    @Autowired
    private ClienteIController clienteIController;
    /*@Autowired
    private ClienteAtualizadoListener clienteAtualizadoListener;*/
    
    public EditarClientes() {
        initComponents();
        setLocationRelativeTo(null);
    }
    

    public void init() {
        this.cliente = windowManager.getClienteSelecionado();

        if (cliente != null) {
            preencherCampos();
        }
    }

    private void preencherCampos() {
        txtNome.setText(cliente.getNome());
        txtCpf.setText(cliente.getCpf());
        txtEndereco.setText(cliente.getEndereco());
        txtCelular.setText(cliente.getTelefone());

        Usuario usuario = cliente.getUsuario();
        txtEmail.setText(usuario.getEmail());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTítulo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCelular = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTítulo.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lblTítulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTítulo.setText("Editar Dados");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("Nome Completo: ");

        lblCelular.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCelular.setText("Celular: ");

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSalvar.setText("Salvar Novos Dados");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblEndereco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEndereco.setText("Endereço: ");

        lblCpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCpf.setText("CPF: ");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("Email: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTítulo, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblEmail)
                                    .addComponent(lblCpf)
                                    .addComponent(lblEndereco)
                                    .addComponent(lblCelular)
                                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                    .addComponent(lblNome)
                                    .addComponent(txtCelular)
                                    .addComponent(txtEndereco)
                                    .addComponent(txtCpf)
                                    .addComponent(txtEmail))
                                .addGap(8, 8, 8))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btnSalvar)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(lblTítulo)
                .addGap(34, 34, 34)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCelular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btnSalvar)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nome = txtNome.getText().trim();
        String cpf = txtCpf.getText().trim();
        String endereco = txtEndereco.getText().trim();
        String telefone = txtCelular.getText().trim();
        String email = txtEmail.getText().trim();

        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
        cliente.setTelefone(telefone);

        Usuario usuario = cliente.getUsuario();
        usuario.setEmail(email);
        try {
            usuarioIController.update(cliente, usuario);
            /*if (clienteAtualizadoListener != null) {
                clienteAtualizadoListener.onClienteAtualizado();
            }*/
            Utils.mostrarSucesso(this, "Dados atualizados com sucesso!");
            dispose();
        } catch (RuntimeException e) {
            Utils.mostrarErro(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTítulo;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
