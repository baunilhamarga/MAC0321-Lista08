package ex2;

//O usuário deve apenas clicar no botão de run e simular a execução, foram testados dois 
//casos, um com número válido e outro com um número negativo.
import ex1.FatorialController;
import ex1.FatorialModel;
import ex1.FatorialView;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class FatorialTest {
	JButton calculateButton;
	JTextField inputField;
	JTextArea result;
	JFrame frame;

 @BeforeEach
 public void setUp() {
     FatorialModel model = new FatorialModel();
     FatorialView view = new FatorialView();
     new FatorialController(model, view);
     frame = FatorialView.getFrame();
 	calculateButton = FatorialView.getButton();
 	inputField = FatorialView.getInputField();
 	result = FatorialView.getResult();
 }
 
 @AfterEach
 public void close() {
 	frame.setVisible(false);
 }
 
 @Test
 public void testCalculoFatorial() throws InterruptedException {
 	Thread.sleep(1000);
 	inputField.setText("6");
 	calculateButton.doClick();
 	Thread.sleep(1000);
 	assertEquals("Resultado: 720", result.getText());
 }
 
 @Test
 public void testNumeroNegativo() throws InterruptedException {
 	Thread.sleep(1000);
 	inputField.setText("-3");
 	calculateButton.doClick();
 	Thread.sleep(1000);
 	assertEquals("O fatorial não está definido para números negativos.", FatorialView.getError());
 }  
 
 @Test
 public void testInputInvalido() throws InterruptedException {
 	Thread.sleep(1000);
 	inputField.setText("fniwoef");
 	calculateButton.doClick();
 	Thread.sleep(1000);
 	assertEquals("Por favor, insira um número válido.", FatorialView.getError());
 }  
}