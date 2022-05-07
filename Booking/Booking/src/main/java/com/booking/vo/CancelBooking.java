package com.booking.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CancelBooking {
	
	private int cancelId;
	private int bookingId;
	private String movieName;
	private String bookingDate;
	private int refund;
	
	
	public CancelBooking(int bookingId, String movieName, String bookingDate, int refund) {
		super();
		this.bookingId = bookingId;
		this.movieName = movieName;
		this.bookingDate = bookingDate;
		this.refund = refund;
	}
	
	

}
