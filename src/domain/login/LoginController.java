package domain.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDao studentDao;
	EventDao eventsDao;
       

    public LoginController() {
    	 studentDao = new StudentDaoImpl();
    	 eventsDao = new EventsDaoImp();
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mode = request.getParameter("mode");
		if(mode.equals("fetch")){
			List<Event> fetchedEvents = eventsDao.getCurrentEvents();
			HttpSession session = request.getSession();
			Student stu = (Student) session.getAttribute("user");
			request.setAttribute("message", "Hello"+" " + stu.getEmail());
			request.setAttribute("events", fetchedEvents);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
		
		}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDao studentDao = new StudentDaoImpl();
		EventDao eventsDao = new EventsDaoImp();
		
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String submitType = request.getParameter("submit");
		
		if(email.equals("root") && pass.equals("170019")){
			HttpSession session = request.getSession();
			session.setAttribute("user", "root");
			//setting session to expiry in 30 sec
			session.setMaxInactiveInterval(30);
			Cookie userName = new Cookie("user", email);
			userName.setMaxAge(30*60);
			response.addCookie(userName);
			response.sendRedirect("admin.jsp");
		}
		else{
			Login login = new Login(email, pass);
			Student c = studentDao.validateStudent(login);
			
			List<Event> fetchedEvents = eventsDao.getCurrentEvents();
		
			if(submitType.equals("login") && c.getEmail()!=null){
				HttpSession session = request.getSession();
				session.setAttribute("user", c.getEmail());
				//setting session to expiry in 30 mins
				session.setMaxInactiveInterval(30*60);
				Cookie userName = new Cookie("user", email);
				userName.setMaxAge(30*60);
				response.addCookie(userName);
				
				request.setAttribute("message", "Hello "+c.getEmail());
				request.setAttribute("events", fetchedEvents);
				session.setAttribute("user", c);
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			
			}
			else if(submitType.equals("register")){
				String usr, pwd;
				usr = request.getParameter("email");
				pwd = request.getParameter("password");
				if((usr.isEmpty()) || (pwd.isEmpty())) {
					request.setAttribute("message", "Can not leave data fields empty");
					request.getRequestDispatcher("register.jsp").forward(request, response);
				}
				else if (!pwd.equals(request.getParameter("retry-password"))) {
					request.setAttribute("message", "Passwords do not match");
					request.getRequestDispatcher("register.jsp").forward(request, response);
				}
				else {
					c.setEmail(usr);
					c.setUserPassword(pwd);
					studentDao.register(c);
					request.setAttribute("successMessage", "Registration done, please login!");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}			
			}
			else{
				request.setAttribute("message", "Data Not Found!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

		}
	
	}

}
