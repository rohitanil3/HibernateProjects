package com.onesolvent.config;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;
import com.onesolvent.entity.Student;

public class ReadObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		org.hibernate.SessionFactory sessionFactory = new Configuration()
				                        .configure()
				                        .addAnnotatedClass(Student.class)
				                        .buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		Student s=new Student("Tarun", "N", "TN@gmail.com");
		
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		Student student = session2.get(Student.class, s.getId());
		session2.getTransaction().commit();
		System.out.println(student);
		
		

	}

}
