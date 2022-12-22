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
		int theId=1;
		
		Transaction beginTransaction = session.beginTransaction();
		Instructor instructor2 = session.get(Instructor.class, theId);
		session.delete(instructor2);
		

		beginTransaction.commit();

	}

}
