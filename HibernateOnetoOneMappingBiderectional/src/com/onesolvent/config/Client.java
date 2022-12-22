package com.onesolvent.config;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;
import com.onesolvent.entity.Instructor;
import com.onesolvent.entity.InstructorDetails;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		org.hibernate.SessionFactory sessionFactory = new Configuration()
				                        .configure()
				                        .addAnnotatedClass(Instructor.class)
				                        .addAnnotatedClass(InstructorDetails.class)
				                        .buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		int theId=3;
		
		Transaction beginTransaction = session.beginTransaction();
		 InstructorDetails instructorDetails = session.get(InstructorDetails.class, theId);
		 System.out.println("parent "+instructorDetails.getInstructor());
		 System.out.println("Child "+instructorDetails);
		 instructorDetails.getInstructor().setInstructorDetailId(null);
		session.delete(instructorDetails);
		

		beginTransaction.commit();

	}

}
