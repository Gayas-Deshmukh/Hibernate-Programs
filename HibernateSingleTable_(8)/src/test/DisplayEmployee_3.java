package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.ContractEmployee;
import domain.Employee;
import domain.PermanentEmployee;

public class DisplayEmployee_3 
{

	public static void main(String[] args)
	{

		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;

		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(ContractEmployee.class);
		cfg=cfg.addAnnotatedClass(PermanentEmployee.class);

		factory=cfg.buildSessionFactory();

		ses=factory.openSession();
		
		Employee e1=ses.load(Employee.class, 1);
		System.out.println("Name: "+e1.getEmployeeName());
		System.out.println("Age: "+e1.getEmployeeAge());
		
		System.out.println("========================================================");
		
		ContractEmployee c1=ses.load(ContractEmployee.class, 3);
		System.out.println("Name: "+c1.getEmployeeName());
		System.out.println("Age: "+c1.getEmployeeAge());
		System.out.println("working days: "+c1.getWorkingDays());
		
		System.out.println("===========================================================");
		
		PermanentEmployee p1=ses.load(PermanentEmployee.class, 4);
		System.out.println("Name: "+p1.getEmployeeName());
		System.out.println("Age: "+p1.getEmployeeAge());
		System.out.println("designation: "+p1.getDesignation());
	
		
	}

}
