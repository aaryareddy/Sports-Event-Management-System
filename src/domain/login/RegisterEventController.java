package domain.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/RegisterEventController")
public class RegisterEventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterEventController() {}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RegisterEventDao eventDao = new RegisterEventDaoImpl();

		String username = request.getParameter("username");
		String phonenumber = request.getParameter("phonenumber");
		String eventname = request.getParameter("eventname");
		String category = request.getParameter("category");
		String address = request.getParameter("address");
		
		String submitType = request.getParameter("submit");
		
		RegisterEvent event = new RegisterEvent(username, phonenumber, eventname, category, address);
		int status = eventDao.addEvent(event);
	

    	if(status==1){	
						request.setAttribute("message", " Event registered");
						request.getRequestDispatcher("thankyou.jsp").forward(request, response);
					}


		
	}

}
