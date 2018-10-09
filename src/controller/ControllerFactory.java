package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.xml.XMLContext;

public class ControllerFactory {
	Map<String, Controller> map;
	
	public ControllerFactory() throws MarshalException, ValidationException, FileNotFoundException{
		map = new HashMap<>();
		init();
	}
	
	private void init() throws FileNotFoundException, MarshalException, ValidationException {
		XMLContext context = new XMLContext();
		Reader reader = new FileReader("out.xml");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setClass(ArrayList.class);
		List newList = new ArrayList();
		newList = (ArrayList)unmarshaller.unmarshal(reader);
		for(int i = 0; i < newList.size(); i+=2) {
			map.put((String)newList.get(i), (Controller)newList.get(i+1));
		}
	}
	
	public Controller defineControllerType(String controllerParameter) {
        List<Controller> list = new ArrayList<>();
        for (Map.Entry<String, Controller> currentController : map.entrySet()) {
        		String currentControllerType = currentController.getKey();
            if (currentControllerType.equals(controllerParameter)) {
                Controller controller = currentController.getValue();
                list.add(controller);
                break;
            }
        }
        return list.get(0);
    }
}
