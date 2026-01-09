package com.klu.model;

public class Student {
	private String studentId;
	private String name;
	private String course;
	private String academicYear;
	
	public Student(String studentId, String name) {
		this.studentId = studentId;
		this.name = name;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
	
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}
	
	public void display() {
		System.out.println("Student ID: " + this.studentId);
		System.out.println("Student Name: " + this.name);
		System.out.println("Course Name: " + this.course);
		System.out.println("Academic Year: " + this.academicYear);
	}
}