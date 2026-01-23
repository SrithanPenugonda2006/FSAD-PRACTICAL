package com.klu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

	private int id;
	private String name;
	private char gender;
	@Autowired
	private Certification certification;
	
	public Student() {
		this.id = 100;
		this.name = "Srithan";
		this.gender = 'M';
	}
	
	public void display() {
		System.out.println("Below are the student's details:");
		System.out.println();
		System.out.println("Student ID: " + this.id);
		System.out.println("Student Name: " + this.name);
		System.out.println("Gender: " + this.gender);
		System.out.println();
		System.out.println("Certification ID: " + certification.getId());
		System.out.println("Certification Title: " + certification.getName());
		System.out.println("Date of Completion: " + certification.getDateOfCompletion());
		System.out.println();
	}
}
