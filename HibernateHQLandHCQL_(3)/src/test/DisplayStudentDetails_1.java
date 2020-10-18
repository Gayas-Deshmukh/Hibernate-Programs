package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Student;

public class DisplayStudentDetails_1
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Student.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		// Display all students details
		
	    Query q=ses.createQuery("select s from Student s");
	   
		List<Student> studentlist=q.list();
		
		for(Student s1:studentlist)
		{
		 	System.out.println("Student Id: "+s1.getStudentId());
			System.out.println("Student Name: "+s1.getStudentName());
			System.out.println("Student Stream: "+s1.getStudentStream());
			System.out.println("Student Percentage: "+s1.getStudentPercentage());
			
			System.out.println("-------------------------------------------------------");
		}
		
	}

}
