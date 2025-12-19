/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.quarto.view;

/**
 *
 * @author PedroLucas
 */
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import br.com.ifba.quarto.controller.ClienteController;
import br.com.ifba.quarto.controller.QuartoController;
import br.com.ifba.quarto.controller.ReservaController;
import br.com.ifba.quarto.entity.Cliente;
import br.com.ifba.quarto.entity.Quarto;
import br.com.ifba.quarto.entity.Reserva;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainView extends JFrame {
    private QuartoController quartoController = new QuartoController();
    private ClienteController clienteController = new ClienteController();
    private ReservaController reservaController = new ReservaController();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public MainView() {
        setTitle("POOtel System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnQuartos = new JButton("Gerenciar Quartos");
        JButton btnClientes = new JButton("Gerenciar Clientes");
        JButton btnReservas = new JButton("Gerenciar Reservas");
        JButton btnSair = new JButton("Sair");

        panel.add(btnQuartos);
        panel.add(btnClientes);
        panel.add(btnReservas);
        panel.add(btnSair);

        add(panel);

        // Ações dos botões
        btnQuartos.addActionListener(e -> abrirMenuQuartos());
        btnClientes.addActionListener(e -> abrirMenuClientes());
        btnReservas.addActionListener(e -> abrirMenuReservas());
        btnSair.addActionListener(e -> System.exit(0));
    }

    private void abrirMenuQuartos() {
        JDialog dialog = new JDialog(this, "Gerenciar Quartos", true);
        dialog.setSize(500, 400);
        dialog.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnCriar = new JButton("Criar");
        JButton btnListar = new JButton("Listar");
        JButton btnAtualizar = new JButton("Atualizar");
        JButton btnDeletar = new JButton("Deletar");
        JButton btnFechar = new JButton("Fechar");

        buttonPanel.add(btnCriar);
        buttonPanel.add(btnListar);
        buttonPanel.add(btnAtualizar);
        buttonPanel.add(btnDeletar);
        buttonPanel.add(btnFechar);

        dialog.add(buttonPanel, BorderLayout.SOUTH);

        // Ações
        btnCriar.addActionListener(e -> criarQuartoDialog());
        btnListar.addActionListener(e -> listarQuartosDialog());
        btnAtualizar.addActionListener(e -> atualizarQuartoDialog());
        btnDeletar.addActionListener(e -> deletarQuartoDialog());
        btnFechar.addActionListener(e -> dialog.dispose());

        dialog.setVisible(true);
    }

    private void criarQuartoDialog() {
        JTextField txtNumero = new JTextField();
        JTextField txtTipo = new JTextField();
        JTextField txtPreco = new JTextField();

        Object[] message = {
            "Número:", txtNumero,
            "Tipo:", txtTipo,
            "Preço Diária:", txtPreco
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Criar Quarto", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                int numero = Integer.parseInt(txtNumero.getText());
                String tipo = txtTipo.getText();
                double preco = Double.parseDouble(txtPreco.getText());
                quartoController.criarQuarto(numero, tipo, preco);
                JOptionPane.showMessageDialog(this, "Quarto criado com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        }
    }

    private void listarQuartosDialog() {
        List<Quarto> quartos = quartoController.listarQuartos();
        String[] columns = {"Número", "Tipo", "Preço Diária", "Disponível"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Quarto q : quartos) {
            model.addRow(new Object[]{q.getNumero(), q.getTipo(), q.getPrecoDiaria(), q.isEstaDisponivel()});
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JOptionPane.showMessageDialog(this, scrollPane, "Lista de Quartos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void atualizarQuartoDialog() {
        JTextField txtNumero = new JTextField();
        JTextField txtTipo = new JTextField();
        JTextField txtPreco = new JTextField();
        JCheckBox chkDisponivel = new JCheckBox("Disponível");

        Object[] message = {
            "Número do Quarto:", txtNumero,
            "Novo Tipo:", txtTipo,
            "Novo Preço:", txtPreco,
            chkDisponivel
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Atualizar Quarto", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                int numero = Integer.parseInt(txtNumero.getText());
                String tipo = txtTipo.getText();
                double preco = Double.parseDouble(txtPreco.getText());
                boolean disponivel = chkDisponivel.isSelected();
                quartoController.atualizarQuarto(numero, tipo, preco, disponivel);
                JOptionPane.showMessageDialog(this, "Quarto atualizado!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        }
    }

    private void deletarQuartoDialog() {
        JTextField txtNumero = new JTextField();
        Object[] message = {"Número do Quarto:", txtNumero};

        int option = JOptionPane.showConfirmDialog(this, message, "Deletar Quarto", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                int numero = Integer.parseInt(txtNumero.getText());
                quartoController.deletarQuarto(numero);
                JOptionPane.showMessageDialog(this, "Quarto deletado!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        }
    }

    // Métodos similares para Clientes e Reservas (implementados de forma análoga)
    private void abrirMenuClientes() {
        // Similar a abrirMenuQuartos, mas para Clientes (Criar, Listar, Atualizar, Deletar)
        // Implemente com JTextField para ID, Nome, CPF, Email, Telefone
        // Use JOptionPane para diálogos e JTable para listagem
        JOptionPane.showMessageDialog(this, "Menu Clientes - Implemente similarmente!");
    }

    private void abrirMenuReservas() {
        // Similar, mas para Reservas (Criar com validação de quarto disponível, Listar, etc.)
        // Campos: ID, Cliente ID, Quarto Número, Data Início, Data Fim
        // Use LocalDate.parse com formatter para datas
        JOptionPane.showMessageDialog(this, "Menu Reservas - Implemente similarmente!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainView().setVisible(true);
        });
    }
}