package guiFactory.perfis;

import guiFactory.elementosGraficosTimao.BotaoDoCruzeiro;
import guiFactory.elementosGraficosTimao.CaixaTextoDoCruzeiro;
import guiFactory.elementosGraficosTimao.PainelDoCruzeiro;
import guiFactory.elementosGraficosTimao.RotuloDoCruzeiro;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FabricaDoPerfilDoCruzeiro extends FabricaDePerfis {

    @Override
    public JPanel criarPainel() {        
        return new PainelDoCruzeiro();
    }

    @Override
    public JLabel criarRotulo() {
        return new RotuloDoCruzeiro();
    }

    @Override
    public JButton criarBotao() {
        return new BotaoDoCruzeiro();
    }

    @Override
    public JTextField criarCaixaDeTexto() {
       return new CaixaTextoDoCruzeiro();
    }
    
}
