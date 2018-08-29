package com.nagarro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.model.User;

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
		SessionFactory sf=new Configuration().configure("hibernate/mapping/hibernate.cfg.xml").buildSessionFactory();
		Session session= sf.openSession();
		session.beginTransaction();
/////////////////////////////Insert Query/////////////////////////
		//	User user =new User();
//	user.setId(2);
//	user.setUsername("sid");
//	user.setUserPassword("sid");
//	
//	session.save(user);
//	session.getTransaction().commit();
/////////////////////////////////////////////////////////////////////
//////////////////////////////Select Query////////////////
		User user=(User)session.load(User.class, new Integer(1));
		System.out.println(user.getUsername());
		System.out.println(user.getUserPassword());
		System.out.println(user.getId());
				
		////////////////////////////////////////
	
	
	
		//System.out.println(request.getParameter("username"));
		//System.out.println(request.getParameter("password"));
		//doGet(request, response);
	}

}
