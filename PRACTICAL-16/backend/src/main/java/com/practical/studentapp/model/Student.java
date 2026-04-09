package com.practical.studentapp.model;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Student Entity representing a student in the system")
@Entity
@Table(name = "students")
public class Student {

    @Schema(description = "Unique identifier of the student", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Name of the student", example = "John Doe")
    @Column(nullable = false)
    private String name;

    @Schema(description = "Email address of the student", example = "john.doe@example.com")
    @Column(nullable = false, unique = true)
    private String email;

    @Schema(description = "Course the student is enrolled in", example = "Computer Science")
    @Column(nullable = false)
    private String course;

    // Default constructor
    public Student() {}

    // All-args constructor
    public Student(Long id, String name, String email, String course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    // Getters
    public Long getId()       { return id; }
    public String getName()   { return name; }
    public String getEmail()  { return email; }
    public String getCourse() { return course; }

    // Setters
    public void setId(Long id)          { this.id = id; }
    public void setName(String name)    { this.name = name; }
    public void setEmail(String email)  { this.email = email; }
    public void setCourse(String course){ this.course = course; }
}
