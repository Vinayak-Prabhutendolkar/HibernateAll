package com.vins.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vins.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {

			session.beginTransaction();
			
			//select * from query
			
			List<Student> theStudents = session.createQuery("from Student").list();
			displayRecords(theStudents);
			
			//Select * from table where condition
			System.out.println("...student who has last name as shah");
			theStudents = session.createQuery("from Student s where s.lastName='Shah'").list();
			displayRecords(theStudents);
			
			//select * from table where OR condition
			System.out.println("...students whos either last name is shah or firname is vinayak");
			theStudents= session.createQuery("from Student s where" + " s.lastName='Prabhu' OR s.firstName='Darshil'").list();
			displayRecords(theStudents);
			
			//select * from table where like condition
			System.out.println("...studnets whos email ids contains ril.com");
			theStudents = session.createQuery("from Student s where" +" s.email LIKE '%ril.com'").list();
			displayRecords(theStudents);
					
					
			System.out.println("commit session...");
			session.getTransaction().commit();
			System.out.println("done!!!");

		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			factory.close();
		}
	}

	private static void displayRecords(List<Student> theStudents) {
		for (Student theStudent : theStudents) {
			System.out.println(theStudent);
		}
	}

}
