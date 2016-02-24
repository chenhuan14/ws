package nudt.pdl.storm_window.operator;

import java.util.List;


import nudt.pdl.storm_window.api.Function;
import nudt.pdl.storm_window.window.IWindow;
import nudt.pdl.storm_window.window.IWindowEventHandler;
import nudt.pdl.storm_window.window.LengthSlidingWindow;
import nudt.pdl.storm_window.window.LengthTumblingWindow;

public class Sum implements IWindowEventHandler, Function{
	
	int sum;
	IWindow window;
	
	public Sum()
	{
		sum = 0;
		window = new LengthTumblingWindow(2, this);
		
	}
	
	public int getResult()
	{
		return sum;
	}

	public void execute(Object event) {
		window.insert(event);
	}

	public void insertionEventHandler(Object object) {
		// TODO Auto-generated method stub
		sum += (Integer) object;
		
	}

	public void flushEventHandler() {
		// TODO Auto-generated method stub
		
		sum = 0;
		
	}

	public void EvicitionEventHandler(List<Object> events) {
		for(Object o : events)
		{
			sum -= (Integer) o;
		}
		
	}

	public Object triggerEventHandler() {
		// TODO Auto-generated method stub
		System.out.println("sum = " + sum);
		return null;
	}

}
