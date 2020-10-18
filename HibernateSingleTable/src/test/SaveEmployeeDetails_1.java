package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.ContractEmployee;
import domain.PermanentEmployee;

public class SaveEmployeeDetails_1
{

	public static void main(String[] args)
	{
	    Configuration cfg=null;
	    SessionFactory factory=null;
	    Session ses=null;
	    Transaction tx=null;
	    
	    cfg=new Configuration();
	    cfg=cfg.configure("cfgs/hibernate.cfg.xml");
	    cfg=cfg.addAnnotatedClass(ContractEmployee.class);
	    cfg=cfg.addAnnotatedClass(PermanentEmployee.class);
	    
	    factory=cfg.buildSessionFactory();
	    
	    ses=factory.openSession();
	    
	    //create the object of contract employee
	    ContractEmployee c1=new ContractEmployee();
	    c1.setEmployeeName("Rahul");
	    c1.setEmployeeAge(32);
	    c1.setWorkingDays(256);
	    
	    // create the object of permanent employee
	    
	    PermanentEmployee p1=new PermanentEmployee();
	    p1.setEmployeeName("Nikil");
	    p1.setEmployeeAge(40);
	    p1.setDesignation("Devloper");
	    
	    tx=ses.beginTransaction();
	    
	    ses.save(c1);
	    ses.save(p1);
	    
	    tx.commit();
	    
	    System.out.println("Employee details stored Successfully");
	}

}
