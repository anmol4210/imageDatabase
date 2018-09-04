package com.nagarro;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.log.Log;
import com.nagarro.model.Image;
import com.nagarro.services.AuthenticateUser;
import com.nagarro.services.UserImages;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
	}
	public void init(ServletConfig config) throws ServletException {
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Add restriction.
		Map conditions = new HashMap();
		conditions.put("username", request.getParameter("username"));
		conditions.put("userPassword", request.getParameter("password"));

		Date date;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd 'at' h:m:s a z");

          //////// Logging//////////
          Log log = new Log("log/log.txt");
          log.logger.setLevel(Level.INFO);
          date = new Date();
          log.logger.info("Data Fetched at " + dateFormatter.format(date));
          log.logger.info("Data Fetched is {"+conditions+"}");

		AuthenticateUser authenticate = new AuthenticateUser();
		if (authenticate.authenticateUser(conditions)) {

			UserImages userImages = new UserImages();
			conditions.remove("userPassword");

			List images = userImages.getUserImages(conditions, request);
			HttpSession session = request.getSession();
			session.setAttribute("username", request.getParameter("username"));
			request.setAttribute("username", request.getParameter("username"));
			request.setAttribute("images", images);

			RequestDispatcher rd = request.getRequestDispatcher("/imageManagement.jsp");
			rd.forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<font color='red'>Invalid username or Password</font>");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./");
			request.setAttribute("isValid", "true");
			requestDispatcher.include(request, response);
			System.out.println("Incorrect username or password");
		}

	}
	

}
