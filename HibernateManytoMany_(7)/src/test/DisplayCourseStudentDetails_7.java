package test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Course;
import domain.Student;

// Accept Course id from end user and display list of Students
public class DisplayCourseStudentDetails_7 
{

	public static void main(String[] args)
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER COURSE ID");
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

		Course c1=ses.get(Course.class,id);

		if(c1!=null)
		{		
			System.out.println("COURSE NAME : "+c1.getCourseName());

			System.out.println("COURSE CODE : "+c1.getCourseCode());

			System.out.println("---------------------------------------------");

			List<Student> students=c1.getStudentlist();

			System.out.println("LIST OF ENROLLED STUDENTS");

			System.out.println("NAME\t\tEMAIL");

			System.out.println("--------------------------------");

			for(Student s:students)
			{
				System.out.println(s.getStudentName()+"\t\t"+s.getStudentEmail());
			}
		}
		else
		{
			System.out.println("RECORD NOT FOUND");
		}


	}

}
