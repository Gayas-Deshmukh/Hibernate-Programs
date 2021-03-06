package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Course;
import domain.Student;

//PROGRAM TO SAVE STUDENT AND COURSE DETAILS
//ADD MULTIPLE COURSES FOR SINGLE STUDENT

public class SaveStudentandCourseDetails_1
{

	public static void main(String[] args)
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Student.class);
		cfg=cfg.addAnnotatedClass(Course.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		// Create student object
		Student s1=new Student();
		s1.setStudentName("Rahul");
		s1.setStudentEmail("aksdkd@gmail.com");
		
		//Create  Course object 
		Course c1=new Course();
		c1.setCourseName("Java");
		c1.setCourseCode("AD45D");
		
		Course c2=new Course();
		c2.setCourseName("J2EE");
		c2.setCourseCode("CR48R");
		
		//Association
		//ADD COURSES FOR STUDENTS
		
		s1.addCourses(c1);
		s1.addCourses(c2);
		
		tx=ses.beginTransaction();
		
		ses.save(s1);
		ses.save(c1);
		ses.save(c2);
		
		tx.commit();
		
		System.out.println("Student and Course details inserted successfully");
		
		
	}

}
