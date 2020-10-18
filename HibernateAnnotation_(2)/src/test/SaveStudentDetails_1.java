package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Student_1;

public class SaveStudentDetails_1 
{

	public static void main(String[] args)
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Student_1.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Student_1 s1=new Student_1();
		s1.setStudentId(1);
		s1.setStudentName("Rajesh");
		s1.setStudentStream("CIVIL");
		s1.setStudentPercentage(66.25);
		
		Student_1 s2=new Student_1();
		s2.setStudentId(2);
		s2.setStudentName("Mitesh");
		s2.setStudentStream("Mechanical");
		s2.setStudentPercentage(87.25);
		
		
		tx=ses.beginTransaction();
		
		ses.save(s1);
		ses.save(s2);
		
		tx.commit();
		
		System.out.println("Student Details Inserted Successfully");
	}

}
