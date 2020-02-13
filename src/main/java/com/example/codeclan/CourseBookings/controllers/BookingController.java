package com.example.codeclan.CourseBookings.controllers;

import com.example.codeclan.CourseBookings.models.Booking;
import com.example.codeclan.CourseBookings.models.Course;
import com.example.codeclan.CourseBookings.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value="/bookings")
    public ResponseEntity<List<Booking>> getAllBookingsForGivenDate(
            @RequestParam(name="date") String date){
        List<Booking> bookings = bookingRepository.findByDate(date);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

}
