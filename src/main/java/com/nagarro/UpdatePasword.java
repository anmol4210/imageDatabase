package com.nagarro;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.log.Log;
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
		Date date;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd 'at' h:m:s a z");
 
		Log log = new Log("log/log.txt");
         log.logger.setLevel(Level.INFO);
         date = new Date();
         log.logger.info("Data Fetched at " + dateFormatter.format(date));
         log.logger.info("Data Fetched is {"+conditions+"}");

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
