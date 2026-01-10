package br.com.ifba;

import br.com.ifba.cliente.view.ListarClientes;
import br.com.ifba.hotel.view.HotelLitar;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

@SpringBootApplication
public class PooTelSystemApplication {

	public static void main(String[] args) {
            FlatLightLaf.setup();//Ativa o Look and Feel moderno (ANTES do Spring criar os beans)
            
            //arredondam os componentes 
            UIManager.put("Component.arc", 12);
            UIManager.put("Button.arc", 12);
            UIManager.put("TextComponent.arc", 10);
            
            ConfigurableApplicationContext context = new SpringApplicationBuilder(PooTelSystemApplication.class)
              .headless(false).run(args); 
            
            //Abre a tela Swing na EDT (garante que vai abrir na thread correta)
            SwingUtilities.invokeLater(() -> {
            ListarClientes novaTela = context.getBean(ListarClientes.class);
            novaTela.setVisible(true);
            });
             //HotelLitar novaTela = context.getBean(HotelLitar.class);
            //Teste novaTela = context.getBean(Teste.class);
            //novaTela.setVisible(true);
        }
}

