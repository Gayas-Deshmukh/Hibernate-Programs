package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Customer;
import domain.Order;

public class SaveCustomerDetails_1 
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
		c1.setCustomerName("Amol");
		c1.setCustomerContact(917455552);

		//CREATE OBJECT OF ORDER

		Order o1=new Order();
		o1.setOrderNumber("SD515512D");

		Order o2=new Order();
		o2.setOrderNumber("TX555DC425");

		//ADD ORDERS FOR SPECIFIC CUSTOMER

		c1.addOrder(o1);
		c1.addOrder(o2);

		tx=ses.beginTransaction();
		ses.save(c1);
		ses.save(o1);  //Optional to save i.e not mandetory
		ses.save(o2);  //Optional to save i.e not mandetory

		tx.commit();

		System.out.println("CUSTOMER DETAILS INSERTED");
	}

}
