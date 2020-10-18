package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import domain.Student;

public class HcqlDemo2_6 
{

	private static final Criterion Restrications = null;

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

		//Write the criteria to fetch first top 3 records from database table

		Criteria crt1= ses.createCriteria(Student.class);

		crt1.setMaxResults(3);

		List<Student> studentlist1=crt1.list();

		for(Student s:studentlist1)
		{
			System.out.println(s);
		}

		System.out.println("-------------------------------------------------------------------");

		//Write the criteria to display records excluding first 3 records from database table

		Criteria crt2=ses.createCriteria(Student.class);

		crt2.setFirstResult(3);

		List<Student> studentlist2=crt2.list();

		for(Student s:studentlist2)
		{
			System.out.println(s);
		} 

		System.out.println("-------------------------------------------------------------------");

		/*Write the criteria to display all details of student  having percentage greater than 
		 * 65*/

		Criteria crt3=ses.createCriteria(Student.class);

		crt3.add(Restrictions.gt("studentPercentage", 65.00));

		List<Student> studentlist3=crt3.list();

		for(Student s:studentlist3)
		{
			System.out.println(s);
		} 

		System.out.println("-------------------------------------------------------------------");

		/*Write the criteria  to dispaly all the details of student 
		having percentage between 60.00 and 80.00 */

		Criteria crt4=ses.createCriteria(Student.class);

		crt4.add(Restrictions.between("studentPercentage", 60.00, 80.00));

		List<Student> studentlist4=crt4.list();

		for(Student s:studentlist4)
		{
			System.out.println(s);
		} 

		System.out.println("-------------------------------------------------------------------");

		//Write the criteria to display all details of students from ELECTRICAL stream

		Criteria crt5=ses.createCriteria(Student.class);

		crt5.add(Restrictions.like("studentStream", "ELECTRICAL"));
		// crt5.setProjection(Projections.property("studentName"));  if you want student name only which are from ELECTRICAL background 

		List<Student> studentlist5=crt5.list();

		for(Student s:studentlist5)
		{
			System.out.println(s);
		} 

		System.out.println("-------------------------------------------------------------------");

		/* write the criteria to dispaly all details of students whose name end with H
		 * and Display only Electrical stream students
		 */
		Criteria crt6=ses.createCriteria(Student.class);
		
		crt6.add(Restrictions.like("studentName","%L"));
		crt6.add(Restrictions.like("studentStream", "ELECTRICAL"));
		
		List<Student> studentlist6=crt6.list();

		for(Student s:studentlist6)
		{
			System.out.println(s);
		} 
		
		System.out.println("-------------------------------------------------------------------");
		
		/*Write the criteria to display all the student details in descending order 
		 * according to their percentage*/
		 
		Criteria crt7=ses.createCriteria(Student.class);
		
		crt7.addOrder(Order.desc("studentPercentage"));
		
		List<Student> studentlist7=crt7.list();

		for(Student s:studentlist7)
		{
			System.out.println(s);
		} 
	}

}
