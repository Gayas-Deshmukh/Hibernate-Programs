package test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import domain.Student;

public class HcqlDemo3_7 
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
		
		// Write the criteria to fetch student details whose percentage equal to 70.58
		
		Criteria crt1=ses.createCriteria(Student.class);
		
		crt1.add(Restrictions.eq("studentPercentage", 70.58));
		
		List<Student> studentlist1=crt1.list();

		for(Student s:studentlist1)
		{
			System.out.println(s);
		}
		
		System.out.println("------------------------------------------------------------");
		
		// Write the criteria to display those student name whose stream is ELECTRICAL
		Criteria crt2=ses.createCriteria(Student.class);
		
		crt2.add(Restrictions.like("studentStream","ELECTRICAL"));
		crt2.setProjection(Projections.property("studentName"));
		
		List<String> studentlist2=crt2.list();

		for(String s:studentlist2)
		{
			System.out.println(s);
		}
		
		System.out.println("------------------------------------------------------------");
		
		//Write the criteria to display top 3 students details in asending order of their percentage
		
		Criteria crt3=ses.createCriteria(Student.class);
		
		crt3.setMaxResults(3);
		crt3.addOrder(Order.asc("studentPercentage"));
		
		List<Student> studentlist3=crt3.list();

		for(Student s:studentlist3)
		{
			System.out.println(s);
		}
		
		System.out.println("------------------------------------------------------------");
		
		//Write a criteria to display  those student details whose stream in 'MECHANICAL' ,'ELECTRICAL','CIVIL'

		Criteria crt4=ses.createCriteria(Student.class);
		
		List<String> stream=new ArrayList();
		stream.add("ELECTRICAL");
		stream.add("MECHANICAL");
		stream.add("CIVIL");
		
		crt4.add(Restrictions.in("studentStream",stream ));
		
		List<Student> studentlist4=crt4.list();

		for(Student s:studentlist4)
		{
			System.out.println(s);
		}

		System.out.println("------------------------------------------------------------");

		// write the criteria to dispaly student details whose id is 5
		Criteria crt5=ses.createCriteria(Student.class);
	
		crt5.add(Restrictions.idEq(5));
		
		List<Student> studentlist5=crt5.list();

		for(Student s:studentlist5)
		{
			System.out.println(s);
		}
		
	}

}

