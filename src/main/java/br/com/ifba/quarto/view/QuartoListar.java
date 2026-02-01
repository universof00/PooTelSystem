/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.quarto.view;

import br.com.ifba.infrastructure.viewlistener.QuartoAtualizadoListener;
import br.com.ifba.quarto.controller.QuartoIController;
import br.com.ifba.quarto.entity.Quarto;
import br.com.ifba.quarto.ennum.TipoQuarto;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author igo
 */
@Component
public class QuartoListar extends javax.swing.JFrame implements QuartoAtualizadoListener{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(QuartoListar.class.getName());
    
    @Autowired
    private QuartoIController quartoController;
    
    TableRowSorter<DefaultTableModel> sorter;
    
    @Autowired
    private QuartoAdicionar quartoAdicionar;
    
    @Autowired
    private ApplicationContext applicationContext;
    
    public QuartoListar(QuartoIController quartoController, ApplicationContext applicationContext) {
        this.quartoController = quartoController;
        this.applicationContext = applicationContext;
        initComponents();
        DefaultTableModel model = (DefaultTableModel) jtListaDeQuartos.getModel();
        sorter = new TableRowSorter<>(model);
        jtListaDeQuartos.setRowSorter(sorter);

        anexarListenerBusca();
        configurarDuploClique();
        carregarQuartos();
    }
    
    public void carregarQuartos() {
        List<Quarto> quartos = quartoController.findAll();
        DefaultTableModel model = (DefaultTableModel) jtListaDeQuartos.getModel();
        model.setRowCount(0);

        for (Quarto q : quartos) {
            model.addRow(new Object[]{
            q.getId(),          // coluna 0 (oculta)
            q.getNumero(),
            q.getTipo(),
            q.getCapacidade(),
            q.getPrecoDiaria()
            });
        }
    }

    private Quarto getQuartoSelecionado() {
        int linhaView = jtListaDeQuartos.getSelectedRow();
        if (linhaView >= 0) {
            int linhaModel = jtListaDeQuartos.convertRowIndexToModel(linhaView);
            Long id = (Long) jtListaDeQuartos.getModel().getValueAt(linhaModel, 0);

            return quartoController.findById(id);
        }
        return null;
    }
    
    private void configurarDuploClique() {
        jtListaDeQuartos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    abrirTelaDetalhes();
                }
            }
        });
    }
    
    private void abrirTelaDetalhes() {
        Quarto quartoSelecionado = getQuartoSelecionado();

        if (quartoSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione um quarto.");
            return;
        }

        QuartoDetalhes tela = applicationContext.getBean(QuartoDetalhes.class);
        tela.setQuarto(quartoSelecionado);
        tela.setQuartoAtualizadoListener(QuartoListar.this);
        tela.setVisible(true);
    }
    
    @Override
    public void onQuartoAtualizado() {
        carregarQuartos();
    }

    
    
    private void anexarListenerBusca() {
          
            Timer filtroTimer = new Timer(300, new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    
                    filtrarTabela();
                }
            });
            
        filtroTimer.setRepeats(false);
        
        txtPesquisar.getDocument().addDocumentListener(new DocumentListener() {

            private void reiniciarTimer() {
               
                if (filtroTimer.isRunning()) {
                    filtroTimer.restart();
                } else {
                    filtroTimer.start();
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                reiniciarTimer();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                reiniciarTimer();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                reiniciarTimer();
            }
        });
    }
    
    private void filtrarTabela() {
        String texto = txtPesquisar.getText().trim();
        // ... lógica de RowFilter usando o sorter
        if (texto.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            try {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
            } catch (java.util.regex.PatternSyntaxException e) {
                sorter.setRowFilter(null);
            }
        }
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaDeQuartos = new javax.swing.JTable();
        lblTextoPesquisar = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdicionar.setText("Adicionar Quarto");
        btnAdicionar.addActionListener(this::btnAdicionarActionPerformed);

        jtListaDeQuartos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nº", "Tipo", "Capacidade", "Diaria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtListaDeQuartos);

        lblTextoPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTextoPesquisar.setText("Pesquisar:");

        lblTitulo.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lblTitulo.setText("Lista de Quartos ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTextoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                                .addComponent(txtPesquisar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(btnAdicionar)))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(187, 187, 187))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblTitulo)
                .addGap(32, 32, 32)
                .addComponent(lblTextoPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdicionar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        //       TODO add your handling code here:
        this.quartoAdicionar.setTelaPrincipal(this);
        this.quartoAdicionar.setVisible(true);
    }//GEN-LAST:event_btnAdicionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtListaDeQuartos;
    private javax.swing.JLabel lblTextoPesquisar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
