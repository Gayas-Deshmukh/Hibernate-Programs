package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Student;

public class DisplayStudentName_2 
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
		
		//display student name
		
		Query q=ses.createQuery("select s.studentName from Student s");
		
		List <String> name=q.list();
		
		System.out.println("Student Names Are: ");
		
		for(String s:name)
		{
			System.out.println(s);
		}
		

	}

}
