package com.nagarro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.io.output.*;

import com.nagarro.services.SaveImage;
import com.nagarro.services.UploadImage;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		// super();
		// TODO Auto-generated constructor stub
		// System.out.println("init constructor");
	}

	public void init() throws ServletException {
		// Initialization code...
		// System.out.println("init hello world");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		UploadImage uploadImage = new UploadImage();
		uploadImage.uploadImage(request);
		SaveImage saveimage = new SaveImage();
		saveimage.storeImage(request);
		// FileInputStream input = null;
		// File theFile = new File("sample_resume.pdf");
		// input = new FileInputStream(theFile);
		// myStmt.setBinaryStream(1, input);

	}

}
