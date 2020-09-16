package com.riti.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.riti.entity.Student;

public class StudentReadDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {

			System.out.println("Creating new student");
			Student tempStudent = new Student("Dolly", "Mini", "dolly@hawaii.edu");
			session.beginTransaction();
			session.save(tempStudent);
			System.out.println("saving new student");


			// code to retrieve object

			System.out.println("Saved and Generated id: " + tempStudent.getId());
			System.out.println("committing student changes");

			// retrieve student based on Id : pk

			Student student = session.get(Student.class, tempStudent.getId());

			System.out.println("Fetch student info: " + student.getFisrtName());
			session.getTransaction().commit();

			session.close();

		} finally {
			factory.close();
		}
	}

}
