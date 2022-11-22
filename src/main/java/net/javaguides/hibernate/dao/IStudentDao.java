package net.javaguides.hibernate.dao;

import java.util.List;

import net.javaguides.hibernate.model.Student;

public interface IStudentDao {

	void SaveStudent(Student student) throws Exception;

	void UpdateStudent(Student student) throws Exception;

	Student getStudentById(long id) throws Exception;

	List<Student> getAllStudent() throws Exception;

	void DeleteStudent(long id) throws Exception;

}