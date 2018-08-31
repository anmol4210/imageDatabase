package com.nagarro.services;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.constants.Constants;
import com.nagarro.model.Image;
import com.nagarro.util.HibernateUtil;

/**
 * @author anmolnarang
 *
 */
public class SaveImage {

	/**
	 * @param request
	 */
	public void storeImage(HttpServletRequest request) {
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session session = hibernateUtil.createSession();

		File folder = new File(Constants.serverFilePath);
		File[] listOfFiles = folder.listFiles();
		File file = new File(Constants.serverFilePath + listOfFiles[0].getName());

		byte[] imageData = new byte[(int) file.length()];

		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(imageData);
			fileInputStream.close();

			HttpSession httpSession = request.getSession();

			Image image = new Image((int) file.length());
			image.setImage(imageData);

			image.setUsername(httpSession.getAttribute("username").toString());

			session.save(image);
			session.getTransaction().commit();
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
