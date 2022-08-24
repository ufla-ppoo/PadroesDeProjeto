package singleton;

public class App {
    public static void main(String[] args) {
        ClasseQualquer var1 = ClasseQualquer.getInstancia();
        ClasseQualquer var2 = ClasseQualquer.getInstancia();
        
        // Verifica se var1 e var2 são a mesma instância.
        // O resultado esperado é que sim, pois o padrão Singleton garante isso.
        if (var1 == var2) { 
            System.out.println("Deu certo!");
        }
        else {
            System.out.println("Deu errado!");
        }
    }
}
