package com.riti.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.riti.entity.Student;

public class StudentDeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			
			session.beginTransaction();
			//get the student you want to delete
			Student student = session.get(Student.class, 4);
			
			System.out.println("deleting the student with id 4");
			session.delete(student);
			
			session.getTransaction().commit();
			System.out.println("committing student changes");

			session.close();

		} finally {
			factory.close();
		}
	}

}
