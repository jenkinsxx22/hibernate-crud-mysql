package net.javaguides.hibernate.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import net.javaguides.hibernate.model.Student;
import net.javaguides.hibernate.util.HIbernateUtil;

public class StudentDao implements IStudentDao {

	@Override
	public void SaveStudent(Student student) throws Exception {
		
		Transaction transaction = null;
		
		/*not worked
		//SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//Session s = sf.openSession();
		
		//try {*/
		
		try(Session s = HIbernateUtil.getSessionFactory().openSession()){
			//start the transaction
			transaction=(Transaction) s.beginTransaction();	
			
			//save student object
			s.save(student);
			
			//commit the transaction
			transaction.commit();
			
		} catch (Exception e) {	
			
			if(transaction!=null) {				
				transaction.rollback();
			}
		} 		
	}


	@Override
	public void UpdateStudent(Student student) throws Exception {
		
		Transaction transaction = null;
		try(Session s = HIbernateUtil.getSessionFactory().openSession()) {
		//start the transaction
			transaction=(Transaction) s.beginTransaction();		
			
			//save student object
			s.saveOrUpdate(student);
			
			//commit the transaction
			transaction.commit();
			
		} catch (SecurityException e) {
			
			if(transaction!=null) {				
				transaction.rollback();
			}
		} 
		
	}

	@Override
	public Student getStudentById(long id) throws Exception {
		
		Transaction transaction = null;
		Student student = null;
		try(Session s = HIbernateUtil.getSessionFactory().openSession()){
		//start the transaction
			transaction=(Transaction) s.beginTransaction();		
			
			//get student object
			
			student = s.load(Student.class, id);
			  
			//commit the transaction
			transaction.commit();
			
		} catch (SecurityException e) {
			
			if(transaction!=null) {
				
				transaction.rollback();
			}
		}		
		
		return student;
		
	}


	@Override
	public List<Student> getAllStudent() throws Exception {
		
		Transaction transaction = null;
		List<Student> students = null;
		try(Session s = HIbernateUtil.getSessionFactory().openSession()) {
		//start the transaction
			transaction=(Transaction) s.beginTransaction();		
			
			//get students object
			students = s.createQuery("from student").list();
			  
			//commit the transaction
			transaction.commit();
			
		} catch (SecurityException e) {
			
			if(transaction!=null) {
				
				transaction.rollback();
			}
		} 
		return students;
		
	}


	@Override
	public void DeleteStudent(long id) throws Exception {
		
		Transaction transaction = null;
		Student student = null;
		try(Session s = HIbernateUtil.getSessionFactory().openSession()){
		//start the transaction
			transaction=(Transaction) s.beginTransaction();		
			
			student = s.get(Student.class, id);
			//save student object
			s.delete(student);
			
			//commit the transaction
			transaction.commit();
			
		} catch (SecurityException e) {
			
			if(transaction!=null) {
				
				transaction.rollback();
			}
		} 	
	}

}
