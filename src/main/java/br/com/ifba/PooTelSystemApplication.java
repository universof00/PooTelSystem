package br.com.ifba;

import br.com.ifba.reserva.service.ReservaService;
import br.com.ifba.reserva.view.TelaReserva;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PooTelSystemApplication {

    public static void main(String[] args) {
        FlatLightLaf.setup(); // Look and Feel moderno

        UIManager.put("Component.arc", 12);
        UIManager.put("Button.arc", 12);
        UIManager.put("TextComponent.arc", 10);

        ConfigurableApplicationContext context = new SpringApplicationBuilder(PooTelSystemApplication.class)
                .headless(false).run(args);

        // pega o service do Spring
        ReservaService reservaService = context.getBean(ReservaService.class);

        // abre a tela principal passando o service
        SwingUtilities.invokeLater(() -> {
            TelaReserva tela = new TelaReserva(reservaService);
            tela.setVisible(true);
        });
    }
}
