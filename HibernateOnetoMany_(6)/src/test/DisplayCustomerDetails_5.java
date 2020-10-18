package test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Customer;
import domain.Order;

// display all customer details along with their placed orders
public class DisplayCustomerDetails_5 
{
	public static void main(String[] args) 
	{
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Order.class);
		cfg=cfg.addAnnotatedClass(Customer.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//create the criteria for customer class
		
		Criteria crt=ses.createCriteria(Customer.class);
		
		List<Customer> customerlist=crt.list();
		
		for(Customer c1:customerlist)
		{
			System.out.println("Customer Name :"+c1.getCustomerName());
			System.out.println("Customer Contact Number :"+c1.getCustomerContact());
			
			List<Order> orderlist=c1.getOrderlist();
			
			System.out.println("Order Placed are : ");
			for(Order o:orderlist)
			{
				System.out.println(o.getOrderNumber());
			}
			
			System.out.println("-----------------------------------------------");
		}
		
		
	}
	
}
