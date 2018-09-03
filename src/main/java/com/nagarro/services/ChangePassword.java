package com.nagarro.services;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.model.Image;
import com.nagarro.model.User;
import com.nagarro.util.HibernateUtil;

public class ChangePassword {
public boolean changePassword(Map conditions,String newPassword){
	HibernateUtil hibernateUtil = new HibernateUtil();
	Session session = hibernateUtil.createSession();

	Criteria cr = session.createCriteria(User.class);
	cr.add(Restrictions.allEq(conditions));
	List employees = cr.list();
	if (employees.size() > 0) {
		
		Object object=session.load(User.class,new Integer(((User)employees.get(0)).getId()));

		User user=(User)object;


		user.setUserPassword(newPassword);
		session.getTransaction().commit();
		return true;
	} else {
		return false;
	}
	
	
}
}
