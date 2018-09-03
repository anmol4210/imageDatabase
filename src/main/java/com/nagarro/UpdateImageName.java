package com.nagarro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.services.UpdateName;

/**
 * Servlet implementation class UpdateImageName
 */
public class UpdateImageName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateImageName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int imageid = 0;
		  Cookie[] cookies=request.getCookies();
		    if(cookies!=null){
		    	for(Cookie cookie:cookies){
		    		if(cookie.getName().equals("imageId")){
		    			imageid=Integer.parseInt(cookie.getValue());
		    		}
		    	}
		    }
		    UpdateName updateImageName=new UpdateName();
		    updateImageName.updateName(Integer.parseInt(imageid+""), request.getParameter("imgNewName"));
		    System.out.println(imageid);
		    System.out.println(request.getParameter("imgNewName"));
			response.sendRedirect("imageManagement.jsp");

	
	}

}
