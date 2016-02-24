package nudt.pdl.storm_window.window;

import java.util.List;

import backtype.storm.tuple.Tuple;
public interface IWindowEventHandler {
	public void insertionEventHandler(Tuple Tuple);
	public void flushEventHandler();
	public void EvicitionEventHandler(List<Tuple> events );
	public Tuple triggerEventHandler();
}
