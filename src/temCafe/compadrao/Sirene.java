package temCafe.compadrao;

import java.io.IOException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;

public class Sirene implements Observador {

    private final String SOM_SIRENE = "sirene.wav";
    private final int VOL_MINIMO = 400;

    private void tocarSirene() {
        try {
            Player player = Manager.createPlayer(getClass().getResource(SOM_SIRENE));
            player.start();
        } catch (IOException ex) {
            System.out.println("Erro ao abrir arquivo de áudio!");
        } catch (NoPlayerException ex) {
            System.out.println("Erro a executar arquivo de áudio");
        }
    }

    @Override
    public void atualizar(Observado obs) {
        if (obs instanceof TelaCopa) {
            TelaCopa copa = (TelaCopa) obs;
            if (copa.obterVolume() < VOL_MINIMO) {
                tocarSirene();
            }
        }
    }

}
