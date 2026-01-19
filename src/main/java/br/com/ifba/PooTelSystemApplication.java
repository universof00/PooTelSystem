package br.com.ifba;

import br.com.ifba.login.view.TelaLogin;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PooTelSystemApplication {

    public static void main(String[] args) {

        FlatLightLaf.setup();

        UIManager.put("Component.arc", 12);
        UIManager.put("Button.arc", 12);
        UIManager.put("TextComponent.arc", 10);

        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(PooTelSystemApplication.class)
                        .headless(false)
                        .run(args);

        SwingUtilities.invokeLater(() -> {
            TelaLogin telaLogin = context.getBean(TelaLogin.class);
            telaLogin.setVisible(true);
        });
    }
}