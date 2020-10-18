package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Course;
import domain.Student;

// delete student details without affecting course details
public class DeleteStudentDetails_10 
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
		
		Student s1=ses.load(Student.class, 3);
		
		tx=ses.beginTransaction();
		
		ses.delete(s1);
		
		tx.commit();
		
		System.out.println("Student Delails Deleted");


	}

}
