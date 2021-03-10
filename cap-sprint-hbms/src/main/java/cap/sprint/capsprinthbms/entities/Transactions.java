package cap.sprint.capsprinthbms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "transactionId")
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer transactionId;
	
	double amount;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	Payments payments;
	
	
	

	public Transactions(double amount) {
		super();
		this.amount = amount;
	}
	
	
	
	
	public Transactions()
	{
		
	}

	
	

	public Transactions( double amount, Payments payments) {
		super();
		
		this.amount = amount;
		this.payments = payments;
	}




	public Payments getPayments() {
		return payments;
	}




	public void setPayments(Payments payments) {
		this.payments = payments;
	}




	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}




	public Integer getTransactionId() {
		return transactionId;
	}


	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", amount=" + amount + "]";
	}

}