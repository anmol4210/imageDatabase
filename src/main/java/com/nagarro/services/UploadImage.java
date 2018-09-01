package com.nagarro.services;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.nagarro.constants.Constants;

public class UploadImage {
	/**
	 * @param request
	 */
	public void uploadImage(HttpServletRequest request) {

		File file;
		int maxFileSize = 5000 * 1024;
		int maxMemSize = 5000 * 1024*10;
		// ServletContext context = request.getServletContext();
		String filePath = Constants.serverFilePath;

		// Verify the content type
		String contentType = request.getContentType();

		if ((contentType.indexOf("multipart/form-data") >= 0)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// maximum size that will be stored in memory
			factory.setSizeThreshold(maxMemSize);

			// Location to save data that is larger than maxMemSize.
			factory.setRepository(new File("c:\\temp"));

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// maximum file size to be uploaded.
			upload.setSizeMax(maxFileSize);

			try {
				// Parse the request to get file items.
				List fileItems = upload.parseRequest(request);

				// Process the uploaded file items
				Iterator i = fileItems.iterator();

				System.out.println("<html>");
				System.out.println("<head>");
				System.out.println("<title>JSP File upload</title>");
				System.out.println("</head>");
				System.out.println("<body>");

				while (i.hasNext()) {
					FileItem fi = (FileItem) i.next();
					if (!fi.isFormField()) {
						// Get the uploaded file parameters
						String fieldName = fi.getFieldName();
						String fileName = fi.getName();
						boolean isInMemory = fi.isInMemory();
						long sizeInBytes = fi.getSize();
						System.out.println("fileName "+fileName);

						// Write the file
						if (fileName.lastIndexOf("\\") >= 0) {
							file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
						} else {
							file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
						}
						fi.write(file);
						System.out.println("Uploaded Filename: " + filePath + fileName + "<br>");
					}
				}
				System.out.println("</body>");
				System.out.println("</html>");
			} catch (Exception ex) {
				System.out.println(ex);
			}
		} else {
			System.out.println("<html>");
			System.out.println("<head>");
			System.out.println("<title>Servlet upload</title>");
			System.out.println("</head>");
			System.out.println("<body>");
			System.out.println("<p>No file uploaded</p>");
			System.out.println("</body>");
			System.out.println("</html>");
		}

	}
}
