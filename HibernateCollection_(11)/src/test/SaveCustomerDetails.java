package test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Customer;

public class SaveCustomerDetails 
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
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//create the object of customer
		
		Customer c1=new Customer();
		c1.setCustomerName("Akash");
		c1.setCustomerContact(123456);
		Set<String> accountset=c1.getAccountNumbers();
		accountset.add("NDSKD52SD");
		accountset.add("AKDNGF51D");
		accountset.add("NDSKD52SD");
		
		Customer c2=new Customer();
		c2.setCustomerName("Ganesh");
		c2.setCustomerContact(578946);
		Set<String> accountset1=c2.getAccountNumbers();
		accountset1.add("ASFG12G45");
		accountset1.add("WERB451GH");
		accountset1.add("RGT12GHTB");
		accountset1.add("VDCS12GHN");
		
		tx=ses.beginTransaction();
		ses.save(c1);
		ses.save(c2);
		
		tx.commit();
		
		System.out.println("Customer Details and Account Inserted Successfully");

	}

}
