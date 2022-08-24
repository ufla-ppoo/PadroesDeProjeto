package temCafe.sempadrao;

public class App {

    public static void main(String args[]) {
        TelaMonitorGarrafaCafe monitor = new TelaMonitorGarrafaCafe();
        TelaCopa copa = new TelaCopa(monitor);
        copa.exibir();
        monitor.exibir();
    }

}
