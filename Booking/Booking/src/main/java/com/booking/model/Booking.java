package com.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ticket_booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="booking_id")
	private int bookingId;
	
	@Column(name="movie_name")
	private String movieName;
	
	@Column(name="booking_date")
	private String bookingDate;
	
	@Column(name="seat_type")
	private String seatType;

}
