package com.cap.sprint.hbms.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Entity
@ApiModel(description = "Details about the Booking")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "bookingId")
public class BookingDetails {
	@Id
//	@SequenceGenerator(name="booking_sequence",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "Booking id for a booking")
	private int bookingId;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="user_id")
	@ApiModelProperty(notes = "User for booking Rooms")
	private User user;
	
	//shape = JsonFormat.Shape.STRING,
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(notes = "Booking date", example = "2022-02-20")
	private LocalDate bookedFrom;
	
	//shape = JsonFormat.Shape.STRING,
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(notes = "Booking till date", example = "2022-02-20")
	private LocalDate bookedTo;
	
	@ApiModelProperty(notes = "Number of adults")
	private int noOfAdults;
	
	@ApiModelProperty(notes = "Number of children")
	private int noOfChildren;
	
	@ApiModelProperty(notes = "Amount to be paid")
	private double amount;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "hotel_id")
	@ApiModelProperty(notes = "Hotel with rooms to be booked")
	private Hotel hotel;
	

	
	@OneToMany(cascade = CascadeType.PERSIST)
	@ApiModelProperty(notes = "Rooms to be booked")
	private List<RoomDetails> roomDetailsList;
	
	
	
	
	
	
	
	public BookingDetails() {
		
	}


public BookingDetails(User user, LocalDate bookedFrom, LocalDate bookedTo, int noOfAdults, int noOfChildren,
			double amount, Hotel hotel, List<RoomDetails> roomDetailsList) {
		super();
		this.user = user;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
		this.noOfAdults = noOfAdults;
		this.noOfChildren = noOfChildren;
		this.amount = amount;
		this.hotel = hotel;
		this.roomDetailsList = roomDetailsList;
	}
















	public BookingDetails(int bookingId, User user, LocalDate bookedFrom, LocalDate bookedTo, int noOfAdults,
		int noOfChildren, double amount, Hotel hotel, List<RoomDetails> roomDetailsList) {
	super();
	this.bookingId = bookingId;
	this.user = user;
	this.bookedFrom = bookedFrom;
	this.bookedTo = bookedTo;
	this.noOfAdults = noOfAdults;
	this.noOfChildren = noOfChildren;
	this.amount = amount;
	this.hotel = hotel;
	this.roomDetailsList = roomDetailsList;
}




	public List<RoomDetails> getRoomDetailsList() {
		return roomDetailsList;
	}




	public void setRoomDetailsList(List<RoomDetails> roomDetailsList) {
		this.roomDetailsList = roomDetailsList;
	}

	
	



	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}












	public int getBookingId() {
		return bookingId;
	}

	

	public User getUser() {
		return user;
	}






	public void setUser(User user) {
		this.user = user;
	}






	public LocalDate getBookedFrom() {
		return bookedFrom;
	}

	public void setBookedFrom(LocalDate bookedFrom) {
		this.bookedFrom = bookedFrom;
	}

	public LocalDate getBookedTo() {
		return bookedTo;
	}

	public void setBookedTo(LocalDate bookedTo) {
		this.bookedTo = bookedTo;
	}

	public int getNoOfAdults() {
		return noOfAdults;
	}

	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}

	public int getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	
	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", user=" + user + ", bookedFrom=" + bookedFrom
				+ ", bookedTo=" + bookedTo + ", noOfAdults=" + noOfAdults + ", noOfChildren=" + noOfChildren
				+ ", amount=" + amount +   "]";
	}

}
