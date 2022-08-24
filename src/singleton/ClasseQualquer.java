package singleton;

/*
 * Esse seria um exemplo de uma classe para a qualquer queremos garantir
 * que exista apenas uma instância (um objeto) em nosso programa. 
 */
public class ClasseQualquer {

    // declaramos um atributo do tipo da própria classe para referenciar o
    // objeto único da classe
    private static ClasseQualquer instancia = null;

    // demais atributos omitidos...

    /*
     * É de fundalmental importância que o construtor seja **privado**
     * Sem isso, a classe pode ter várias instâncias
     */
    private ClasseQualquer() {
        // código omitido...
    }

    /**
     * Método que retorna a referência para o único objeto da classe.
     * Na primeira vez que é chamado, a instância é criada; nas demais
     * a instância criada anteriormente é retornada.
     * 
     * @return A instância única da classe
     */
    public static ClasseQualquer getInstancia() {
        if (instancia == null) {
            instancia = new ClasseQualquer();
        }
        return instancia;
    }

    // demais métodos omitidos...
    
}