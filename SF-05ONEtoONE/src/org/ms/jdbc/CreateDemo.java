package org.ms.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.ms.entities.Instructor;
import org.ms.entities.InstructorDetail;


public class CreateDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			//create objects
			Instructor tempInstructor = new Instructor("Sercan","Baltaci","sercan@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("enjoy yourself", "swim,watching movie");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			//associate the objects
			
			//start transaction
			session.beginTransaction();
			
			//note this will save also the details object because of cascadetype.all
			session.save(tempInstructor);
			
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
