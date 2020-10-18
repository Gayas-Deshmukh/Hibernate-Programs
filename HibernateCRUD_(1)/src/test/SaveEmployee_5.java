package test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Employee_2;

public class SaveEmployee_5
{

	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("Enter Employee Id ");
		int id=sc1.nextInt();
		
		System.out.println("Enter Employee Name ");
		String name=sc1.next();
		
		System.out.println("Enter Employee Salary ");
		double salary=sc1.nextDouble();
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Employee_2 e1=new Employee_2(id, name,salary);
		
		tx=ses.beginTransaction();
		
		ses.save(e1);
		
		tx.commit();
		
		System.out.println("Record insered Successfully");

	}

}
