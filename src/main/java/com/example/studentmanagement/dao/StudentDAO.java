package com.example.studentmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.utils.JDBCUtils;

public class StudentDAO {
	

	
	private static final String INSERT_STUDENTS_SQL = "INSERT INTO students (email_id, first_name, last_name) VALUES (?, ?, ?);";
	private static final String SELECT_STUDENT_BY_ID = "select email_id, first_name, last_name from students where id =?;";
	private static final String SELECT_ALL_STUDENTS = "select * from students;";
	private static final String DELECT_STUDENTS_SQL = "delete from students where id = ?;";
	private static final String UPDATE_STUDENTS_SQL = "update students set email_id = ?, first_name =?, last_name = ? where id = ?;";
	
	
	
	// insert record in database
	
	public void insertStudent(Student student) {
		
		try(Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENTS_SQL)){
			
			preparedStatement.setString(1, student.getEmailId());
			System.out.println(student.getEmailId());
			preparedStatement.setString(2, student.getFirstName());
			preparedStatement.setString(3, student.getLastName());
			System.out.println(INSERT_STUDENTS_SQL);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			JDBCUtils. printSQLException(e);
		}
	}
	
	// select student from database
	public Student selectStudent(int id) {
		Student student = null;
		try(Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
			
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String emailId = resultSet.getString("email_id");
				student = new Student(id, firstName, lastName, emailId);
			}
			
		} catch(SQLException e) {
			JDBCUtils. printSQLException(e);
		}
		
		return student;
	}
	
	// select all students from database
	public List<Student> selectAllStudents(){
		List<Student> students = new ArrayList<>();
		
		try(Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)){
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String emailId = rs.getString("email_id");
				
				students.add(new Student(id, firstName, lastName, emailId));
			}
			
		} catch(SQLException e) {
			JDBCUtils. printSQLException(e);
		}
		
		return students;
	}
	
	// delete student from database
	public boolean deleteStudent(int id) {
		
		boolean rowDeleted = false;
		try(Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELECT_STUDENTS_SQL)){
			
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
			
		} catch(SQLException e) {
			JDBCUtils. printSQLException(e);
		}
		
		return rowDeleted;
	}
	
	// update student in database
	public boolean updateStudent(Student student) {
		
		boolean rowUpdated = false;
		try(Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENTS_SQL)){
			
			statement.setString(1, student.getEmailId());
			statement.setString(2, student.getFirstName());
			statement.setString(3, student.getLastName());
			statement.setInt(4, student.getId());
			
			rowUpdated = statement.executeUpdate() > 0;
			
		} catch(SQLException e) {
			JDBCUtils. printSQLException(e);
		}
		
		return rowUpdated;
		
	}

}
