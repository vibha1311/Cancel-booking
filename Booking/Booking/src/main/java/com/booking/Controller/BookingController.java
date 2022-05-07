package com.booking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.booking.exception.NoSuchBookingIdException;
import com.booking.model.Booking;
import com.booking.service.BookingService;
import com.booking.vo.CancelBooking;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired 
	BookingService bookingService;
	
	@Autowired 
	RestTemplate restTemplate;
	
	Booking booking = null;
	
	private static final String CANCEL_URL = "http://CANCEL-MICROSERVICE/cancel/add-Canceled-Ticket";
	
	private static int computeRefund() {
	
		int refund_amt = (20/100) * 200;
		return refund_amt;
	}
	
	@GetMapping("/get-booking-by-id/{bookingId}")
	public ResponseEntity<Booking> getBookingById(@PathVariable("bookingId") int bookingId) {
		
		Booking booking = bookingService.getBookingByBookingId(bookingId);
		if(booking==null) {
			throw new NoSuchBookingIdException("There is no booking with booking ID: "+bookingId);
		}
		return new ResponseEntity<>(booking,HttpStatus.OK);
	}
	
	@DeleteMapping("/cancel-booking-by-id/{bookingId}")
	public ResponseEntity<String> deleteBookingById(@PathVariable("bookingId") int bookingId) {
		booking = bookingService.getBookingByBookingId(bookingId);
		if(booking == null) {
			throw new NoSuchBookingIdException("There is no booking with booking Id: "+bookingId);
		}
		CancelBooking cancelBooking = new CancelBooking(
						booking.getBookingId(),
						booking.getMovieName(),
						booking.getBookingDate(),
						computeRefund());
		
		//CancelBooking c = restTemplate.postForObject(CANCEL_URL,cancelBooking, CancelBooking.class);
		
		
		
		return new ResponseEntity<>(bookingService.deleteByBookingId(bookingId),HttpStatus.OK);
	}
	
	

}
