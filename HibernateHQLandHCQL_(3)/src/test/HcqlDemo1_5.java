package test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import domain.Student;

public class HcqlDemo1_5
{

	public static void main(String[] args)
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;

		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Student.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//display all the object from database table
		Criteria crt1=ses.createCriteria(Student.class);
		
		List <Student> studentlist=crt1.list();
		
		for(Student s:studentlist)
		{
			System.out.println(s);
		}
		
		System.out.println("----------------------------------------------------------");
		
		//display data from specific column
		Criteria crt2=ses.createCriteria(Student.class);
		
		crt2.setProjection(Projections.property("studentName"));
		
		List<String> studentname=crt2.list();
		
		System.out.println("Student Names are: ");
		for(String s:studentname)
		{
			System.out.println(s);
		}
		
		System.out.println("-------------------------------------------------------------");
		
		//display data from 2 or more columns
		Criteria crt3=ses.createCriteria(Student.class);
		
		ProjectionList plist=Projections.projectionList();
		
		plist.add(Projections.property("studentName"));
		plist.add(Projections.property("studentPercentage"));
		
		crt3.setProjection(plist);
		
		List studentlist2=crt3.list();
		
		Iterator itr=studentlist2.iterator();
		
		System.out.println("Name\tPercentage");
		
		while(itr.hasNext())
		{
			Object [] arr=(Object[]) itr.next();
			
			System.out.println(arr[0]+"\t"+arr[1]);
		}
		
	}

}
 