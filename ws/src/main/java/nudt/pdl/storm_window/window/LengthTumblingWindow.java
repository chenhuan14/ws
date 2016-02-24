package nudt.pdl.storm_window.window;

import java.util.List;

public class LengthTumblingWindow extends LengthBasedWindow{

	int triggerTicks = 0;
	int ticks = 0;
	private IWindowEventHandler eventHandler;
	public LengthTumblingWindow(int keepLength, IWindowEventHandler eventHandler) {
		super(keepLength);
		// TODO Auto-generated constructor stub
		triggerTicks = keepLength;
		this.eventHandler = eventHandler;
	}

	public void insert(Object object) {
		//插入window
		
		eventHandler.insertionEventHandler(object);
		
		if(getWindowSize() == getKeepLength())
		{
			List<Object> eviction = evictFromWindow();
			eventHandler.EvicitionEventHandler(eviction);
		}
		
		insertIntoWindow(object);
		
		ticks ++;
		if(ticks == triggerTicks)
		{
			eventHandler.triggerEventHandler();
			eventHandler.flushEventHandler();
			clear();
			ticks = 0;
			
		}
	}
	
	

}
