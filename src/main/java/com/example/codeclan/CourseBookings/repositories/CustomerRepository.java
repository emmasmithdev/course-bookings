package com.example.codeclan.CourseBookings.repositories;

import com.example.codeclan.CourseBookings.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
