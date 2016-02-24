package nudt.pdl.storm_window.api;

import java.io.Serializable;
import java.util.List;



import backtype.storm.tuple.Tuple;

public interface Function extends Serializable{

    public void execute(Object event);
    
}
