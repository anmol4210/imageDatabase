package com.nagarro.services;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.nagarro.model.User;

public class AuthenticateUser {
public boolean authenticateUser(Map conditions){
	SessionFactory sf=new Configuration().configure("hibernate/mapping/hibernate.cfg.xml").buildSessionFactory();
	Session session= sf.openSession();
	session.beginTransaction();
	 Criteria cr = session.createCriteria(User.class);
	  cr.add(Restrictions.allEq(conditions));
      List employees = cr.list();
      System.out.println("Size-> "+employees.size());
  if(employees.size()>0){
	  return true;
  }
  else{
	  return false;
  }
      // User result=(User) employees.get(0);
//result.getUsername();

	
}
}
