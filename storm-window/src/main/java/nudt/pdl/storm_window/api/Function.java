package nudt.pdl.storm_window.api;

import java.io.Serializable;
import java.util.List;

import org.calrissian.mango.domain.event.Event;

public interface Function extends Serializable{

    List<Event> execute(Event event);

}
