package test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Customer;
import domain.Order;

// Accept the customer id and delete the customer details along with Orders 
public class DeleteCustomerDetails_7
{

	public static void main(String[] args)
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER THE CUSTOMER ID");
		int id=sc1.nextInt();
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Order.class);
		cfg=cfg.addAnnotatedClass(Customer.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		// load the customer details
		
		Customer c1=ses.load(Customer.class, id);
		
		tx=ses.beginTransaction();
		
		ses.delete(c1);
		
		tx.commit();
		
		System.out.println("Customer details are deleted");
		
		

	}

}
 