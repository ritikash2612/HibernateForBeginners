package com.riti.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.riti.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Creating new students");
			Student student1 = new Student("Ruchika", "Sharma", "ruchish@gmail.com");
			Student student2 = new Student("Rohit", "Ghosh", "gosh@gmail.com");
			Student student3 = new Student("Lali", "Bose", "bosel@gmail.com");

			session.beginTransaction();
			session.save(student1);
			session.save(student2);
			session.save(student3);
			System.out.println("saving new students");

			session.getTransaction().commit();
			System.out.println("committing student changes");

			session.close();

		} finally {
			factory.close();
		}
	}

}
