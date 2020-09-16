package com.riti.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.riti.entity.Student;

public class StudentMergeDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Student student = null;
		Session session = factory.getCurrentSession();
		try {

			session.beginTransaction();

			// query to fetch object to make update
			student = session.get(Student.class, 1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();

		student.setEmail("r.gmail.com");

		try {
			session = factory.getCurrentSession();
			session.beginTransaction();

			// query to fetch object to make update
			Student student2 = session.get(Student.class, 1);

			// trying to update the student email
			session.merge(student); // use 'update' to check the difference
			session.getTransaction().commit();
			session.close();

		} finally {
			factory.close();
		}

	}

	// would say "A different object with the same identifier value was already
	// associated with the session : [com.riti.entity.Student#1]" - in case of
	// update because the session object is still present
	// the object has not been detached from the session and hence the update
	// operation cannot be performed

	// Use MERGE if you want to save your modifications at any time with out knowing
	// about the state of an session, then use merge() in hibernate.

	// in case of Merge this will work
}
