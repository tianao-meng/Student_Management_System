package com.example.studentmanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.studentmanagement.dao.StudentDAO;
import com.example.studentmanagement.model.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet(name = "StudentServlet", urlPatterns = "/")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private StudentDAO studentDAO;
    
    public void init() {
    	studentDAO = new StudentDAO();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String action = request.getServletPath();
		
		switch (action) {
		
		case "/new": {
			
			showNewForm(request, response);
			
			break;
		}
		
		case "/insert": {
			insertStudent(request, response);
			break;
		}
		
		case "/update": {
			updateStudent(request, response);
			break;
		}
		
		case "/delete": {
			deleteStudent(request, response);
			break;
		}
		
		case "/edit": {
			
			showEditForm(request, response);
			break;
		}
		
		default:
			listStudent(request, response);
		}
	}
	

	// return list of users to view layer
	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Student> students = new ArrayList<>();
		students = studentDAO.selectAllStudents();
		
		request.setAttribute("listStudent", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/student-list.jsp");
		dispatcher.forward(request, response);
	}
	
	//display student-form
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/student-form.jsp");
		dispatcher.forward(request, response);
		
	}
	
	//handle create student request
	
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String emailId = request.getParameter("email_id");
		
		studentDAO.insertStudent(new Student(firstName, lastName, emailId));
		
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Student existingStudent = studentDAO.selectStudent(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/student-form.jsp");
		request.setAttribute("student", existingStudent);
		dispatcher.forward(request, response);
	}
	
	// handle update student request
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String fistName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String emailId = request.getParameter("email_id");
		
		studentDAO.updateStudent(new Student(id, fistName, lastName, emailId));
		response.sendRedirect("list");
		
	}
	
	// handle delete request
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		int id = Integer.parseInt(request.getParameter("id"));
		studentDAO.deleteStudent(id);
		response.sendRedirect("list");
	}
	
	
	


}
