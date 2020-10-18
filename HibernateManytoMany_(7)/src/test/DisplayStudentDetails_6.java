package test;
//Accept Student Id from end user and display list of allocted Courses

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Course;
import domain.Student;

public class DisplayStudentDetails_6 
{

	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER STUDENT ID");
		int id=sc1.nextInt();

		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;

		cfg= new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Student.class);
		cfg=cfg.addAnnotatedClass(Course.class);

		factory=cfg.buildSessionFactory();

		ses=factory.openSession();

		Student s1=ses.get(Student.class, id);

		if(s1!=null)
		{

			System.out.println("STUDENT NAME : "+s1.getStudentName());

			System.out.println("STUDENT EMAIL ID : "+s1.getStudentEmail());

			System.out.println("---------------------------------------------");

			System.out.println("ALLOCATED COURSES ARE : ");

			System.out.println("CourseName\tCourseCode");
			System.out.println("------------------------");

			List<Course> courses=s1.getCourselist();
			for(Course c:courses)
			{
				System.out.println(c.getCourseName()+"\t\t"+c.getCourseCode());
			}
		}
		else
		{
			System.out.println("RECORD NOT FOUND");
		}

	}

}
