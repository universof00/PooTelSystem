/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.cliente.view;

import br.com.ifba.cliente.controller.ClienteIController;
import br.com.ifba.cliente.entity.Cliente;
import br.com.ifba.infrastructure.viewlistener.ClienteAtualizadoListener;
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
public class ListarCliente extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ListarCliente.class.getName());

    private TableRowSorter<DefaultTableModel> sorter;
    private DefaultTableModel modelo;
    @Autowired
    private ClienteIController clienteIController;
    private ReservaIController reservaIController;
    private UsuarioIController usuarioIController;
    public ListarCliente(ClienteIController clienteIController, ReservaIController reservaIController, UsuarioIController usuarioIController) {
        this.clienteIController = clienteIController;
        this.reservaIController = reservaIController;
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

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setText("Listar Clientes");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Pesquisar: ");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                            .addComponent(txtPesquisar))))
                .addGap(0, 37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
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

        tblClientes.setModel(modelo);
    }
    public void configurarTabela() {

        // 1) Impede redimensionamento automático
        tblClientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        // 2) OCULTA a coluna ID (índice 0)
        tblClientes.getColumnModel().getColumn(0).setMinWidth(0);
        tblClientes.getColumnModel().getColumn(0).setMaxWidth(0);
        tblClientes.getColumnModel().getColumn(0).setPreferredWidth(0);

        // 3) Ajusta largura das colunas visíveis
        tblClientes.getColumnModel().getColumn(1).setPreferredWidth(220); // Nome
        tblClientes.getColumnModel().getColumn(2).setPreferredWidth(140); // CPF
        tblClientes.getColumnModel().getColumn(3).setPreferredWidth(220); // Endereço
        tblClientes.getColumnModel().getColumn(4).setPreferredWidth(120); // Telefone

        // 4) Aparência
        tblClientes.setRowHeight(30);
        tblClientes.getTableHeader().setFont(
            new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12)
        );
        tblClientes.setFont(
            new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12)
        );
    }

    
    private void configurarAcoesTabela() {

        sorter = new TableRowSorter<>(modelo);
        tblClientes.setRowSorter(sorter);
        
        tblClientes.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getClickCount() == 2) {

                int row = tblClientes.rowAtPoint(e.getPoint());
                int modelRow = tblClientes.convertRowIndexToModel(row);

                Long id = (Long) modelo.getValueAt(modelRow, 0);
                Cliente cliente = clienteIController.findById(id);

                if (cliente != null) {
                    ClienteAtualizadoListener listener = () -> atualizarTabela();
                    DetalheCliente tela =
                        new DetalheCliente(cliente, clienteIController, listener, reservaIController, usuarioIController);
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

        List<Cliente> lista = clienteIController.findAll();

        if (lista != null) {
            for (Cliente c : lista) {
                modelo.addRow(new Object[]{
                    c.getId(),       // coluna 0 (oculta)
                    c.getNome(),     // 1
                    c.getCpf(),      // 2
                    c.getEndereco(),// 3
                    c.getTelefone(),// 4
                });
            }
        }

        tblClientes.revalidate();
        tblClientes.repaint();
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
    jScrollPane1.setViewportView(tblClientes);

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
