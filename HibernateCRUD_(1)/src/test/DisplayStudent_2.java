package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Student_1;

public class DisplayStudent_2
{

	public static void main(String[] args) 
	{
	// declare the resources
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
      cfg=new Configuration();
      
      cfg=cfg.configure("cfgs/hibernate.cfg.xml");
      
      factory=cfg.buildSessionFactory();
      
      ses=factory.openSession();
      
    // Load the object from database table
       
      Student_1 s1=ses.load(Student_1.class, 3);
      
      System.out.println(s1);
      
      System.out.println("Student Id is: "+s1.getStudentId());
      
      System.out.println("Student Name is: "+s1.getStudentName());
      
      System.out.println("Student Stream is: "+s1.getStudentStream());
      
      System.out.println("Student Percentage is: "+s1.getStudentPercentage());
      
	}

}
