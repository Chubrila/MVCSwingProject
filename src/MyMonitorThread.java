
import java.util.concurrent.ThreadPoolExecutor;

import model.CalculatorModel;
import view.View;

public class MyMonitorThread implements Runnable
{
	private CalculatorModel calculatorModel;
	private ThreadPoolExecutor executor;
    private int seconds;
    private boolean run=true;

    public MyMonitorThread(ThreadPoolExecutor executor, int delay)
    {
        this.executor = executor;
        this.seconds=delay;
        calculatorModel = new CalculatorModel();
    }
    
    public void shutdown(){
        this.run=false;
    }
    
    @Override
    public void run()
    {
        while(run){
        	try {
				View window = new View(calculatorModel);
				window.setVisible(true);
				Thread.sleep(seconds*300);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
}

