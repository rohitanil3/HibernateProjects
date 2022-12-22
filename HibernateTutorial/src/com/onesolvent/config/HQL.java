package com.onesolvent.config;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;
import com.onesolvent.entity.Student;

public class HQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		org.hibernate.SessionFactory sessionFactory = new Configuration()
				                        .configure()
				                        .addAnnotatedClass(Student.class)
				                        .buildSessionFactory();
		
		
		
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		
		 displayRes(session2);
		 
		session2.getTransaction().commit();
		
		

	}

	private static void displayRes(Session session2) {
		List resultList = session2.createQuery("from Student s where s.first_name='Tarun' ").getResultList();
		 for (Object object : resultList) {
			 System.out.println(object);
			
		}
	}

}
