package nudt.pdl.storm_window.window;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import backtype.storm.tuple.Tuple;

/**
 * <时间窗口抽象类>
 * @author Administrator
 *
 */
public class TimeBasedWindow implements IWindow{
	 /**
     * 日志打印对象
     */
    private static final Logger LOG = LoggerFactory.getLogger(LengthBasedWindow.class);
    
    /**
     * 窗口事件保持时间
     */
    private long keepTime;
    
    

	public void insert(Object tuple) {
		// TODO Auto-generated method stub
		
	}



	public void clear() {
		// TODO Auto-generated method stub
		
	}



	public List<Object> getWindowElements() {
		// TODO Auto-generated method stub
		return null;
	}
}
