package com.tap;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Program1 {

	public static void main(String[] args) {
		
		//Interfaces:
		//starting the process of configuring Hibernate for your application.
		Configuration cfg = new Configuration();
		cfg.configure();
		//You use the addAnnotatedClass() method to tell Hibernate about the entity classes in your application. 
		cfg.addAnnotatedClass(Employee.class);
		//It's a heavyweight object responsible for creating and managing database connections.
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		//Transaction to reflect in databse
		Transaction transaction = session.beginTransaction();
		
//		Employee e = new Employee(11,"Swathi","swathi@gmail.com","IT",80000);
//		
//		session.save(e);
//		System.out.println(e);
		
		
		/*CRUD OPERATIONS:
		 * 
		 * CREATE: session.save(entity);
		 * 		   session.persist(entity); //NOSQL (ogm) databases
		 * 
		 * READ: 
		 * 		GET: EntityClass entity = session.get(EntityClass.class, id);
		 * 		LOAD: EntityClass entity = session.load(EntityClass.class, id); //Return proxy data only load actual data when needed
		 * 		Query query = session.createQuery("FROM EntityClass WHERE condition = :condition");
		 * 					  query.setParameter("condition", value);
		 * 					  List<EntityClass> resultList = query.list();
		 * 
		 * UPDATE:
		 * 		UPDATE: session.update(entity);
		 * 		MERGE:  session.merge(entity);
		 * 
		 * DELETE:
		 * 		DELETE: session.delete(entity);
		 * 		HQL DELETE:
		 * 			Query query = session.createQuery("DELETE FROM EntityClass WHERE condition = :condition");
		 * 			query.setParameter("condition", value);
		 * 			int rowCount = query.executeUpdate();
		 * 
		 */
		
		
		
		//HQL Query to get all employee details
		Query query = session.createQuery("from Employee");
		List employeeList = query.getResultList();		
		
		for(Object e1:employeeList) {
			System.out.println(e1);
		}
		
		transaction.commit();
		
		
		
		
		

	}

}
