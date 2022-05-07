package com.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.model.Booking;
import com.booking.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired 
	BookingRepository bookingRepository;
	
	public Booking getBookingByBookingId(int bookingId) {
		return bookingRepository.findByBookingId(bookingId);
	}
	
	public String deleteByBookingId(int bookingId) {
		bookingRepository.deleteById(bookingId);
		return "Ticket with booking ID: "+bookingId+"has been canceled!";
	}
	

}
