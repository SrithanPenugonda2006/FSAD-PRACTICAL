package com.klu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Student;
import com.klu.repository.StudentRepo;
import com.klu.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo repo;
	
	@Override
	public Student addStudent(Student s) {
		return repo.save(s);
	}

	@Override
	public Student getStudentById(int id){
		return repo.findById(id).orElse(null);
	}

}