package controller;

import model.CalculatorModel;
import model.People;

public class MyController implements Controller{
	public MyController() {
	}
	
	@Override
	public CalculatorModel execute(CalculatorModel calculatorModel, String[] newData) {
		switch(newData[2]) {
		case "+":{
			double first = Double.parseDouble(newData[0]);
			double second = Double.parseDouble(newData[1]);
			double result = first + second;
			String stringResult = Double.toString(result);
			calculatorModel.setResult(stringResult);
			break;
		}
//			calculatorModel.setResult(Integer.toString(Integer.parseInt(newData[0]) + Integer.parseInt(newData[1])));
		case "-":
		{
			double first = Double.parseDouble(newData[0]);
			double second = Double.parseDouble(newData[1]);
			double result = first - second;
			String stringResult = Double.toString(result);
			calculatorModel.setResult(stringResult);
			break;
		}
		case "*":
		{
			double first = Double.parseDouble(newData[0]);
			double second = Double.parseDouble(newData[1]);
			double result = first * second;
			String stringResult = Double.toString(result);
			calculatorModel.setResult(stringResult);
			break;
		}
		case "/":
			if(Integer.parseInt(newData[1])!=0) {
				double first = Double.parseDouble(newData[0]);
				double second = Double.parseDouble(newData[1]);
				double result = Math.round((first / second) * 10000.0) / 10000.0;;
				String stringResult = Double.toString(result);
				calculatorModel.setResult(stringResult);
				break;
			} else {
				calculatorModel.setResult("wrong");
			}
			break;
		}
		return calculatorModel;
	}
}
