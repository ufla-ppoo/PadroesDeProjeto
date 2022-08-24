package temCafe.compadrao;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TelaCopa implements Observado, Observador {

    /**
     * Constante pública que representa o volume da garrafa (em ml) quando a
     * mesma está completamente cheia.
     */
    public static int VOL_GARRAFA_CHEIA = 1000;

    /**
     * Constante pública que representa o volume da garrafa (em ml) quando a
     * mesma está completamente vazia.
     */
    public static int VOL_GARRAFA_VAZIA = 0;

    /**
     * Constante pública que representa o volume (em ml) de um café simples.
     */
    public static int VOL_CAFE_SIMPLES = 100;

    /**
     * Constante pública que representa o volume (em ml) de um café duplo.
     */
    public static int VOL_CAFE_DUPLO = 200;

    // Componentes gráficos
    private JFrame janela;
    private JButton btnCafeSimples;
    private JButton btnCafeDuplo;
    private JButton btnEncherGarrafa;

    // Volume da garrafa de café
    private int volume;

    // Lista de observadores
    private List<Observador> observadores;

    public TelaCopa() {
        construirTela();
        this.observadores = new ArrayList<Observador>();
        volume = VOL_GARRAFA_VAZIA;
    }

    public void exibir() {
        janela.setVisible(true);
    }

    private void construirTela() {
        janela = new JFrame("Copa do DCC");
        janela.setLayout(new GridLayout(3, 1, 5, 5));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnEncherGarrafa = new JButton("Encher garrafa",
                new ImageIcon(getClass().getResource("encher-garrafa.png")));
        btnEncherGarrafa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encherGarrafa();
            }
        });

        btnCafeSimples = new JButton("Tomar café simples",
                new ImageIcon(getClass().getResource("cafe-simples.png")));
        btnCafeSimples.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tomarCafeSimples();
            }
        });

        btnCafeDuplo = new JButton("Tomar café duplo",
                new ImageIcon(getClass().getResource("cafe-duplo.png")));
        btnCafeDuplo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tomarCafeDuplo();
            }
        });

        janela.add(btnCafeSimples);
        janela.add(btnCafeDuplo);
        janela.add(btnEncherGarrafa);
        janela.setSize(300, 400);
        
        atualizarComponentesTela();
    }

    private void atualizarComponentesTela() {
        if (volume == VOL_GARRAFA_VAZIA) {
            btnCafeDuplo.setEnabled(false);
            btnCafeSimples.setEnabled(false);
            btnEncherGarrafa.setEnabled(true);
        } else if (volume == VOL_GARRAFA_CHEIA) {
            btnCafeDuplo.setEnabled(true);
            btnCafeSimples.setEnabled(true);
            btnEncherGarrafa.setEnabled(false);
        } else {
            btnCafeDuplo.setEnabled(true);
            btnCafeSimples.setEnabled(true);
            btnEncherGarrafa.setEnabled(true);
        }
    }

    /**
     * Atualiza o volume atual da garrafa de café, descontando do mesmo, o
     * volume de um café simples (definido pela constante
     * {@link VOL_CAFE_SIMPLES}). Caso o valor do novo volume seja menor do que
     * volume mínimo permitido o volume será atualizado para o volume de uma
     * garrafa de café vazia (definido pela constante
     * {@link VOL_GARRAFA_VAZIA}).
     */
    public void tomarCafeSimples() {
        if (volume - VOL_CAFE_SIMPLES < VOL_GARRAFA_VAZIA) {
            atualizarVolume(VOL_GARRAFA_VAZIA);
        } else {
            atualizarVolume(volume - VOL_CAFE_SIMPLES);
        }
    }

    /**
     * Atualiza o volume atual da garrafa de café, descontando do mesmo, o
     * volume de um café duplo (definido pela constante {@link VOL_CAFE_DUPLO}).
     * Caso o valor do novo volume seja menor do que volume mínimo permitido o
     * volume será atualizado para o volume de uma garrafa de café vazia
     * (definido pela constante {@link VOL_GARRAFA_VAZIA}).
     */
    public void tomarCafeDuplo() {
        if (volume - VOL_CAFE_DUPLO < VOL_GARRAFA_VAZIA) {
            atualizarVolume(VOL_GARRAFA_VAZIA);
        } else {
            atualizarVolume(volume - VOL_CAFE_DUPLO);
        }
    }

    /**
     * Atualiza o volume atual da garrafa de café para o volume de uma garrafa
     * de café cheia (definido pela constante {@link VOL_GARRAFA_CHEIA}).
     */
    public void encherGarrafa() {
        atualizarVolume(VOL_GARRAFA_CHEIA);
    }
    
    /**
     * Altera o valor do volume atual da garrafa de café e atualiza os
     * componentes da tela.
     *
     * @param volume Novo valor para o volume da garrafa de café.
     */
    private void atualizarVolume(int volume) {
        this.volume = volume;
        notificarObservadores();
    }
    
    public int obterVolume() {
        return volume;
    }

    @Override
    public void adicionarObservador(Observador obs) {
        observadores.add(obs);
    }

    @Override
    public void notificarObservadores() {
        for(Observador obs : observadores) {
            obs.atualizar(this);
        }
    }

    @Override
    public void atualizar(Observado obs) {
        atualizarComponentesTela();
    }
}
