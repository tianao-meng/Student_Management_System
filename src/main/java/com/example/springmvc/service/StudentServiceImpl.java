package com.example.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.springmvc.entity.Student;
import com.example.springmvc.exception.ResourceNotFoundException;
import com.example.springmvc.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	
	@Transactional
	public void saveStudent(Student theStudent) {
		studentRepository.save(theStudent);

	}
	
	@Transactional
	public Student getStudent(int theId) throws ResourceNotFoundException {
		return studentRepository.findById(theId).orElseThrow(() -> new ResourceNotFoundException(theId));
	}
	
	@Transactional
	public void deleteStudent(int theId) throws ResourceNotFoundException {
		
		studentRepository.deleteById(theId);
	}

}