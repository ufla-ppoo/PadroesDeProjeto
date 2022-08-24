package guiFactory.elementosGraficosTimao;

import java.awt.Font;
import javax.swing.JTextField;

public class CaixaTextoDoAtletico extends JTextField {

    @Override
    public Font getFont() {
        return new Font(Font.MONOSPACED, Font.BOLD, 12);
    }
    
}
