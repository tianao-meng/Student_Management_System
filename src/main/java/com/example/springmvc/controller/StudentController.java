package com.example.springmvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmvc.entity.Student;
import com.example.springmvc.exception.ResourceNotFoundException;
import com.example.springmvc.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/list")
	public String listStudents(Model theModel) {
		List<Student> theStudents = studentService.getStudents();
		theModel.addAttribute("students", theStudents);
		return "list-students";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		
		LOG.debug("inside show student-form handler method");
		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
		return "student-form";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student theStudent) {
		
		studentService.saveStudent(theStudent);
		return "redirect:/student/list";
		
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) throws ResourceNotFoundException {
		
		Student theStudent = studentService.getStudent(theId);
		theModel.addAttribute("student", theStudent);
		return "student-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int theId) throws ResourceNotFoundException {
		studentService.deleteStudent(theId);
		return "redirect:/student/list";
	}
	
	
	

}
