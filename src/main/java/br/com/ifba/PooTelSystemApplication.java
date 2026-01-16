package br.com.ifba;

import br.com.ifba.cliente.view.ListarClientes;
import br.com.ifba.hotel.view.HotelLitar;
import br.com.ifba.reserva.service.ReservaService;
import br.com.ifba.reserva.view.TelaReserva;
import br.com.ifba.view.TelaPrincipal;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

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
            TelaPrincipal novaTela = context.getBean(TelaPrincipal.class);
            //ListarClientes novaTela = context.getBean(ListarClientes.class);
            //HotelLitar novaTela = context.getBean(HotelLitar.class);
            //TelaReserva novaTela = context.getBean(TelaReserva.class);
            novaTela.setVisible(true);
            });
    }
}
