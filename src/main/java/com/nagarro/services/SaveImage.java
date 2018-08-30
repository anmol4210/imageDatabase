package com.nagarro.services;

import java.io.File;
import java.io.FileInputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.model.Image;

public class SaveImage {
	
public void storeImage(){
	SessionFactory sf=new Configuration().configure("hibernate/mapping/hibernate.cfg.xml").buildSessionFactory();
	Session session= sf.openSession();
	session.beginTransaction();
	     
	File file = new File("C:\\apache-tomcat5.5.29\\webapps\\data\\car.jpg");
	byte[] imageData = new byte[(int) file.length()];
	 
	try {
	    FileInputStream fileInputStream = new FileInputStream(file);
	    fileInputStream.read(imageData);
	    fileInputStream.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	 
	Image image = new Image((int) file.length());
	image.setImage(imageData);
	image.setUsername("anmol");;
//	 
	session.save(image);    //Save the data
	 
	session.getTransaction().commit();
	
	
}
}
