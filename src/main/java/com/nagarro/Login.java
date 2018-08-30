package com.nagarro;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.nagarro.model.User;
import com.nagarro.services.AuthenticateUser;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		 // Add restriction.
		 Map conditions=new HashMap();
		 conditions.put("username", request.getParameter("username"));
		 conditions.put("userPassword", request.getParameter("password"));
         //cr.add(Restrictions.eqOrIsNull("username", "anmol"));
       AuthenticateUser authenticate=new AuthenticateUser();
       if(authenticate.authenticateUser(conditions)){
       
    	   RequestDispatcher rd=request.getRequestDispatcher("/imageManagement.jsp");  
    	   rd.forward(request, response);
       }else{
    	   System.out.println("Incorrect username or password");
       }
       
/////////////////////////////Insert Query/////////////////////////
//			User user =new User();
//	user.setId(2);
//	user.setUsername("sid");
//	user.setUserPassword("sid");
//	
//	session.save(user);
//	session.getTransaction().commit();
/////////////////////////////////////////////////////////////////////
//////////////////////////////Select Query////////////////
		//User findUser=new User();
		//findUser.setId(1);
//		User user=(User)session.load(User.class, new Integer(1));
//		System.out.println(user.getUsername());
//		System.out.println(user.getUserPassword());
//		System.out.println(user.getId());
//				
		////////////////////////////////////////
	
	
		//System.out.println(request.getParameter("username"));
		//System.out.println(request.getParameter("password"));
		//doGet(request, response);
	}

}
