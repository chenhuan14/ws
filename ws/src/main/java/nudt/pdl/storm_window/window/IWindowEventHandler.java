package nudt.pdl.storm_window.window;

import java.util.List;

import backtype.storm.tuple.Tuple;
public interface IWindowEventHandler {
	public void insertionEventHandler(Object Tuple);
	public void flushEventHandler();
	public void EvicitionEventHandler(List<Object> events );
	public Object triggerEventHandler();
}
