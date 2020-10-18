package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Passport;
import domain.Person;

public class UpdatePersonDeails_5
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
        cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Passport.class);
		cfg=cfg.addAnnotatedClass(Person.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Person pr=ses.load(Person.class, 1);
		
		pr.setPersonAge(45);
		pr.getPassRef().setPassportNumber("WQP155SDKOSD8");
		
		tx=ses.beginTransaction();
		
		ses.update(pr);
		
		tx.commit();
		
		System.out.println("Person Details Updated Successfully");
	}

}
