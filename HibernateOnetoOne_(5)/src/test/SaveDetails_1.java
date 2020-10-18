package test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Passport;
import domain.Person;

public class SaveDetails_1
{

	public static void main(String[] args)
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER PERSON NAME");
		String name=sc1.next();
		
		System.out.println("ENTER PERSON AGE");
		int age=sc1.nextInt();
		
		System.out.println("ENTER PASSPORT NUMBER");
		String passnum=sc1.next();
		
		System.out.println("ENTER THE COUNTRY NAME");
		String country=sc1.next();
		
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
		
		// CREATE OBJECT OF PARENT CLASS
		Passport p=new Passport();
		p.setPassportNumber(passnum);
		p.setCountryName(country);
		
		// CREATE THE OBJECT OF CHILD CLASS
		Person pr=new Person();
		pr.setPersonName(name);
		pr.setPersonAge(age);
		pr.setPassRef(p);
		
		tx=ses.beginTransaction();
		
		ses.save(pr);
		
		tx.commit();
		
		System.out.println("PERSON DETAILS INSERTED SUCCESSFULLY");
		

	}
 
}
