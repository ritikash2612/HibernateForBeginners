package com.riti.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.riti.entity.Student;

public class StudentUpdateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {

			session.beginTransaction();

			// query to fetch object to make update
			Student student = session.get(Student.class, 1);


			// print the result
			student.setEmail("ruchi@gmail.com");
			
			System.out.println("committing to save student updates");
			session.getTransaction().commit();

			session.close();

		} finally {
			factory.close();
		}
	}

}
