package nudt.pdl.storm_window.window;



public class WindowItem {
	Object event;
	long timestamp;
	
	public WindowItem(Object object, long timestamp) {
        this.event = object;
        this.timestamp = timestamp;
       
    }

    public Object getEvent() {
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
