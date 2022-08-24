package temCafe.compadrao;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class App {

    public static void main(String args[]) {
        TelaMonitorGarrafaCafe monitor = new TelaMonitorGarrafaCafe();
        TelaCopa copa = new TelaCopa();
        Sirene sirene = new Sirene();

        // Adiciona os observadores da garrafa de café. Note que a própria
        // TelaCopa é um observador da garrafa de café. 
        copa.adicionarObservador(copa);
        copa.adicionarObservador(monitor);
        copa.adicionarObservador(sirene);
        
        // Usando classe interna anônima para criar um observador,
        // assim como fizemos para listeners, na aula sobre eventos
        copa.adicionarObservador(new Observador() {
            @Override
            public void atualizar(Observado obs) {
                if (obs instanceof TelaCopa) {
                    String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").
                            format(Calendar.getInstance().getTime());
                    TelaCopa copa = (TelaCopa) obs;
                    int volume = copa.obterVolume();
                    System.out.println("@ " + data + " - volume (ml): " + volume);
                }
            }
        }
        );

        copa.exibir();

        monitor.exibir();
    }

}
