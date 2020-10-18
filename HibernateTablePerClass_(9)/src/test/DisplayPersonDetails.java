package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Person;
import domain.Student;
import domain.Trainer;

public class DisplayPersonDetails 
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Person.class);
		cfg=cfg.addAnnotatedClass(Student.class);
		cfg=cfg.addAnnotatedClass(Trainer.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Person p1=ses.load(Person.class,1);
		System.out.println(p1.getPersonName());
		System.out.println(p1.getPersonEmail());
		
		System.out.println("--------------------------------------------------------");
		
		Student s1=ses.load(Student.class,1);
		System.out.println(s1.getPersonName());
		System.out.println(s1.getPersonEmail());
		System.out.println(s1.getStudentPercentage());
		
		System.out.println("----------------------------------------------------------");
		
		Trainer t1=ses.load(Trainer.class, 2);
		
		System.out.println(t1.getPersonName());
		System.out.println(t1.getPersonEmail());
		System.out.println(t1.getTrainerSalary());
		
		
	}

}
