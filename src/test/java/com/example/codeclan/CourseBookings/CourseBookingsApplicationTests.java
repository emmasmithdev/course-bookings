package com.example.codeclan.CourseBookings;

import com.example.codeclan.CourseBookings.models.Booking;
import com.example.codeclan.CourseBookings.models.Course;
import com.example.codeclan.CourseBookings.models.Customer;
import com.example.codeclan.CourseBookings.repositories.BookingRepository;
import com.example.codeclan.CourseBookings.repositories.CourseRepository;
import com.example.codeclan.CourseBookings.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseBookingsApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllCoursesGivenRating(){
		List<Course> found = courseRepository.findByStars(5);
		assertEquals(1, found.size());
	}

	@Test
	public void getAllCustomersForGivenCourse(){
		List<Customer> found = customerRepository.findByBookingsCourseId(1L);
		assertEquals(2, found.size());
	}

	@Test
	public void getAllCoursesForGivenCustomer(){
		List<Course> found = courseRepository.findByBookingsCustomerId(1L);
		assertEquals(3, found.size());
	}

	@Test
	public void getAllBookingsForGivenDate(){
		List<Booking> found = bookingRepository.findByDate("01/01/20");
		assertEquals(1, found.size());
	}

	@Test
	public void getAllCustomersGivenTownGivenCourse(){
		List<Customer> found = customerRepository.findByTownAndBookingsCourseId("Glasgow", 1L);
		assertEquals(2, found.size());
	}

	@Test
	public void getAllCustomersGivenTownGivenCourseOver30(){
		List<Customer> found = customerRepository.findByTownAndBookingsCourseIdAndAgeGreaterThan("Glasgow", 1l, 30);
		assertEquals(2, found.size());
	}

}
