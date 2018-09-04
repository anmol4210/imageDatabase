package com.nagarro.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.constants.Constants;

/**
 * @author anmolnarang
 *
 */
public class HibernateUtil {
/**
 * @return
 */
public Session createSession(){
	SessionFactory sf=new Configuration().configure(Constants.hibernateFilePath).buildSessionFactory();
	Session session= sf.openSession();
	session.beginTransaction();
	return session;
}
}
