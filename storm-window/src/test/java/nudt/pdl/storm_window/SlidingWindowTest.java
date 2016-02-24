package nudt.pdl.storm_window;

import java.util.ArrayList;
import java.util.List;

import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.TupleImpl;

import junit.framework.TestCase;

public class SlidingWindowTest extends TestCase {

	  public SlidingWindowTest( String testName )
	    {
	        super( testName );
	    }
	
	public void testEvent()
	{
		List<Tuple> tuples = mockEvents();
		for(Tuple t : tuples)
		{
			System.out.println(t.getInteger(0));
		}
	}
	
	
	
	private List<Tuple> mockEvents()
	{
		List<Tuple> tuples = new ArrayList<Tuple>();
		for(int i = 0 ; i < 10 ; i++)
		{
			List<Object> list = new ArrayList<Object>();
			list.add(i);
			tuples.add(new TupleImpl(null, list, 0, ""));
		}
		return tuples;
	}
}


