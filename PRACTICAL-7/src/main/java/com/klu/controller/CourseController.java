package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Course;
import com.klu.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService service;

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {

        service.addCourse(course);

        return new ResponseEntity<>("Course Added Successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getCourses() {

        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id) {

        Course course = service.getCourseById(id);

        if (course == null) {
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course course) {

        Course updated = service.updateCourse(id, course);

        if (updated == null) {
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Course Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {

        boolean deleted = service.deleteCourse(id);

        if (!deleted) {
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Course Deleted", HttpStatus.OK);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchCourse(@PathVariable String title) {

        List<Course> courses = service.searchByTitle(title);

        if (courses.isEmpty()) {
            return new ResponseEntity<>("No course found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}