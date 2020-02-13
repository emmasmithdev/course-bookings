package com.example.codeclan.CourseBookings.components;

import com.example.codeclan.CourseBookings.models.Booking;
import com.example.codeclan.CourseBookings.models.Course;
import com.example.codeclan.CourseBookings.models.Customer;
import com.example.codeclan.CourseBookings.repositories.BookingRepository;
import com.example.codeclan.CourseBookings.repositories.CourseRepository;
import com.example.codeclan.CourseBookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        bookingRepository.deleteAll();
        courseRepository.deleteAll();
        customerRepository.deleteAll();

        Customer customer1 = new Customer("Andrew", "Glasgow", 38);
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Emma", "Glasgow", 38);
        customerRepository.save(customer2);

        Course course1 = new Course("Java", "Glasgow", 5);
        courseRepository.save(course1);

        Course course2 = new Course("Spring", "Glasgow", 3);
        courseRepository.save(course2);

        Course course3 = new Course("Ruby", "Edinburgh", 4);
        courseRepository.save(course3);

        Booking booking1 = new Booking("01/01/20", customer1, course1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("02/01/20", customer2, course2);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("03/01/20", customer1, course3);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("04/01/20", customer2, course1);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("05/01/20", customer1, course2);
        bookingRepository.save(booking5);

    }
}
