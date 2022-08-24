package temCafe.compadrao;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class TelaMonitorGarrafaCafe implements Observador {

    private JFrame janela;
    private JLabel lbTitulo;
    private JLabel lbUltimaAtualizacao;
    private JProgressBar pbSituacaoGarrafa;

    public TelaMonitorGarrafaCafe() {
        construirTela();
    }

    private void construirTela() {
        janela = new JFrame("Monitor da Garrafa de Café da Copa");
        janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        lbTitulo = new JLabel("Volume da Garrafa de Café", SwingConstants.CENTER);
        lbUltimaAtualizacao = new JLabel("", SwingConstants.CENTER);

        pbSituacaoGarrafa = new JProgressBar(JProgressBar.HORIZONTAL);
        pbSituacaoGarrafa.setMaximum(1000);
        pbSituacaoGarrafa.setMinimum(0);
        pbSituacaoGarrafa.setStringPainted(true);

        janela.setLayout(new GridLayout(3, 1, 5, 5));

        janela.add(lbTitulo);
        janela.add(pbSituacaoGarrafa);
        janela.add(lbUltimaAtualizacao);
        janela.setSize(450, 200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void exibir() {
        janela.setVisible(true);
    }

    public void alterarSituacaoGarrafa(int volume) {
        pbSituacaoGarrafa.setValue(volume);
    }

    public void alterarUltimaAtualizacao(String atualizacao) {
        lbUltimaAtualizacao.setText("Última atualização: " + atualizacao);
    }

    @Override
    public void atualizar(Observado obs) {
        if (obs instanceof TelaCopa) {
            TelaCopa copa = (TelaCopa) obs;
            alterarSituacaoGarrafa(copa.obterVolume());
            alterarUltimaAtualizacao(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").
                    format(Calendar.getInstance().getTime()));
        }
    }
}
