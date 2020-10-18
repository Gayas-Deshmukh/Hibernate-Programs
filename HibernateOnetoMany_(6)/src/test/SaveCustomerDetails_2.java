package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Customer;
import domain.Order;

public class SaveCustomerDetails_2
{

	public static void main(String[] args)
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;

		cfg=new Configuration();

		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Customer.class);
		cfg=cfg.addAnnotatedClass(Order.class);

		factory=cfg.buildSessionFactory();

		ses=factory.openSession();

		//CREATE OBJECT OF CUSTOMER
		Customer c1=new Customer();
		c1.setCustomerName("Dinesh");
		c1.setCustomerContact(925559687);
		
		Customer c2=new Customer();
		c2.setCustomerName("Gokul");
		c2.setCustomerContact(86515155);
		
		//CREATE OBJECT OF ORDER
		Order o1=new Order();
		o1.setOrderNumber("CX4564SWDG");
		
		Order o2=new Order();
		o2.setOrderNumber("WQF751455");
		
		Order o3=new Order();
		o3.setOrderNumber("PXSR7855VR");
		
		//ALLOCATE ORDERS FOR THE RESPECTIVE CUSTOMER
		// ASSOCIATE ORDER OBJECT WITH CUSTOMER OBJECT
		
		c1.addOrder(o1);
		c1.addOrder(o2);
		c2.addOrder(o3);
		
		tx=ses.beginTransaction();
		
		ses.save(c1);    // CUSTOMER 1 ===> ORDER 1, ORDER 2
		ses.save(c2);    // CUSTOMER 2 ===> ORDER 3
		
		tx.commit();
		
		System.out.println("CUSTOMER DETAILS INSERTED");

	}

}
