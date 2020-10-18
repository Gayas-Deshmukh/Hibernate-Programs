package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Student_1;

public class SaveStudent_1 
{

	public static void main(String[] args)
	{
	  //declare the resources
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
	 // Step-1 Activate The Hibernate Framwork
		cfg=new Configuration();
		
	 // Step-2  Read the data from cfg and Mapping file
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		
	 // Step-3 Build the connection with db vendor
		factory=cfg.buildSessionFactory();
		
	 // Step-4 Start the session with db vendor
		ses=factory.openSession();
		
	 // Step-5 Create an object of domain class
		Student_1 s1=new Student_1();
		s1.setStudentId(1);
		s1.setStudentName("Gayas");
		s1.setStudentStream("Electrical");
		s1.setStudentPercentage(73.47);
		
	 // Step-6 Start the Transaction with db vendor
		tx=ses.beginTransaction();
		
	 // Step-7 Save the object of domain class
		ses.save(s1);
		
	 // Step-8 Commit the Transaction
		tx.commit();
		
		System.out.println("Student details inserted successfully");

	}

}
