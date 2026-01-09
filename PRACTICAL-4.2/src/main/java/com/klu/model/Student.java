package com.klu.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
	private int studentId;
	private String name;
	private String course;
	private String academicYear;
	
	public Student(@Value("101") int studentId, @Value("Srithan") String name, @Value("FSAD") String course, @Value("2025-2026") String academicYear) {
		this.studentId = studentId;
		this.name = name;
		this.course = course;
		this.academicYear = academicYear;
	}
	
	public void display() {
		System.out.println("Student ID    : " + this.studentId);
		System.out.println("Student Name  :	" + this.name);
		System.out.println("Course Name   :	" + this.course);
		System.out.println("Academic Year :	" + this.academicYear);
	}
}