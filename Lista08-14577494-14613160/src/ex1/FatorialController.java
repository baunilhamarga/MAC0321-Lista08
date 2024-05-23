package ex1;

import java.math.BigInteger;
import javax.swing.SwingWorker;

/**
 * Controlador que gerencia a interação entre o modelo e a visão.
 */
public class FatorialController {
    private FatorialView view;
    private volatile boolean calculating = false;  // Variável de estado para rastrear se o cálculo está em progresso

    /**
     * Construtor do controlador.
     * @param model O modelo que realiza os cálculos de fatorial.
     * @param view A visão que exibe a interface gráfica.
     */
    public FatorialController(FatorialModel model, FatorialView view) {
        this.view = view;
        this.view.setController(this);
    }

    /**
     * Calcula o fatorial a partir da entrada do usuário e atualiza a visão com o resultado.
     * @param input A entrada do usuário.
     */
    public void calcularFatorial(String input) {
        if (calculating) {
            view.displayError("Por favor, espere o cálculo atual terminar.");
            return;
        }
        
        try {
            BigInteger number = new BigInteger(input);
            calculating = true;
            new FatorialTask(number).execute();
        } catch (NumberFormatException e) {
            view.displayError("Por favor, insira um número válido.");
        } catch (IllegalArgumentException e) {
            view.displayError(e.getMessage());
        }
    }

    /**
     * Tarefa SwingWorker para calcular o fatorial em segundo plano.
     */
    private class FatorialTask extends SwingWorker<BigInteger, Integer> {
        private final BigInteger number;

        public FatorialTask(BigInteger number) {
            this.number = number;
        }

        @Override
        protected BigInteger doInBackground() throws Exception {
            if (number.compareTo(BigInteger.ZERO) < 0) {
                throw new IllegalArgumentException("O fatorial não está definido para números negativos.");
            }
            view.setProgressMessage("Calculando... 0%");
            BigInteger result = BigInteger.ONE;
            for (BigInteger i = BigInteger.ONE; i.compareTo(number) <= 0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(i);
                int progress = i.multiply(BigInteger.valueOf(100)).divide(number).intValue();
                publish(progress);
            }
            return result;
        }

        @Override
        protected void process(java.util.List<Integer> chunks) {
            for (int progress : chunks) {
                view.updateProgress(progress);
                view.setProgressMessage("Calculando... " + progress + "%");
            }
        }

        @Override
        protected void done() {
            try {
                BigInteger result = get();
                view.displayResult(result.toString());
                view.updateProgress(100); // Certifique-se de que a barra de progresso está completa
                view.setProgressMessage("Concluído");
            } catch (Exception e) {
                if (e.getCause() instanceof IllegalArgumentException) {
                    view.displayError(e.getCause().getMessage());
                } else {
                    view.displayError("Erro ao calcular o fatorial.");
                }
            } finally {
                calculating = false;  // Atualiza o estado para indicar que o cálculo foi concluído
            }
        }
    }
}
