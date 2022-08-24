package guiFactory.perfis;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Paulo
 */
public abstract class FabricaDePerfis {
       public abstract JPanel criarPainel();
       public abstract JLabel criarRotulo();
       public abstract JButton criarBotao();
       public abstract JTextField criarCaixaDeTexto();
}
