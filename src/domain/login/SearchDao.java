package domain.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SearchDao{
	
	public List<Event> searchEvents(Search search);	
}
