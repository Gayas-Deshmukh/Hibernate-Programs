package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Person;
import domain.Student;
import domain.Trainer;

public class SavePersonDetails_1
{

	public static void main(String[] args)
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Person.class);
		cfg=cfg.addAnnotatedClass(Student.class);
		cfg=cfg.addAnnotatedClass(Trainer.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//create the object of Student
		Student s1=new Student();
		s1.setPersonName("Rohit");
		s1.setPersonEmail("r@gmail.com");
		s1.setStudentPercentage(65.23);
		
		// create the object of Trainer
		Trainer t1=new Trainer();
		t1.setPersonName("Anil");
		t1.setPersonEmail("a@gmail.com");
		t1.setTrainerSalary(25300.0);
		
		tx=ses.beginTransaction();
		
		ses.save(s1);
		ses.save(t1);
		
		tx.commit();
		
		System.out.println("Person Details Stored Successfully");
		 
	}

}
