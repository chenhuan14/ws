package nudt.pdl.storm_window.window;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import backtype.storm.tuple.Tuple;

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

	public void insert(Tuple tuple) {

		//插入window
		insertIntoWindow(tuple);
		eventHandler.insertionEventHandler(tuple);
		
		if(getWindowSize() == getKeepLength())
		{
			List<Tuple> eviction = evictFromWindow();
			eventHandler.EvicitionEventHandler(eviction);
		}
		
		ticks ++;
		if(ticks == triggerTicks)
		{
			eventHandler.triggerEventHandler();
			ticks = 0;
			
		}
	
	}

	private List<Tuple> evictFromWindow() {
		List<Tuple> eviction = new ArrayList<Tuple>();
		eviction.add(dataCollection.removeFirst().getEvent());
		return eviction;
	}
	
	private void insertIntoWindow(Tuple tuple)
	{
		WindowItem item = new WindowItem(tuple, System.currentTimeMillis());
		dataCollection.addLast(item);	
	}





	

}
