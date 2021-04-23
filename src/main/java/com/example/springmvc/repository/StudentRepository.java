package com.example.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springmvc.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
