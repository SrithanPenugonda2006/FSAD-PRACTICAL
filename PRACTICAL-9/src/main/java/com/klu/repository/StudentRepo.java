package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.model.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{

}