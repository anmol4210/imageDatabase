package com.nagarro;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.services.UpdateImg;
import com.nagarro.services.UserImages;

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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			    UpdateImg updateImage=new UpdateImg();
			    updateImage.updateImage(imageid, request);
				Map condtions = new HashMap();
				condtions.put("username", request.getSession().getAttribute("username"));
				UserImages userImages = new UserImages();
				userImages.getUserImages(condtions, request);
			    response.sendRedirect("imageManagement.jsp");
	}

}
