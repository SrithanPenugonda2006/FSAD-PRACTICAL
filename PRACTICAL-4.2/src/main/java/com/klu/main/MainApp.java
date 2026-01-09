package com.klu.main;
import com.klu.config.*;
import com.klu.model.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext con = new AnnotationConfigApplicationContext(AppConfig.class);
		Student s = con.getBean(Student.class);
		s.display();
	}
}