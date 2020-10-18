package test;
// Display list of all Students along with respective Courses

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Course;
import domain.Student;

public class DisplayAllStudentCourseDetails_9 
{

	public static void main(String[] args) 
	{

		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;

		cfg= new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Student.class);
		cfg=cfg.addAnnotatedClass(Course.class);

		factory=cfg.buildSessionFactory();

		ses=factory.openSession();
    
		Criteria crt=ses.createCriteria(Student.class);
		
		List<Student> studentlist=crt.list();
		
		for(Student s:studentlist)
		{
			System.out.println("Student Name :"+s.getStudentName());
			
			System.out.println("Student Email :"+s.getStudentEmail());
			
			System.out.println("---------------------------------------");
			
			System.out.println("List of Allocated Courses ");
			
			System.out.println("Name\t\tCode");
			
			System.out.println("--------------------------------");
			
			List<Course> courselist=s.getCourselist();
			
			int count=courselist.size();
			
			for(Course c:courselist)
			{
				System.out.println(c.getCourseName()+"\t\t"+c.getCourseCode());
				
			}
			System.out.println("----------------------------------");
			
			System.out.println("Total Number Of Courses : "+count);
			
			System.out.println("=============================================================");
		}

	}

}
