package nudt.pdl.storm_window.window;





import backtype.storm.tuple.Tuple;

public interface IWindow {
	public void insert(Tuple tuple);
	
	public void clear();
	
	
	
}
