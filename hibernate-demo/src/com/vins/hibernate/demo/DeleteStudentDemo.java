package com.vins.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vins.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			
			
			  int studentId =1; 
			  session.beginTransaction(); 
			  Student theStudent =session.get(Student.class, studentId); 
			  session.delete(theStudent);
			  session.getTransaction().commit();
			 
			
			
			  //delete rows where last name is shah
			  factory.getCurrentSession();
			  session.beginTransaction(); 
			  session.createQuery("delete Student s where s.lastName='shah'").executeUpdate();
			  session.getTransaction().commit();
			 
			
			
		}catch(Exception exp) {
			exp.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

}
