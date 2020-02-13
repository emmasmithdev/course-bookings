package com.example.codeclan.CourseBookings.repositories;

import com.example.codeclan.CourseBookings.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
