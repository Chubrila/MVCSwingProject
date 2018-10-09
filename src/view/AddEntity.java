package view;
import java.awt.*;
import javax.swing.*;

import action.MyActionListener;
import controller.Controller;
import model.People;

public class AddEntity extends JFrame{
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField ageTextField;
	private JButton addButton;
	private JLabel nameLabel;
	private JLabel surnameLabel;
	private JLabel ageLabel;
	private People ipeople;
	private MyActionListener myActionListener;
		
	public AddEntity(People apeople) {
		nameTextField = new JTextField(50);
		surnameTextField = new JTextField(50);
		ageTextField = new JTextField(50);
		addButton = new JButton("Add");
		new JButton("Quit");
		new JButton("Clear");
		nameLabel = new JLabel("Name: ");
		surnameLabel = new JLabel("Surname: ");
		ageLabel = new JLabel("Age: ");
		ipeople = apeople;
	}
	
	public void launchFrame() {
		myActionListener = new MyActionListener();
		addButton.addActionListener(myActionListener);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(3,3));
		p2.add(nameLabel, BorderLayout.WEST);
		p2.add(nameTextField, BorderLayout.WEST);
		p2.add(surnameLabel, BorderLayout.WEST);
		p2.add(surnameTextField, BorderLayout.WEST);
		p2.add(ageLabel, BorderLayout.WEST);
		p2.add(ageTextField, BorderLayout.WEST);
		add(p2, BorderLayout.WEST);
		JPanel pl = new JPanel();
		pl.setLayout(new GridLayout(1,1));
		pl.add(addButton);
		add(pl, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setModel();
		setVisible(true);
	}

	public People getIpeople() {
		return ipeople;
	}

	public void setIpeople(People ipeople) {
		this.ipeople = ipeople;
	}

	public void setModel() {
		nameTextField.setText(ipeople.getName());
		surnameTextField.setText(ipeople.getSurname());
		ageTextField.setText(Integer.toString(ipeople.getAge()));
	}

	public JTextField getNameTextField() {
		return nameTextField;
	}

	public void setNameTextField(JTextField nameTextField) {
		this.nameTextField = nameTextField;
	}

	public JTextField getSurnameTextField() {
		return surnameTextField;
	}

	public void setSurnameTextField(JTextField surnameTextField) {
		this.surnameTextField = surnameTextField;
	}

	public JTextField getAgeTextField() {
		return ageTextField;
	}

	public void setAgeTextField(JTextField ageTextField) {
		this.ageTextField = ageTextField;
	}
}
