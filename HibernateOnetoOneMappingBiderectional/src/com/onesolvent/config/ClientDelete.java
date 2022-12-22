package com.onesolvent.config;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;
import com.onesolvent.entity.Instructor;
import com.onesolvent.entity.InstructorDetails;

public class ClientDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		org.hibernate.SessionFactory sessionFactory = new Configuration()
				                        .configure()
				                        .addAnnotatedClass(Instructor.class)
				                        .addAnnotatedClass(InstructorDetails.class)
				                        .buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		

		Instructor instructor=new Instructor("Chad", "Darby", "cd@rediff.com");
		InstructorDetails instructorDetails=new InstructorDetails("luv2code", "luv2code");
		instructor.setInstructorDetailId(instructorDetails);
		
		Transaction beginTransaction = session.beginTransaction();
		session.save(instructor);
		beginTransaction.commit();

	}

}
