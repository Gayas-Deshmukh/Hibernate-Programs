package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Student_1;

public class DeleteStudent_4 
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Student_1 s1=ses.load(Student_1.class, 1);
		
		tx=ses.beginTransaction();
		
		ses.delete(s1);
		
		tx.commit();
		
		System.out.println("Record Deleted Successfully");

	}

}
