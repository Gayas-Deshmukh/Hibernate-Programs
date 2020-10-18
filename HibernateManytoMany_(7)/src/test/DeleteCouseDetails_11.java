package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Course;
import domain.Student;

// delete Course without affecting student details

public class DeleteCouseDetails_11 
{

	public static void main(String[] args) 
	{

		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;

		cfg= new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Student.class);
		cfg=cfg.addAnnotatedClass(Course.class);

		factory=cfg.buildSessionFactory();

		ses=factory.openSession();
		
		Course c=ses.load(Course.class, 2);
		
		tx=ses.beginTransaction();
		
		ses.delete(c);
		
		tx.commit();
		
		System.out.println("Course Details Deleted");

	}

}
