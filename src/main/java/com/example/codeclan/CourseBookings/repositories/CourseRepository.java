package com.example.codeclan.CourseBookings.repositories;

import com.example.codeclan.CourseBookings.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByStars(int stars);

    List<Course> findByBookingsCustomerId(Long id);
}
