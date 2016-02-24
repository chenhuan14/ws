package nudt.pdl.storm_window.window;

import org.calrissian.mango.domain.event.Event;

import backtype.storm.tuple.Tuple;

public class WindowItem {
	Tuple event;
	long timestamp;
	
	public WindowItem(Tuple event, long timestamp) {
        this.event = event;
        this.timestamp = timestamp;
       
    }

    public Tuple getEvent() {
        return event;
    }

    public long getTimestamp() {
        return timestamp;
    }

	@Override
	public String toString() {
		return "WindowItem [event=" + event + ", timestamp=" + timestamp + "]";
	}
    
    
}
