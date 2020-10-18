package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Book;
import domain.Mobile;
import domain.Product;

public class Displayproduct 
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Product.class);
		cfg=cfg.addAnnotatedClass(Book.class);
		cfg=cfg.addAnnotatedClass(Mobile.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Product p1=ses.load(Product.class, 2);
		System.out.println(p1.getProductName());
		System.out.println(p1.getProductPrice());
		
		System.out.println("--------------------------------------------------");
		
		Book b1=ses.load(Book.class, 2);
		System.out.println(b1.getProductName());
		System.out.println(b1.getProductPrice());
		System.out.println(b1.getBookAuthor());
		System.out.println(b1.getBookPublication());
		
		System.out.println("------------------------------------------------------");
		
		Mobile m1=ses.load(Mobile.class, 3);
		System.out.println(m1.getProductName());
		System.out.println(m1.getProductPrice());
		System.out.println(m1.getMobilrBrand());
		System.out.println(m1.getOsType());
	}

}
