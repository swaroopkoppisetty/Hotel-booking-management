package cap.sprint.capsprinthbms.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Payments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int paymentId;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="booking_id")
	BookingDetails bookingDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="transaction_id")
	 Transactions transactions;
	
	

	public int getPaymentId() {
		return paymentId;
	}



	public BookingDetails getBookingDetails() {
		return bookingDetails;
	}



	public void setBookingDetails(BookingDetails bookingDetails) {
		this.bookingDetails = bookingDetails;
	}



	public Transactions getTransaction() {
		return transactions;
	}



	public void setTransaction(Transactions transactions) {
		this.transactions = transactions;
	}



	public Payments(BookingDetails bookingDetails, Transactions transactions) {
		super();
		this.bookingDetails = bookingDetails;
		this.transactions = transactions;
	}
	
	public Payments() {
		
	}



	@Override
	public String toString() {
		return "Payments [paymentId=" + paymentId + ", bookingDetails=" + bookingDetails + ", transactions=" + transactions
				+ "]";
	}

}