package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Student;

public class UpdateStudent_3
{

	public static void main(String[] args)
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Student.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		tx=ses.beginTransaction();
			
		// Update students name
		// SQL==> update student_data set studentStream='Electrical';
		Query q=ses.createQuery("update Student s set s.studentStream='Electrical'");
		
		int count=q.executeUpdate();
		
		tx.commit();
		
		System.out.println(count+" Students Name Updated");

	}

}
