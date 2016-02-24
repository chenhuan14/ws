package nudt.pdl.test;

import java.util.ArrayList;
import java.util.List;

import nudt.pdl.storm_window.operator.Sum;


public class SlidingWindowTest  {

	public static void main(String[] args) 
	{
		
		Sum s = new Sum();
		
		for(int i = 0 ; i < 10 ; i++)
		{
			s.execute(i);
		}
		
	}
	
	
	public static void testEvent()
	{
		List<Object> tuples = mockEvents();
		for(Object t : tuples)
		{
			System.out.println((Integer)t);
		}
	}
	
	
	
	private static List<Object> mockEvents()
	{
		List<Object> list = new ArrayList<Object>();
		for(int i = 0 ; i < 10 ; i++)
			list.add(i);
		
		return list;
	}
}


