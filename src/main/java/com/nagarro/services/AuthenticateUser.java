package com.nagarro.services;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.nagarro.constants.Constants;
import com.nagarro.model.User;
import com.nagarro.util.HibernateUtil;

public class AuthenticateUser {
	/**
	 * @param conditions
	 * @return
	 */
	public boolean authenticateUser(Map conditions) {

		HibernateUtil hibernateUtil = new HibernateUtil();
		Session session = hibernateUtil.createSession();

		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.allEq(conditions));
		List employees = cr.list();
		// System.out.println("Size-> "+employees.size());
		if (employees.size() > 0) {
			return true;
		} else {
			return false;
		}
		// User result=(User) employees.get(0);
		// result.getUsername();

	}
}
