package guiFactory.elementosGraficosTimao;

import java.awt.Font;
import javax.swing.JTextField;

public class CaixaTextoDoCruzeiro extends JTextField {
    
    @Override
    public Font getFont() {
        return new Font(Font.SANS_SERIF, Font.ITALIC, 14);
    }
}
