package ex1;

import java.math.BigInteger;

/**
 * Classe responsável pelo cálculo de fatoriais.
 */
public class FatorialModel {

    /**
     * Função para calcular o fatorial de um número inteiro usando BigInteger.
     * @param n Número inteiro cujo fatorial será calculado.
     * @return Fatorial de n.
     * @throws IllegalArgumentException Se n for negativo.
     */
    public BigInteger calcularFatorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("O fatorial não está definido para números negativos.");
        }
        BigInteger fatorial = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            fatorial = fatorial.multiply(BigInteger.valueOf(i));
        }
        return fatorial;
    }

    /**
     * Função para calcular o fatorial de um BigInteger.
     * @param n BigInteger cujo fatorial será calculado.
     * @return Fatorial de n.
     * @throws IllegalArgumentException Se n for negativo.
     */
    public BigInteger calcularFatorial(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("O fatorial não está definido para números negativos.");
        }
        BigInteger fatorial = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            fatorial = fatorial.multiply(i);
        }
        return fatorial;
    }
}
