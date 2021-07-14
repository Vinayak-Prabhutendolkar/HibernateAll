package com.vins.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vins.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			
			int studentId =1;
			session.beginTransaction();
			Student theStudent = session.get(Student.class, studentId);
			System.out.println(theStudent);
			theStudent.setFirstName("Akshay");
			session.getTransaction().commit();
			
			//update table set last name as khaire where fistname is Akshay
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student s set s.lastName='Khaire' where s.firstName='Akshay'").executeUpdate();
			session.getTransaction().commit();
			
			
		}catch(Exception exp) {
			exp.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

}
