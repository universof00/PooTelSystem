package br.com.ifba;

import br.com.ifba.cliente.view.ListarClientes;
import br.com.ifba.hotel.view.HotelLitar;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PooTelSystemApplication {

	public static void main(String[] args) {
             ConfigurableApplicationContext context = new SpringApplicationBuilder(PooTelSystemApplication.class)
              .headless(false).run(args); 
              //ListarClientes novaTela = context.getBean(ListarClientes.class);
               HotelLitar novaTela = context.getBean(HotelLitar.class);
      novaTela.setVisible(true);
	}

}
