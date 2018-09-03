package com.nagarro;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.services.ChangePassword;

/**
 * Servlet implementation class UpdatePasword
 */
public class UpdatePasword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> conditions=new HashMap();
		conditions.put("username",request.getParameter("username"));
	
		ChangePassword changePassword=new ChangePassword();
		if(changePassword.changePassword(conditions, request.getParameter("newPassword"))){
			response.sendRedirect("index.jsp");

		}
		else{
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("changePassword.jsp");
		request.setAttribute("inValidUsername", "true");
		requestDispatcher.include(request, response);
		}
	}

}
