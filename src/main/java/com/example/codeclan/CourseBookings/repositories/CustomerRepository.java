package com.example.codeclan.CourseBookings.repositories;

import com.example.codeclan.CourseBookings.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseId(Long id);

    List<Customer> findByTownAndBookingsCourseId(String town, Long id);

    List<Customer> findByTownAndBookingsCourseIdAndAgeGreaterThan(String town, Long id, int age);
}
