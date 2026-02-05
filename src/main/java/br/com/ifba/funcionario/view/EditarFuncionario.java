/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.funcionario.view;

import br.com.ifba.funcionario.entity.Funcionario;
import br.com.ifba.infrastructure.util.Utils;
import br.com.ifba.infrastructure.viewlistener.FuncionarioAlteradoListener;
import br.com.ifba.infrastructure.viewlistener.FuncionarioAtualizadoListener;
import br.com.ifba.infrastructure.windowmanager.WindowManager;
import br.com.ifba.login.termosUso.TermosUso;
import br.com.ifba.usuario.controller.UsuarioIController;
import br.com.ifba.usuario.entity.Usuario;
import jakarta.annotation.PostConstruct;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EditarFuncionario extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EditarFuncionario.class.getName());
    
    @Autowired
    private WindowManager windowManager;

    private Funcionario funcionario;
    @Autowired
    private UsuarioIController usuarioIController;
    /*@Autowired
    private FuncionarioAtualizadoListener funcionarioAtualizadoListener;*/
    public EditarFuncionario() { 
        initComponents();
    }
    
    @PostConstruct
    private void init() {
        this.funcionario = windowManager.getFuncionarioSelecionado();

        if (funcionario != null) {
            preencherCampos();
        }
    }

    private void preencherCampos() {
        txtNome.setText(funcionario.getNome());
        txtCpf.setText(funcionario.getCpf());
        txtEndereco.setText(funcionario.getEndereco());
        txtCelular.setText(funcionario.getTelefone());

        Usuario usuario = funcionario.getUsuario();
        txtEmail.setText(usuario.getEmail());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtEndereco = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        lblTítulo = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblCelular = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        lblEndereco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblCpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCpf.setText("CPF: ");

        lblTítulo.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lblTítulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTítulo.setText(" Editar Dados ");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("Nome Completo: ");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("Email: ");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
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
                            .addComponent(txtEmail)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnSalvar)))
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTítulo)
                .addGap(113, 113, 113))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lblTítulo)
                .addGap(38, 38, 38)
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
                .addGap(56, 56, 56)
                .addComponent(btnSalvar)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nome = txtNome.getText().trim();
        String cpf = txtCpf.getText().trim();
        String endereco = txtEndereco.getText().trim();
        String telefone = txtCelular.getText().trim();
        String email = txtEmail.getText().trim();

        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setEndereco(endereco);
        funcionario.setTelefone(telefone);

        Usuario usuario = funcionario.getUsuario();
        usuario.setEmail(email);
        try {
            usuarioIController.update(funcionario, usuario);
            
            /*if (funcionarioAtualizadoListener != null) {
                funcionarioAtualizadoListener.onFuncionarioAtualizado();
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
