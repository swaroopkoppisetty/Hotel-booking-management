package cap.sprint.capsprinthbms.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "paymentId")
public class Payments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int paymentId;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name ="booking_id")
	BookingDetails bookingDetails;
	
	//@OneToOne(mappedBy = "payments", cascade = CascadeType.PERSIST)
	//@JoinColumn(name="transaction_id",insertable = false)
	//Transactions transactions;
	
	
	
	

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



//	public Transactions getTransaction() {
//		return transactions;
//	}
//
//
//
//	public void setTransaction(Transactions transactions) {
//		this.transactions = transactions;
//	}




	
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