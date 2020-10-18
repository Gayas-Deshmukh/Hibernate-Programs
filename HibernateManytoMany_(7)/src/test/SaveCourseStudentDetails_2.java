package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Course;
import domain.Student;

//SAVE STUDENT AND COURSE DETAILS
//ADD MULTIPLE STUDENTS FOR SINGLE COURSE

public class SaveCourseStudentDetails_2 
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
		
		//create object of course
		
		Course c1=new Course();
		c1.setCourseName("WEBTECH");
		c1.setCourseCode("DF77K");
		
		//create object of Student
		
		Student s1=new Student();
		s1.setStudentName("ANIL");
		s1.setStudentEmail("adjfjed@gmail.com");
		
		Student s2=new Student();
		s2.setStudentName("ABHIJIT");
		s2.setStudentEmail("frefjk@gmail.com");
		
		// add students for course
		
		c1.addStudents(s1);
		c1.addStudents(s2);
		
		tx=ses.beginTransaction();
		
		ses.save(c1);
		ses.save(s1);
		ses.save(s2);
		
		tx.commit();
		
		System.out.println("Student and Course details inserted");
		

	}

}
