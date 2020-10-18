package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Course;
import domain.Student;

//ADD NEW STUDENTS FOR AN EXISTING COURSE

public class SaveStudentCourseDetails_3 
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg= new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Student.class);
		cfg=cfg.addAnnotatedClass(Course.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//load the Course object
		
		Course c1=ses.load(Course.class, 1);
		
		//create object of Student
		
		Student s1=new Student();
		s1.setStudentName("NITIN");
		s1.setStudentEmail("dhjfk@gmail.com");
		
		//add student for existing course
		
		c1.addStudents(s1);
		
		tx=ses.beginTransaction();
		
		ses.save(s1);
		
		tx.commit();
		
		System.out.println("Student details inserted");
		
	}

}
