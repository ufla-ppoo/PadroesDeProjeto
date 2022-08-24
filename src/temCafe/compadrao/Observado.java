package temCafe.compadrao;

public interface Observado {
    public void adicionarObservador(Observador obs);
    public void notificarObservadores();
}
