package cap.sprint.capsprinthbms.entities;

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

@Entity
public class BookingDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int bookingId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	User user;
	
	LocalDate bookedFrom;
	LocalDate bookedTo;
	int noOfAdults;
	int noOfChildren;
	double amount;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hotel_id")
	Hotel hotel;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "room_id")
//	RoomDetails roomDetails;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<RoomDetails> roomDetailsList;
	
	
	
	
	
	
	
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
