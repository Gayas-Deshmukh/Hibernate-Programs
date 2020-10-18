package test;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Course;
import domain.Student;

// Display List of all Courses along with  respective Students
public class DisplayAllCourseStudentDatails_8
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
		
		Criteria crt=ses.createCriteria(Course.class);
		
		List<Course> courselist=crt.list();
		
		for(Course c:courselist)
		{
			System.out.println("Course Name :"+c.getCourseName());
			System.out.println("Course Code :"+c.getCourseCode());
			
			System.out.println("-----------------------------------------");
			
			System.out.println("List Of Enrolled Students");
			
			System.out.println("Name\t\tEmail");
			
			System.out.println("----------------------------------");
			
			List<Student> students=c.getStudentlist();
			
			int count=students.size();
			
			for(Student s:students)
			{
				System.out.println(s.getStudentName()+"\t\t"+s.getStudentEmail());
			}
			
			System.out.println("-----------------------------------");
			
			System.out.println("Total Number of Students : "+count);
			
			System.out.println("====================================================");
			
		}

	}

}
