package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Student;

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
	     cfg=cfg.addAnnotatedClass(Student.class);
	     
	     factory=cfg.buildSessionFactory();
	     
	     ses=factory.openSession();
	     
	     tx=ses.beginTransaction();
	     
	     //delete student whose id<3
	     Query q=ses.createQuery(" delete Student s where s.studentId<3");
	     
	     int count=q.executeUpdate();
	     
	     tx.commit();
	     
	     System.out.println(count+" Students Record Deleted");
	}

}
