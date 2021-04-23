package com.example.springmvc.service;

import java.util.List;

import com.example.springmvc.entity.Student;
import com.example.springmvc.exception.ResourceNotFoundException;

public interface StudentService {
	
	public List<Student> getStudents();
	
	public void saveStudent(Student theStudent);
	
	public Student getStudent(int theId) throws ResourceNotFoundException;
	
	public void deleteStudent(int theId) throws ResourceNotFoundException;

}
