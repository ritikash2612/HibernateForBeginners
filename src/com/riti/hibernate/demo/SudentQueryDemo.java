package com.riti.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.riti.entity.Student;

public class SudentQueryDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {

			session.beginTransaction();

			// query
			List<Student> students = session.createQuery("from Student s where s.lastName = 'Sharma'").getResultList();


			session.getTransaction().commit();
			
			// print the result 
			for(Student st : students) {
				System.out.println(st.getFisrtName());
			}
			System.out.println("committing student changes");

			session.close();

		} finally {
			factory.close();
		}

	}

}
