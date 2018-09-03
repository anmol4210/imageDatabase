package com.nagarro.services;

import org.hibernate.Session;

import com.nagarro.model.Image;
import com.nagarro.util.HibernateUtil;

public class UpdateName {
public void updateName(int id,String name){
	
	HibernateUtil hibernateUtil = new HibernateUtil();
	Session session = hibernateUtil.createSession();

		Object o=session.load(Image.class,new Integer(id));

		Image s=(Image)o;

		//Transaction tx = session.beginTransaction();

		s.setImageName(name+".jpg");
		session.getTransaction().commit();
		//tx.commit();


		System.out.println("Object Updated successfully.....!!");
		//session.close();
		//factory.close(); 
		 

}
}
