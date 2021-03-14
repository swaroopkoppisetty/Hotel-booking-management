package com.cap.sprint.hbms.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Details about Payment")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "paymentId")
public class Payments {
	@Id
//	@SequenceGenerator(name="payment_sequence",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "Payment id after a booking")
	private int paymentId;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name ="booking_id")
	@ApiModelProperty(notes = "Booking Details Of User")
	private BookingDetails bookingDetails;
	
	
	
	
	
	

	public int getPaymentId() {
		return paymentId;
	}



	public BookingDetails getBookingDetails() {
		return bookingDetails;
	}



	public void setBookingDetails(BookingDetails bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	


public Payments(int paymentId, BookingDetails bookingDetails) {
		super();
		this.paymentId = paymentId;
		this.bookingDetails = bookingDetails;
	}



	




	
	public Payments() {
		
	}



public Payments(BookingDetails bookingDetails) {
	super();
	this.bookingDetails = bookingDetails;
}
	
	



	@Override
	public String toString() {
		return "Payments [paymentId=" + paymentId + ", bookingDetails=" + bookingDetails + "]";
	}

}