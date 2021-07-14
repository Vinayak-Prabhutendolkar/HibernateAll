package com.vins.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vins.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Begin new student object...");
			Student tempStudent = new Student("Vinayak", null , "Vinayak.prabhutendolkar@outlook.com");
			session.beginTransaction();
			System.out.println("saving the session...");
			session.save(tempStudent);
			System.out.println("commit session...");
			session.getTransaction().commit();
			System.out.println("done!!!");
			
			
			
			
		}catch(Exception exp) {
			exp.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

}
