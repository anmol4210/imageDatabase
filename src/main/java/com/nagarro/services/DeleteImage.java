package com.nagarro.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.model.Image;
import com.nagarro.model.User;
import com.nagarro.util.HibernateUtil;

/**
 * @author anmolnarang
 *
 */
public class DeleteImage {
/**
 * @param conditions
 */
public void deleteImage(Map conditions){
	HibernateUtil hibernateUtil = new HibernateUtil();
	Session session = hibernateUtil.createSession();
	
	
	Criteria cr = session.createCriteria(Image.class);
	cr.add(Restrictions.allEq(conditions));
	List images = cr.list();
	session.delete(images.get(0));
	session.getTransaction().commit();

}
}
