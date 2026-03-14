package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.exception.InvalidInputException;
import com.klu.exception.StudentNotFoundException;
import com.klu.model.Student;
import com.klu.service.StudentService;

@RestController
@RequestMapping("/student1")
public class StudentController {

	@Autowired
	StudentService service;
	
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student s) {
		return service.addStudent(s);
	}

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable int id){

		if(id <= 0){
			throw new InvalidInputException("Invalid student ID");
		}

		Student s=service.getStudentById(id);

		if(s == null){
			throw new StudentNotFoundException("Student with ID "+id+" not found");
		}

		return s;
	}

}