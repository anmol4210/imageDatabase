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
	/**
	 * @param request
	 * @return
	 */
	public boolean uploadImage(HttpServletRequest request) {

		File file;
		String filePath = Constants.serverFilePath;

		// Verify the content type
		String contentType = request.getContentType();

		if ((contentType.indexOf("multipart/form-data") >= 0)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
	
			// Location to save data that is larger than maxMemSize.
			factory.setRepository(new File("c:\\temp"));

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

	
			try {
				// Parse the request to get file items.
				List fileItems = upload.parseRequest(request);

				// Process the uploaded file items
				Iterator iterator = fileItems.iterator();

				
				while (iterator.hasNext()) {
					FileItem fileItem = (FileItem) iterator.next();
					if (!fileItem.isFormField()) {
						// Get the uploaded file parameters
						String fieldName = fileItem.getFieldName();
						String fileName = fileItem.getName();
						
						boolean isInMemory = fileItem.isInMemory();
						long sizeInBytes = fileItem.getSize();
						System.out.println("fileName "+fileName);
						System.out.println("FileSize: "+sizeInBytes);
						System.out.println("Folder size: "+request.getSession().getAttribute("folderSize"));
						long floderSize=Long.parseLong(request.getSession().getAttribute("folderSize")+"");
						if((floderSize+sizeInBytes)>Constants.maxMemSize){
							return false;
						}
						if(sizeInBytes>Constants.maxFileSize){
							return false;
						}
						// Write the file
						if (fileName.lastIndexOf("\\") >= 0) {
							file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
						} else {
							file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
						}
						fileItem.write(file);
						System.out.println("Uploaded Filename: " + filePath + fileName + "<br>");
					}
				}
				
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
return true;
	}
}
