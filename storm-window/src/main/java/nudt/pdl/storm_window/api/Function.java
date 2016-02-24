package nudt.pdl.storm_window.api;

import java.io.Serializable;
import java.util.List;

import org.calrissian.mango.domain.event.Event;

import backtype.storm.tuple.Tuple;

public interface Function extends Serializable{

    public void execute(Tuple event);
    
}
