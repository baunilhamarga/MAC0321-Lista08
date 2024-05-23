package ex1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe responsável pela interface gráfica do usuário.
 */
public class FatorialView {
    private JFrame frame;
    private JTextField inputField;
    private JButton calculateButton;
    private JTextArea resultArea;
    private JScrollPane scrollPane;
    private JProgressBar progressBar;
    private JLabel progressLabel;
    private FatorialController controller;

    /**
     * Construtor que inicializa a interface gráfica.
     */
    public FatorialView() {
        initializeFrame();
        initializeComponents();
        addComponentsToFrame();
        addEventListeners();
        frame.setVisible(true);
    }

    /**
     * Inicializa a janela principal.
     */
    private void initializeFrame() {
        frame = new JFrame("Calculadora de Fatorial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 1));
    }

    /**
     * Inicializa os componentes da interface gráfica.
     */
    private void initializeComponents() {
        inputField = new JTextField();
        calculateButton = new JButton("Calcular Fatorial");
        resultArea = new JTextArea(5, 30);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setEditable(false);
        scrollPane = new JScrollPane(resultArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressLabel = new JLabel("Progresso:");
    }

    /**
     * Adiciona os componentes à janela principal.
     */
    private void addComponentsToFrame() {
        frame.add(new JLabel("Entre com um número:"));
        frame.add(inputField);
        frame.add(calculateButton);
        frame.add(scrollPane);
        frame.add(progressLabel);
        frame.add(progressBar);
    }

    /**
     * Adiciona os ouvintes de eventos aos componentes.
     */
    private void addEventListeners() {
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.calcularFatorial(inputField.getText());
            }
        });
    }

    /**
     * Define o controlador para a visão.
     * @param controller O controlador a ser definido.
     */
    public void setController(FatorialController controller) {
        this.controller = controller;
    }

    /**
     * Exibe o resultado do cálculo do fatorial na área de texto.
     * @param result O resultado a ser exibido.
     */
    public void displayResult(String result) {
        resultArea.setText("Resultado: " + result);
        resultArea.setCaretPosition(0); // Move o cursor para o início do texto
    }

    /**
     * Exibe uma mensagem de erro em uma caixa de diálogo.
     * @param errorMessage A mensagem de erro a ser exibida.
     */
    public void displayError(String errorMessage) {
        JOptionPane.showMessageDialog(frame, errorMessage, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Atualiza a barra de progresso.
     * @param progress O valor da barra de progresso.
     */
    public void updateProgress(int progress) {
        progressBar.setValue(progress);
    }

    /**
     * Define a mensagem de progresso.
     * @param message A mensagem de progresso a ser exibida.
     */
    public void setProgressMessage(String message) {
        progressBar.setString(message);
    }

    /**
     * Método principal para iniciar a aplicação.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        FatorialModel model = new FatorialModel();
        FatorialView view = new FatorialView();
        new FatorialController(model, view);
    }
}
