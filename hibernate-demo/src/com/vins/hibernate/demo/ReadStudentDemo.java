package com.vins.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vins.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Begin new student object...");
			Student tempStudent = new Student("Darshil", "shah" , "Darshil.shah@ril.com");
			session.beginTransaction();
			System.out.println("saving the session...");
			session.save(tempStudent);
			System.out.println("commit session...");
			session.getTransaction().commit();
			System.out.println("done!!!");
			System.out.println("Student record saved. student ID "+ tempStudent.getId());
			
			//Retrieve the data
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student student1= session.get(Student.class, tempStudent.getId());
			Student student2 = session.get(Student.class, 1);
			System.out.println(student1);
			System.out.println(student2);
			session.getTransaction().commit();
			System.out.println("done..");
			
			
		}catch(Exception exp) {
			exp.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

}
