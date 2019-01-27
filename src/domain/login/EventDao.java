package domain.login;

import java.util.List;


public interface EventDao {
	
	public List<Event> getCurrentEvents();
	
	public int addEvent(Event event);
	
	public int updateEvent(Event event);
	
	public Event getEvent(String id);
	
	public int cancelEvent(String id);
	
	public Event getRequiredEvent(String eventTopic);

}
