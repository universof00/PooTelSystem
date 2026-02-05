/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.windowmanager;

import br.com.ifba.cliente.entity.Cliente;
import br.com.ifba.funcionario.entity.Funcionario;
import br.com.ifba.hotel.entity.Hotel;
import javax.swing.JFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


@Component 
public class WindowManager {
    @Autowired
    private ApplicationContext context; // O Spring nos dá acesso a todos os componentes
    
    private Cliente clienteSelecionado;
    
    private Funcionario funcionarioSelecionado;
    
    private Hotel hotelSelecionado;
    
    public void setHotelSelecionado(Hotel hotel){
        this.hotelSelecionado = hotel;
    }
    
    public Hotel getHotelSelecionado(){
        return hotelSelecionado;
    }
    
    public void setFuncionarioSelecionado(Funcionario funcionario){
        this.funcionarioSelecionado = funcionario;
    }
    
    public Funcionario getFuncionarioSelecionado(){
        return funcionarioSelecionado;
    }

    public void setClienteSelecionado(Cliente cliente) {
        this.clienteSelecionado = cliente;
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }
    
    // Método genérico para abrir qualquer tela que seja um @Component
    public <T extends JFrame> T open(Class<T> screenClass) {
        T frame = context.getBean(screenClass);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        return frame;
    }

    // Método para fechar a tela atual e abrir outra
    public <T extends JFrame> T navigate(JFrame current, Class<T> nextScreenClass) {
        //current.dispose();
        return open(nextScreenClass);
    }
}
