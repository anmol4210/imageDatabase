package com.nagarro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		// super();
		// TODO Auto-generated constructor stub
		// System.out.println("hello world!");
	}
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Inital method");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Add restriction.
		Map conditions = new HashMap();
		conditions.put("username", request.getParameter("username"));
		conditions.put("userPassword", request.getParameter("password"));
		// cr.add(Restrictions.eqOrIsNull("username", "anmol"));

		AuthenticateUser authenticate = new AuthenticateUser();
///System.out.println("1");
		if (authenticate.authenticateUser(conditions)) {

			UserImages userImages = new UserImages();
			conditions.remove("userPassword");

			List images = userImages.getUserImages(conditions, request);
			HttpSession session = request.getSession();
			session.setAttribute("username", request.getParameter("username"));
			request.setAttribute("username", request.getParameter("username"));
			request.setAttribute("images", images);

			//System.out.println("request--- " + ((Image) ((List) request.getAttribute("images")).get(0)).getImage());
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
