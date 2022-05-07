package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{
	
	Booking findByBookingId(int bookingId);

}
