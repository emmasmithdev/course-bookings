package com.example.codeclan.CourseBookings.controllers;

import com.example.codeclan.CourseBookings.models.Customer;
import com.example.codeclan.CourseBookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value="/customers")
    public ResponseEntity<List<Customer>> getCustomersGivenCourse(
            @RequestParam(name="course") Long id){
        List<Customer> customers = customerRepository.findByBookingsCourseId(id);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping(value="/customers/town")
    public ResponseEntity<List<Customer>> getCustomersTownCourse(
            @RequestParam(name="town") String town, @RequestParam(name="course") Long id){
        List<Customer> customers = customerRepository.findByTownIgnoreCaseAndBookingsCourseId(town, id);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping(value="/customers/age")
    public ResponseEntity<List<Customer>> getCustomersTownCourseOverAge(
            @RequestParam(name="town") String town, @RequestParam(name="course") Long id, @RequestParam(name="age") int age){
        List<Customer> customers = customerRepository.findByTownAndBookingsCourseIdAndAgeGreaterThan(town, id, age);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
