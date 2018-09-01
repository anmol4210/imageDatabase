package com.nagarro.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.FileUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.model.Image;
import com.nagarro.util.HibernateUtil;

public class UserImages {
	/**
	 * @param conditions
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	public List getUserImages(Map conditions, HttpServletRequest request) throws IOException {

		HibernateUtil hibernateUtil = new HibernateUtil();
		Session session = hibernateUtil.createSession();

		Criteria cr = session.createCriteria(Image.class);
		cr.add(Restrictions.allEq(conditions));
		List images = cr.list();
		
		String imageFilePath = "" + new File(".").getAbsolutePath() + "\\images";
		new File(imageFilePath).mkdir();

		File directory = new File(imageFilePath);      

		FileUtils.cleanDirectory(directory);
		
		
		for (int index = 0; index < images.size(); index++) {
			Image imgNew = (Image) images.get(index);
			byte[] bAvatar = imgNew.getImage();

			try {
			
				// System.out.println(
				// request.getServletPath());//.getRealPath(relativeWebPath);
				String imageName=imgNew.getImageName();
				imageName=imageName.substring(imageName.lastIndexOf("\\")+1, imageName.lastIndexOf("."))+"#"+imgNew.getId();
				FileOutputStream fos = new FileOutputStream(imageFilePath + "\\" + imageName + ".jpg");
				fos.write(bAvatar);
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		session.getTransaction().commit();
		// System.out.println("Size-> "+employees.size());
		return images;
	}
}
