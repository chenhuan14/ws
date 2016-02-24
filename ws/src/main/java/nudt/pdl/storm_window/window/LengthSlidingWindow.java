package nudt.pdl.storm_window.window;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class LengthSlidingWindow extends LengthBasedWindow {

	/**
	* 日志打印对象
	*/
	private static final Logger LOG = LoggerFactory.getLogger(LengthSlidingWindow.class);
	
	private IWindowEventHandler eventHandler;
	private int triggerTicks ;
	private int ticks = 0; 
	
	public LengthSlidingWindow(int keepLength, IWindowEventHandler eventHandler) {
		super(keepLength);
		this.eventHandler = eventHandler;
		triggerTicks = 1;
	}
	
	public LengthSlidingWindow setTriggerTicks(int triggerTicks)
	{
		if(triggerTicks > getKeepLength())
		{
			 LOG.error("tiggerTicks bigger than keepLengh");
	         throw new IllegalArgumentException("Invalid triggerticks");
		}
		this.triggerTicks = triggerTicks;
		return this;
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
			ticks = 0;
			
		}
	
	}






	

}
