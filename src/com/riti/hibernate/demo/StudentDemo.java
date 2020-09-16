package com.riti.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.riti.entity.Student;

public class StudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Creating new student");
			Student student = new Student("Ritika", "Sharma", "rshar@hawaii.edu");
			session.beginTransaction();
			session.save(student);
			System.out.println("saving new student");

			session.getTransaction().commit();
			System.out.println("committing student changes");

			session.close();

		} finally {
			factory.close();
		}
	}

}
