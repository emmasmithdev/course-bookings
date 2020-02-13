package com.example.codeclan.CourseBookings.controllers;

import com.example.codeclan.CourseBookings.models.Course;
import com.example.codeclan.CourseBookings.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value="/courses")
    public ResponseEntity<List<Course>> getAllCoursesWithGivenStars(
            @RequestParam(name="stars") int stars){
        List<Course> courses = courseRepository.findByStars(stars);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping(value="/courses/customer/{id}")
    public ResponseEntity<List<Course>> getCoursesForGivenCustomer(
            @PathVariable Long id){
        List<Course> courses = courseRepository.findByBookingsCustomerId(id);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}
