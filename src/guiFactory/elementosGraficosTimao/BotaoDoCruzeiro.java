package guiFactory.elementosGraficosTimao;

import java.awt.Color;
import javax.swing.JButton;

public class BotaoDoCruzeiro extends JButton {

    @Override
    public Color getBackground() {
        return new Color(0, 0, 150);
    }

    @Override
    public Color getForeground() {
        return Color.WHITE;
    }
    
    
    
}
