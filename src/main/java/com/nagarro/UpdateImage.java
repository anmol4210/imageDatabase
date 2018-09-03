package com.nagarro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.services.UpdateImg;

/**
 * Servlet implementation class UpdateImage
 */
public class UpdateImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		System.out.println("hello");
//		System.out.println(request.getParameter("newName"));
//		
//		System.out.println(request.getParameter("imageId"));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	int imageId=Integer.parseInt( request.getSession().getAttribute("imageId").toString());
//		System.out.println("hello");
//		System.out.println(request.getParameter("newName"));
//		
//		System.out.println(request.getParameter("imageId"));
//		request.getCookies();
		int imageid = 0;
			  Cookie[] cookies=request.getCookies();
			    if(cookies!=null){
			    	for(Cookie cookie:cookies){
			    		if(cookie.getName().equals("imageId")){
			    			imageid=Integer.parseInt(cookie.getValue());
			    		}
			    	}
			    }
			    System.out.println(imageid);
			    //System.out.println(request.getParameter("image"));
			    UpdateImg updateImage=new UpdateImg();
			    updateImage.updateImage(imageid, request);
				response.sendRedirect("imageManagement.jsp");
		//doGet(request, response);
	}

}
