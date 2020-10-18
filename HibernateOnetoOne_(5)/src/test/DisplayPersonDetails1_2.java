package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Passport;
import domain.Person;

public class DisplayPersonDetails1_2 
{

	public static void main(String[] args)
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Passport.class);
		cfg=cfg.addAnnotatedClass(Person.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Person pr=ses.load(Person.class, 1);
     
        System.out.println(pr.getPersonName());
        System.out.println(pr.getPersonAge());
        System.out.println(pr.getPassRef().getPassportNumber());
        System.out.println(pr.getPassRef().getCountryName());

	}

}
