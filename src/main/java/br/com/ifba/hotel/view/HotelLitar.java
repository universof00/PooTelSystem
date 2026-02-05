/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.hotel.view;

import br.com.ifba.hotel.controller.HotelIController;
import br.com.ifba.hotel.entity.Hotel;
import br.com.ifba.infrastructure.viewlistener.HotelAtualizadoListener;
import br.com.ifba.infrastructure.windowmanager.WindowManager;
import jakarta.annotation.PostConstruct;
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
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @author igo
 */
@Component
@Lazy
public final class HotelLitar extends javax.swing.JFrame{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(HotelLitar.class.getName());
    
    TableRowSorter<DefaultTableModel> sorter;
    
    
    
    /**
     * Creates new form HotelLitar
     */
    @Autowired
    private HotelIController hotelController;
    
    private Hotel novoHotel = new Hotel();
    
    private HotelAdicionar novoHotelAdicionar;
    
    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    private WindowManager windowManager;
            
    public HotelLitar() {
        initComponents();
        configurarAcoesTabela();
        
        DefaultTableModel modelo = (DefaultTableModel) jtListaDeHoteis.getModel();
        sorter = new TableRowSorter<>(modelo);
        jtListaDeHoteis.setRowSorter(sorter);
        anexarListenerBusca();   
    }
    
    @PostConstruct
    public void init() {
        carregarHoteis();
    }
    
    
    private void configurarAcoesTabela() {

        jtListaDeHoteis.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {

                if (e.getClickCount() == 2) {

                    int rowView = jtListaDeHoteis.rowAtPoint(e.getPoint());

                    if (rowView >= 0) {

                        int rowModel = jtListaDeHoteis.convertRowIndexToModel(rowView);

                        String cnpj = (String) jtListaDeHoteis
                                .getModel()
                                .getValueAt(rowModel, 0);

                        Hotel hotel = hotelController.findBycnpj(cnpj);

                        if (hotel != null) {

                            windowManager.setHotelSelecionado(hotel);
                            HotelDetalhes telaDetalhe = windowManager.navigate(HotelLitar.this, HotelDetalhes.class);
                            telaDetalhe.initHotel();
                            init();
                        }
                    }
                }
            }
        });
    }

    
    void carregarHoteis() {

        List<Hotel> hoteis = hotelController.findAll();
        DefaultTableModel model = (DefaultTableModel) jtListaDeHoteis.getModel();
        model.setRowCount(0);
        for (Hotel hotel : hoteis) {
            model.addRow(new Object[]{
                hotel.getCnpj(),
                hotel.getNome(),
                hotel.getEndereco(),
                hotel.getClassificacao()
            });
        }
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
    
    public void adicionarLinhaNaTabela(Hotel novoHotel) {
      
        DefaultTableModel modelo = (DefaultTableModel) jtListaDeHoteis.getModel(); 
        // Adiciona cada curso como linha da tabela
        modelo.addRow(new Object[]{
            novoHotel.getCnpj(),
            novoHotel.getNome(),
            novoHotel.getEndereco(),
            novoHotel.getClassificacao()
        });
    }
    
    public Hotel getHotelSelecionado() {
        int linhaSelecionada = jtListaDeHoteis.getSelectedRow();
        if (linhaSelecionada >= 0) {
            String cnpj = (String) jtListaDeHoteis.getValueAt(linhaSelecionada, 0);
            String nome = (String) jtListaDeHoteis.getValueAt(linhaSelecionada, 1);
            String endereco = (String) jtListaDeHoteis.getValueAt(linhaSelecionada, 2);
            int classificacao = (int) jtListaDeHoteis.getValueAt(linhaSelecionada, 3);
            Hotel hotelSelecionado = new Hotel();
            hotelSelecionado.setCnpj(cnpj);
            hotelSelecionado.setNome(nome);
            hotelSelecionado.setEndereco(endereco);
            hotelSelecionado.setClassificacao(classificacao);
            return hotelSelecionado;
        } else {
            return null;
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaDeHoteis = new javax.swing.JTable();
        lblTextoPesquisar = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtListaDeHoteis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CNPJ", "NOME", "ENDEREÇO", "CLASSIFICAÇÃO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        jScrollPane1.setViewportView(jtListaDeHoteis);

        lblTextoPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTextoPesquisar.setText("Pesquisar : ");

        lblTitulo.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lblTitulo.setText("Lista de Hotéis ");

        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdicionar.setText("Adicionar Novo Hotel");
        btnAdicionar.addActionListener(this::btnAdicionarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTextoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                    .addComponent(txtPesquisar))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(242, 242, 242))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAdicionar)
                        .addGap(249, 249, 249))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(8, 8, 8)
                .addComponent(lblTextoPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdicionar)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        HotelAdicionar tela = new HotelAdicionar(hotelController);
        tela.setTelaPrincipal(this);
        tela.setVisible(true);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtListaDeHoteis;
    private javax.swing.JLabel lblTextoPesquisar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables

}
