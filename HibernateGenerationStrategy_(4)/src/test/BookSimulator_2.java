package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Book2;

public class BookSimulator_2 
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Book2.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Book2 b2=new Book2();
	
		b2.setBookName("HIBERNATE");
		b2.setBookPrice(5500.00);
		
		tx=ses.beginTransaction();
		
		ses.save(b2);
		
		tx.commit();
		
		System.out.println("Book Inserted Successfully");
		
		

	}

}
