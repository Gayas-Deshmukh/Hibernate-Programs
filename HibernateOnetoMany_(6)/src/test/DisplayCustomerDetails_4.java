package test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Customer;
import domain.Order;

// Accept customer id from end user and display all the orders details placed by that customer.
public class DisplayCustomerDetails_4
{

	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER THE CUSTOMER ID");
		int id=sc1.nextInt();
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Order.class);
		cfg=cfg.addAnnotatedClass(Customer.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//load the customer details from database table
		
		Customer cust=ses.load(Customer.class, id);
		
		//display customer name
		
		System.out.println("Customer Name is: "+cust.getCustomerName());
		
		// get the list of orders placed by customer
		
		List<Order> orders=cust.getOrderlist();
		
		// print the orders
		System.out.println("List of orders :");
		
		for(Order o:orders)
		{
			System.out.println(o.getOrderNumber());
		}
		

	}

}
