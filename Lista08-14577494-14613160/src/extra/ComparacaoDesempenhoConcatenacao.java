package extra;

/**
 * Este programa compara o desempenho na operação de concatenação de Strings
 * utilizando a classe String e a classe StringBuffer.
 * 
 * A diferença de desempenho ocorre devido às características intrínsecas de cada classe:
 * 
 * - String é imutável, o que significa que cada concatenação cria uma nova instância de String,
 *   o que é menos eficiente.
 * - StringBuffer é mutável e foi projetada para operações frequentes de concatenação,
 *   sendo mais eficiente para este propósito.
 */

public class ComparacaoDesempenhoConcatenacao {
    private static final int ITERACOES = 100000;

    public static void main(String[] args) {
        // Teste com String
        long tempoInicial = System.nanoTime();
        String str = "";
        for (int i = 0; i < ITERACOES; i++) {
            str += "a";
        }
        long tempoFinal = System.nanoTime();
        long duracaoString = (tempoFinal - tempoInicial) / 1000000;
        System.out.println("Tempo com String: " + duracaoString + " milissegundos");

        // Teste com StringBuffer
        tempoInicial = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < ITERACOES; i++) {
            stringBuffer.append("a");
        }
        tempoFinal = System.nanoTime();
        long duracaoStringBuffer = (tempoFinal - tempoInicial) / 1000000;
        System.out.println("Tempo com StringBuffer: " + duracaoStringBuffer + " milissegundos");
    }
}
