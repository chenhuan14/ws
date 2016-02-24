package nudt.pdl.storm_window.operator;

import java.util.List;

import backtype.storm.tuple.Tuple;
import nudt.pdl.storm_window.api.Function;
import nudt.pdl.storm_window.window.IWindow;
import nudt.pdl.storm_window.window.IWindowEventHandler;
import nudt.pdl.storm_window.window.LengthSlidingWindow;

public class Sum implements IWindowEventHandler, Function{
	
	int sum;
	IWindow window;
	
	public Sum()
	{
		sum = 0;
		window = new LengthSlidingWindow(5, this);
		
	}
	
	public int getResult()
	{
		return sum;
	}

	public void execute(Tuple event) {
		window.insert(event);
	}

	public void insertionEventHandler(Tuple event) {
		// TODO Auto-generated method stub
		
		
	}

	public void flushEventHandler() {
		// TODO Auto-generated method stub
		
	}

	public void EvicitionEventHandler(List<Tuple> events) {
		// TODO Auto-generated method stub
		
	}

	public Tuple triggerEventHandler() {
		// TODO Auto-generated method stub
		return null;
	}

}
