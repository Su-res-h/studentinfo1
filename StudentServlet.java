package studentdao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class StudentServlet
 */

@WebServlet("/register")
public class StudentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
//	private static final long serialVersionUID = 1l;
	private StudentDao studentDao;
	
	
	public void init() {
		studentDao = new StudentDao();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		Student student = new Student();
		student.setFirstName(firstName);
		 student.setLastName(lastName);
	        student.setEmail(email);
	        
	        try {
	        	studentDao.registerStudent(student);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        response.sendRedirect("success.jsp");
	}
	

}
