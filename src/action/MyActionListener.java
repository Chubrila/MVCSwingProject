package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

import controller.Controller;
import controller.ControllerFactory;
import controller.MyController;
import model.CalculatorModel;
import model.People;
import view.View;

public class MyActionListener implements ActionListener{

	private CalculatorModel oldCalculatorModel;
	private CalculatorModel newCalculatorModel;
	private String firstNumber;
	private String secondNumber;
	private String action;
	private String result;
	
	@Override
	public void actionPerformed(ActionEvent e){
		JButton button = (JButton)e.getSource();
		JFrame window = (JFrame)SwingUtilities.getWindowAncestor(button);
		View view = (View)window;
		String nameOfView = window.getClass().getName();
		
		oldCalculatorModel = view.getCalculatorModel();
		setViewData(view);
		ControllerFactory controllerFactory;
		try {
			controllerFactory = new ControllerFactory();
			Controller controller = (MyController)controllerFactory.defineControllerType(nameOfView);
			String[] newData = {firstNumber, secondNumber, action};
			newCalculatorModel = controller.execute(oldCalculatorModel, newData);
			JTextPane jTextPane = view.getResult();
			jTextPane.setText(newCalculatorModel.getResult());
			view.setResult(jTextPane);
		} catch (MarshalException | ValidationException | FileNotFoundException e1) {
			e1.printStackTrace();
		}
		/*File propertie = Paths.get("resources\\a.properties").toFile();
		Properties properties = new Properties();
		try {
			properties.load(new FileReader(propertie));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	}
	
	public void setViewData(View view) {
		firstNumber = view.getFirstNumber().getText();
		secondNumber = view.getSecondNumber().getText();
		action = String.valueOf(view.getComboBox().getSelectedItem());
	}

}
