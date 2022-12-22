package com.onesolvent.config;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;
import com.onesolvent.entity.Student;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		org.hibernate.SessionFactory sessionFactory = new Configuration()
				                        .configure()
				                        .addAnnotatedClass(Student.class)
				                        .buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		Student student=new Student("Mohit", "Ka", "ones@gmail.com");
		Student student2=new Student("Jit", "Ka", "ons@gmail.com");
		Student student3=new Student("Kit", "Ka", "s@gmail.com");
		Student student4=new Student("Chad", "Darby", "ones@gmail.com");
		
		Transaction beginTransaction = session.beginTransaction();
		session.save(student);
		session.save(student2);
		session.save(student3);
		session.save(student4);
		beginTransaction.commit();

	}

}
