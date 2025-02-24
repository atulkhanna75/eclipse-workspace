package com.main;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.Employee;

public class DemoTest {

	public static void main(String[] args) {
	// Hibernate API 
	// This class load the hibernate.cfg.xml file 
	Configuration con = new Configuration();
	con.configure("hibernate.cfg.xml");			// Load the xml file 
	
	System.out.println("file load successfully");
	
	SessionFactory sf = con.buildSessionFactory();		// like Connection in JDBC. 
	
	Session session = sf.openSession(); 		// like Statement or PreparedStatement 
	
	Transaction tran = session.getTransaction();		// get transaction object. 
	
	// Insert Query or Save Employee Record 
//	Employee emp1 = new Employee();
//	emp1.setId(105);
//	emp1.setName("Dinesh");
//	emp1.setSalary(45000);
//	
//		tran.begin();
//			session.save(emp1);					// like insert Query 
//		tran.commit();
//		System.out.println("Record inserted successfully...");
	
//	// Delete Query 
//	Employee emp = session.find(Employee.class, 100); // find method 1st parameter class reference and 2nd value of pk 
//	if(emp==null) {
//		System.out.println("Record not present");
//	}else {
//		tran.begin();
//		session.delete(emp);		// delete from employee where id = 100;
//		tran.commit();
//		System.out.println("Record deleted successfully...");
//	}
	
//	// Update Query 
//		Employee emp = session.find(Employee.class, 102); // find method 1st parameter class reference and 2nd value of pk 
//		if(emp==null) {
//			System.out.println("Record not present");
//		}else {
//			tran.begin();
//				emp.setSalary(20000);
//				session.update(emp);    	// update employee set salary = 20000 where id = 102
//			tran.commit();
//			System.out.println("Record updated successfully...");
//		}
	// find the record based or using id 
	// Update Query 
			// select * from employee where id = 102 
//			Employee emp = session.find(Employee.class, 102); // find method 1st parameter class reference and 2nd value of pk 
//			if(emp==null) {
//				System.out.println("Record not present");
//			}else {
//				System.out.println(emp);   // it call toString method 
//			}
	
	// Retrieve more than one record like select query using HQL 
	
	// In DAO layer 
	//TypedQuery qry = session.createQuery("select emp from Employee emp");
	//TypedQuery qry = session.createQuery("from Employee emp");
	TypedQuery qry = session.createQuery("from Employee");		// from entity class 
	List<Employee> listOfEmp = qry.getResultList();
	
	// view layer 
	System.out.println("Number of records "+listOfEmp.size());
	Iterator<Employee> li = listOfEmp.iterator();
	while(li.hasNext()) {
		Employee emp = li.next();
		System.out.println(emp);
	}
	}

}