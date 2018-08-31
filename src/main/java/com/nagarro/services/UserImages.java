package com.nagarro.services;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

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
	 */
	public List getUserImages(Map conditions, HttpServletRequest request) {

		HibernateUtil hibernateUtil = new HibernateUtil();
		Session session = hibernateUtil.createSession();

		Criteria cr = session.createCriteria(Image.class);
		cr.add(Restrictions.allEq(conditions));
		List images = cr.list();

		for (int index = 0; index < images.size(); index++) {
			Image imgNew = (Image) images.get(index);
			byte[] bAvatar = imgNew.getImage();

			try {
				String imageFilePath = "" + new File(".").getAbsolutePath() + "\\images";
				new File(imageFilePath).mkdir();

				// System.out.println(
				// request.getServletPath());//.getRealPath(relativeWebPath);
				FileOutputStream fos = new FileOutputStream(imageFilePath + "\\test" + index + ".jpg");
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
