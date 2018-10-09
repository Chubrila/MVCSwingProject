package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

import action.MyActionListener;
import model.CalculatorModel;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class View extends JFrame{

	private JTextField firstNumber;
	private JComboBox comboBox;
	private JTextField secondNumber;
	private JLabel label;
	private JTextPane result;
	private CalculatorModel calculatorModel;
	private JButton btnCalculate;
	private MyActionListener myActionListener;

	public View(CalculatorModel calculatorModel) {
		initialize();
		this.calculatorModel = calculatorModel;
	}

	private void initialize() {
		myActionListener = new MyActionListener();

		setBounds(100, 100, 450, 71);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		firstNumber = new JTextField();
		panel.add(firstNumber);
		firstNumber.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"+", "-", "*", "/"}));
		panel.add(comboBox);
		
		secondNumber = new JTextField();
		panel.add(secondNumber);
		secondNumber.setColumns(10);
		
		label = new JLabel("=");
		panel.add(label);
		
		result = new JTextPane();
		panel.add(result);
		
		btnCalculate = new JButton("Calculate");
		panel.add(btnCalculate);
		btnCalculate.addActionListener(myActionListener);
	}

	public CalculatorModel getCalculatorModel() {
		return calculatorModel;
	}

	public void setCalculatorModel(CalculatorModel calculatorModel) {
		this.calculatorModel = calculatorModel;
	}
	
	public void getOldData() {
		firstNumber.setText(calculatorModel.getFirstNumber());
		secondNumber.setText(calculatorModel.getSecondNumber());
		firstNumber.setText(calculatorModel.getResult());
	}

	public JTextField getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(JTextField firstNumber) {
		this.firstNumber = firstNumber;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JTextField getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(JTextField secondNumber) {
		this.secondNumber = secondNumber;
	}

	public JTextPane getResult() {
		return result;
	}

	public void setResult(JTextPane result) {
		this.result = result;
	}

}
