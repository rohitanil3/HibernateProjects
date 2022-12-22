package com.onesolvent.config;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;
import com.onesolvent.entity.Course;
import com.onesolvent.entity.Instructor;
import com.onesolvent.entity.InstructorDetails;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		org.hibernate.SessionFactory sessionFactory = new Configuration()
				                        .configure()
				                        .addAnnotatedClass(Instructor.class)
				                        .addAnnotatedClass(InstructorDetails.class)
				                        .addAnnotatedClass(Course.class)
				                        .buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		int theId=3;
		
		Transaction beginTransaction = session.beginTransaction();
		Course course=new Course("Java");
		Course course2=new Course("SQL");
		Instructor instructor=new Instructor("Chad", "Darby", "C@gmail.com");
		InstructorDetails details=new InstructorDetails("luv2Code", "Programming");
		instructor.setInstructorDetailId(details);
		
		ArrayList<Course> courses=new ArrayList<>();
		courses.add(course);
		courses.add(course2);
		course.setInstructor(instructor);
		course2.setInstructor(instructor);

		instructor.setCourses(courses);
		
		session.save(instructor);
		

		beginTransaction.commit();

	}

}
