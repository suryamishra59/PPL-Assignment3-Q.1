package ppl.assignment.email;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendEmail
 */
@WebServlet("/email")
public class SendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String host;
	private String port;
	private String user;
	private String pass;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String body = request.getParameter("body");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		// Get info from web.xml
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");

		try {
			EmailUtility.sendEmail(host, port, user, pass, "Feedback | PPL Assignment", name, body, email, phone);
			response.getWriter().write("Thank you for your valuable feedback");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
