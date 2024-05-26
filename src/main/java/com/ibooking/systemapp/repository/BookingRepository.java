package com.ibooking.systemapp.repository;

import com.ibooking.systemapp.model.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
