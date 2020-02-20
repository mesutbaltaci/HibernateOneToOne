package org.ms.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.ms.entities.Instructor;
import org.ms.entities.InstructorDetail;


public class ReadBidirectionalDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			//create objects
			
			
			
			//associate the objects
			
			//start transaction
			session.beginTransaction();
			int tempId=2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, tempId);
			
			System.out.println(tempInstructorDetail.getInstructor());
			
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
