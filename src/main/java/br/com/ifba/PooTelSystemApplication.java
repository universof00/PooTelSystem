package br.com.ifba;

import br.com.ifba.servico.view.ServicoAdicionalView;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class PooTelSystemApplication {

    public static void main(String[] args) {
        // Configuração visual (FlatLaf)
        FlatLightLaf.setup();
        UIManager.put("Component.arc", 12);
        UIManager.put("Button.arc", 12);
        UIManager.put("TextComponent.arc", 10);

        // Abre apenas a tela de Serviços Adicionais
        SwingUtilities.invokeLater(() -> {
            ServicoAdicionalView telaServico = new ServicoAdicionalView();
            telaServico.setVisible(true);
        });
    }
}
