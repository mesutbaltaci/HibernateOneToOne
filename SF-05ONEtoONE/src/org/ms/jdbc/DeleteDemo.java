package org.ms.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.ms.entities.Instructor;
import org.ms.entities.InstructorDetail;


public class DeleteDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int theId =1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println(tempInstructor);
			
			if (tempInstructor!=null) {
				//also deleting details object
				session.delete(tempInstructor);
			}
			
			session.getTransaction().commit();
			System.out.println("Done");
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		finally {
			factory.close();
		}
	}
}
