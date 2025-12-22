/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.hotel.view;

import br.com.ifba.hotel.controller.HotelIController;
import br.com.ifba.hotel.entity.Hotel;
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
public final class HotelLitar extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(HotelLitar.class.getName());
    
    TableRowSorter<DefaultTableModel> sorter;
    
    
    
    /**
     * Creates new form HotelLitar
     */
    @Autowired
    private HotelIController hotelController;
    
    @Autowired
    private Hotel novoHotel;
    
    @Autowired
    private HotelAdicionar novoHotelAdicionar;
    
    @Autowired
    private ApplicationContext applicationContext;
    
            
    public HotelLitar(HotelIController hotelController, ApplicationContext applicationContext) {
        this.hotelController = hotelController;
        this.applicationContext = applicationContext;
        initComponents();
        carregarHoteis();
        DefaultTableModel modelo = (DefaultTableModel) jtListaDeHoteis.getModel();
        
        sorter = new TableRowSorter<>(modelo);
        jtListaDeHoteis.setRowSorter(sorter); // Ativa ordenação automática na tabela
        anexarListenerBusca();
        
         btnEditar.setVisible(false);
         btnApagar.setVisible(false);
         
         
         
         /**
         * Listener para detectar seleção de linhas na tabela.
         * Faz com que os botões "Editar" e "Apagar" só apareçam se existir seleção.
         */
        jtListaDeHoteis.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) { 
                
                // Lógica de verificação embutida
                int linhaSelecionadaView = jtListaDeHoteis.getSelectedRow();
                boolean linhaEhSelecionada = (linhaSelecionadaView >= 0);
                
                // Define a visibilidade
                btnEditar.setVisible(linhaEhSelecionada);
                btnApagar.setVisible(linhaEhSelecionada);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaDeHoteis = new javax.swing.JTable();
        lblTextoPesquisar = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAdicionar.setText("Adicionar Hotel");
        btnAdicionar.addActionListener(this::btnAdicionarActionPerformed);

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

        lblTextoPesquisar.setText("Pesquisar ");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(this::btnEditarActionPerformed);

        btnApagar.setText("Apagar");
        btnApagar.addActionListener(this::btnApagarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblTextoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(83, 83, 83)
                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnEditar)
                .addGap(37, 37, 37)
                .addComponent(btnApagar)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTextoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditar)
                        .addComponent(btnApagar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:
        this.novoHotelAdicionar.setTelaPrincipal(this);
        this.novoHotelAdicionar.setVisible(true);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        // TODO add your handling code here:
        Hotel hotelParaDeletar = getHotelSelecionado();
    
        if (hotelParaDeletar == null) {
            JOptionPane.showMessageDialog(this, "Nenhum Hotel foi selecionado para apagar.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(
                this, 
                "AVISO! O HOTEL SERÁ APAGADO!\nTem certeza que deseja continuar?",
                "Apagar HOTEL",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirmacao == JOptionPane.YES_OPTION) {
            try {
                // 1. CHAMA O CONTROLLER INJETADO para realizar a operação.
                // A verificação de existência será feita implicitamente no Service/DAO.
                hotelController.delete(hotelParaDeletar.getCnpj()); 

                JOptionPane.showMessageDialog(this,
                    "Hotel '" + hotelParaDeletar.getNome() + "' apagado com sucesso!");

                // 2. Atualiza a lista
                carregarHoteis();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                    "Erro ao apagar Hotel: " + e.getMessage() + "\nO ID pode não existir ou há restrições de chave estrangeira.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);

                e.printStackTrace(); // para debug no console
            }
        }
    }//GEN-LAST:event_btnApagarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        Hotel hotelParaAtualizar = getHotelSelecionado();
    
        if (hotelParaAtualizar == null) {
            JOptionPane.showMessageDialog(this, "Nenhum Hotel foi selecionado para editar.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Chamada ao Controller para verificar a existência (baseado no seu código original)
        Hotel validarAtualizar = hotelController.findBycnpj(hotelParaAtualizar.getCnpj());

        if (validarAtualizar != null) {

           
            HotelAtualizar telaAtualizar = applicationContext.getBean(HotelAtualizar.class);

            // 2. CHAMADA DOS SETTERS: Aqui você passa os dados e a referência da tela principal
            //telaAtualizar.setHotelSelecionado(validarAtualizar); 
            telaAtualizar.setHotelSelecionado(validarAtualizar);
            telaAtualizar.setTelaPrincipal(this);              
                
            // 3. Torna a tela visível
            telaAtualizar.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this, "O Hotel selecionado não foi encontrado no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtListaDeHoteis;
    private javax.swing.JLabel lblTextoPesquisar;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
