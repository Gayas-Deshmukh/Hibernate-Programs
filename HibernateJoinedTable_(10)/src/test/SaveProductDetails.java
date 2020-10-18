package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Book;
import domain.Mobile;
import domain.Product;

public class SaveProductDetails
{

	public static void main(String[] args)
	{

		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Product.class);
		cfg=cfg.addAnnotatedClass(Book.class);
		cfg=cfg.addAnnotatedClass(Mobile.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//create object of Book class
		 Book b1=new Book();
		 b1.setProductName("Java");
		 b1.setProductPrice(1500.2);
		 b1.setBookAuthor("James");
		 b1.setBookPublication("Nirali");
		 
		 // create the Object of Mobile Class
		 
		 Mobile m1=new Mobile();
		 m1.setProductName("Smart Phone");
		 m1.setProductPrice(50000.0);
		 m1.setMobilrBrand("Samsung");
		 m1.setOsType("Android");
		 
		 tx=ses.beginTransaction();
		 
		 ses.save(b1);
		 
		 ses.save(m1);
		 
		 tx.commit();
		 
		 System.out.println("Product Details Stored Successfully");
	}

}
