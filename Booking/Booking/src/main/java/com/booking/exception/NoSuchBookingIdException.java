package com.booking.exception;

public class NoSuchBookingIdException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	
	public NoSuchBookingIdException(String msg) {
		super(msg);
	}
	

}
