package com.onesolvent.config;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mysql.cj.xdevapi.SessionFactory;
import com.onesolvent.entity.Student;

public class HQL3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		org.hibernate.SessionFactory sessionFactory = new Configuration()
				                        .configure()
				                        .addAnnotatedClass(Student.class)
				                        .buildSessionFactory();
		
		
		
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		
		  Student student = session2.get(Student.class, 1);
		  session2.delete(student);
		 
		session2.getTransaction().commit();
		
		

	}

	
}
