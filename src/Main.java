import java.awt.EventQueue;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.xml.XMLContext;

import controller.Controller;
import controller.MyController;
import model.CalculatorModel;
import model.People;
import view.AddEntity;
import view.View;

public class Main {
	public static void main(String[] args) throws MarshalException, ValidationException, IOException, InterruptedException{
		//People people = new People("Alex", "Protas", 15);
		//args.MyController controller = new MyController(people);
		//controller.setPeople(people);
		//addCouple();
		//CalculatorModel calculatorModel = new CalculatorModel();
		int amount = 1;
        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);
        MyMonitorThread monitor = new MyMonitorThread(executorPool, amount);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();
        Thread.sleep(amount * amount * 300);
        monitor.shutdown();

		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View(calculatorModel);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}
	
	public static void addCouple() throws IOException, MarshalException, ValidationException {
		Writer writer = new FileWriter("out.xml");
		XMLContext context = new XMLContext();
		Marshaller marshaller = new Marshaller();
		marshaller.setWriter(writer);
		ArrayList list = new ArrayList();
		list.add("view.View");
		Controller controller = new MyController();
		list.add(controller);
		marshaller.marshal(list);
	}
}
