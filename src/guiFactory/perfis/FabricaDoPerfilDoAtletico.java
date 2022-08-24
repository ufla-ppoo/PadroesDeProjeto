package guiFactory.perfis;

import guiFactory.elementosGraficosTimao.BotaoDoAtletico;
import guiFactory.elementosGraficosTimao.CaixaTextoDoAtletico;
import guiFactory.elementosGraficosTimao.PainelDoAtletico;
import guiFactory.elementosGraficosTimao.RotuloDoAtletico;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Paulo
 */
public class FabricaDoPerfilDoAtletico extends FabricaDePerfis {

    @Override
    public JPanel criarPainel() {        
        return new PainelDoAtletico();
    }

    @Override
    public JLabel criarRotulo() {
        return new RotuloDoAtletico();
    }

    @Override
    public JButton criarBotao() {
        return new BotaoDoAtletico();
    }

    @Override
    public JTextField criarCaixaDeTexto() {
       return new CaixaTextoDoAtletico();
    }
    
}
