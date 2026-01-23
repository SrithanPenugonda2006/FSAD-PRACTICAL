package com.klu.model;

import org.springframework.stereotype.Component;

@Component
public class Certification {

	private int id;
	private String name;
	private String dateOfCompletion;
	
	public Certification() {
		this.id = 101;
		this.name = "AWS";
		this.dateOfCompletion = "26-02-2026";
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDateOfCompletion() {
		return this.dateOfCompletion;
	}
}
