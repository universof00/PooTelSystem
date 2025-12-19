package br.com.ifba;

import br.com.ifba.cliente.view.ListarClientes;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PooTelSystemApplication {

	public static void main(String[] args) {
             ConfigurableApplicationContext context = new SpringApplicationBuilder(PooTelSystemApplication.class)
              .headless(false).run(args); 
      /*Teste novaTela = context.getBean(Teste.class);
      novaTela.setVisible(true);*/
        ListarClientes tela = context.getBean(ListarClientes.class);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
	}

}
