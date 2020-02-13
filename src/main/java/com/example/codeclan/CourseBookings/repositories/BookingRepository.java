package com.example.codeclan.CourseBookings.repositories;

import com.example.codeclan.CourseBookings.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
