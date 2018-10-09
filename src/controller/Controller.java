package controller;

import model.CalculatorModel;
import model.People;

public interface Controller {
	CalculatorModel execute(CalculatorModel calculatorModel, String[] newData);
}
