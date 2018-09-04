package com.nagarro;

import java.io.IOException;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.io.output.*;

import com.nagarro.services.DeleteImage;
import com.nagarro.services.SaveImage;
import com.nagarro.services.UploadImage;
import com.nagarro.services.UserImages;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
	}

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("delete".equals(request.getParameter("action"))) {
		 System.out.println("delete called");
			System.out.println(request.getParameter("imageId"));
			
			Map<String,Integer> conditions = new HashMap();
			conditions.put("id", Integer.parseInt(request.getParameter("imageId")));
			DeleteImage deleteImage=new DeleteImage();
			deleteImage.deleteImage(conditions);
			
			Map condtions = new HashMap();
			condtions.put("username", request.getSession().getAttribute("username"));
			UserImages userImages = new UserImages();
			userImages.getUserImages(condtions, request);
			response.sendRedirect("imageManagement.jsp");
		}

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UploadImage uploadImage = new UploadImage();
		uploadImage.uploadImage(request);
		SaveImage saveimage = new SaveImage();
		saveimage.storeImage(request);
		
//		System.out.println("username-session: "+request.getSession().getAttribute("username"));
		
		Map conditions = new HashMap();
		conditions.put("username", request.getSession().getAttribute("username"));
		UserImages userImages = new UserImages();
		userImages.getUserImages(conditions, request);
		
			response.sendRedirect("imageManagement.jsp");
//		RequestDispatcher rd = request.getRequestDispatcher("imageManagement.jsp");
//		request.setAttribute("inValid", null);
//		rd.include(request, response);
		
		// FileInputStream input = null;
		// File theFile = new File("sample_resume.pdf");
		// input = new FileInputStream(theFile);
		// myStmt.setBinaryStream(1, input);

	}
	


}
