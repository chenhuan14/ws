package nudt.pdl.storm_window.window;

import java.util.List;

public interface IWindow {
	
	
	public void insert(Object tuple);
	
	public void clear();
	
	public List<Object> getWindowElements();
	
}
