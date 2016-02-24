package nudt.pdl.storm_window.window;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <长度窗口抽象类>
 * @author Administrator
 *
 */
public abstract class  LengthBasedWindow implements IWindow{
	
	/**
    * 日志打印对象
    */
   private static final Logger LOG = LoggerFactory.getLogger(LengthBasedWindow.class);
   
   /**
    * 窗口事件保持长度
    */
   private int keepLength;
   protected Deque<WindowItem> dataCollection;
   
 
   /**
    * <默认构造函数>
    *@param keepLength 窗口保持长度
    */
   public LengthBasedWindow(int keepLength)
   {
       super();
       if (keepLength > 0)
       {
           this.keepLength = keepLength;
           LOG.debug("Length Window Keep Length: {}.", keepLength);
       }
       else
       {
           LOG.error("Invalid keepLength:  {}.", keepLength);
           throw new IllegalArgumentException("Invalid keepLength: " + keepLength);
       }
       
       dataCollection = new LinkedBlockingDeque<WindowItem>();
   }
   
   
   /**
    * <获取窗口保持长度 >
    * @return 窗口保持长度
    */
   public int getKeepLength()
   {
       return keepLength;
   }

   public int getWindowSize()
   {
	   return dataCollection.size();
   }
   
	public void clear() {
		
		dataCollection.clear();
	}
	
	public List<Object> getWindowElements()
	{
		return new ArrayList<Object>(dataCollection);
	}
	

	public List<Object> evictFromWindow() {
		List<Object> eviction = new ArrayList<Object>();
		eviction.add(dataCollection.removeFirst().getEvent());
		return eviction;
	}
	
	public void insertIntoWindow(Object object)
	{
		WindowItem item = new WindowItem(object, System.currentTimeMillis());
		dataCollection.addLast(item);	
	}
	

 
}
