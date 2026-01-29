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
import br.com.ifba.infrastructure.viewlistener.FuncionarioAtualizadoListener;
import br.com.ifba.reserva.controller.ReservaIController;
import br.com.ifba.usuario.controller.UsuarioIController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author raiii
 */
@Component
public class ListarFuncionarios extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ListarFuncionarios.class.getName());

    private TableRowSorter<DefaultTableModel> sorter;
    private DefaultTableModel modelo;
    @Autowired
    private FuncionarioIController funcionarioIController;
    private UsuarioIController usuarioIController;
    public ListarFuncionarios(FuncionarioIController funcionarioIController, UsuarioIController usuarioIController) {
        this.funcionarioIController = funcionarioIController;
        this.usuarioIController = usuarioIController;
        
        initComponents();
        criarModeloTabela();
        configurarTabela();
        configurarAcoesTabela();
        corrigirScroll();
        atualizarTabela();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblPesquisar = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lblTitulo.setText("Listar Funcionários");

        lblPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPesquisar.setText("Pesquisar: ");

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblFuncionarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addComponent(txtPesquisar))
                .addGap(0, 37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void criarModeloTabela() {
        String[] colunas = {"ID", "Nome", "CPF", "Endereço", "Telefone"};

        modelo = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // tabela agora é só visualização
            }
        };

        tblFuncionarios.setModel(modelo);
    }
    public void configurarTabela() {

        // 1) Impede redimensionamento automático
        tblFuncionarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        // 2) OCULTA a coluna ID (índice 0)
        tblFuncionarios.getColumnModel().getColumn(0).setMinWidth(0);
        tblFuncionarios.getColumnModel().getColumn(0).setMaxWidth(0);
        tblFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(0);

        // 3) Ajusta largura das colunas visíveis
        tblFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(220); // Nome
        tblFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(140); // CPF
        tblFuncionarios.getColumnModel().getColumn(3).setPreferredWidth(220); // Endereço
        tblFuncionarios.getColumnModel().getColumn(4).setPreferredWidth(120); // Telefone

        // 4) Aparência
        tblFuncionarios.setRowHeight(30);
        tblFuncionarios.getTableHeader().setFont(
            new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12)
        );
        tblFuncionarios.setFont(
            new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12)
        );
    }

    
    private void configurarAcoesTabela() {

        sorter = new TableRowSorter<>(modelo);
        tblFuncionarios.setRowSorter(sorter);
        
        tblFuncionarios.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getClickCount() == 2) {

                int row = tblFuncionarios.rowAtPoint(e.getPoint());
                int modelRow = tblFuncionarios.convertRowIndexToModel(row);

                Long id = (Long) modelo.getValueAt(modelRow, 0);
                Funcionario funcionario = funcionarioIController.findById(id);

                if (funcionario != null) {
                    FuncionarioAtualizadoListener listener = () -> atualizarTabela();
                    DetalhesFuncionario tela =
                        new DetalhesFuncionario(funcionario, funcionarioIController,usuarioIController, listener);
                        tela.setVisible(true);
                }
            }
        }
    });

    // 🔎 FILTRO DE PESQUISA
        txtPesquisar.getDocument().addDocumentListener(
            new javax.swing.event.DocumentListener() {

                @Override
                public void insertUpdate(javax.swing.event.DocumentEvent e) {
                    filtrarTabela();
                }

                @Override
                public void removeUpdate(javax.swing.event.DocumentEvent e) {
                    filtrarTabela();
                }

                @Override
                public void changedUpdate(javax.swing.event.DocumentEvent e) {
                    filtrarTabela();
                }
            }
        );
    }
    
    public void atualizarTabela() {

        modelo.setRowCount(0);

        List<Funcionario> lista = funcionarioIController.findAll();

        if (lista != null) {
            for (Funcionario f : lista) {
                modelo.addRow(new Object[]{
                    f.getId(),       // coluna 0 (oculta)
                    f.getNome(),     // 1
                    f.getCpf(),      // 2
                    f.getEndereco(),// 3
                    f.getTelefone(),// 4
                });
            }
        }

        tblFuncionarios.revalidate();
        tblFuncionarios.repaint();
    }


    
    private void filtrarTabela() {
        String texto = txtPesquisar.getText().trim();

        if (texto.isEmpty()) {
            sorter.setRowFilter(null); // mostra tudo
        } else {
            sorter.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + texto, 1));
            // (1) é o índice da coluna "Nome"
        }
    }
    
    private void corrigirScroll() {

    // Garante que a tabela esteja SOMENTE no jScrollPane1
    jScrollPane1.setViewportView(tblFuncionarios);

    // Políticas de rolagem corretas
    jScrollPane1.setHorizontalScrollBarPolicy(
        javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    jScrollPane1.setVerticalScrollBarPolicy(
        javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    );

    // Atualiza layout
    jScrollPane1.revalidate();
    jScrollPane1.repaint();
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
