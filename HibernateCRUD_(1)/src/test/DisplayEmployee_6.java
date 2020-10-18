package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Employee_2;

public class DisplayEmployee_6
{

	public static void main(String[] args)
	{
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Employee_2 e1=ses.load(Employee_2.class, 1);
		
		System.out.println("Id\tName\tSalary");
		
		System.out.println(e1.getEmployeeId()+"\t"+e1.getEmployeeName()+"\t"+e1.getEmployeeSalary());
	}

}
