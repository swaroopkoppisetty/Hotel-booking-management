package cap.sprint.capsprinthbms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer transactionId;
	
	double amount;

	public Transactions(double amount) {
		super();
		this.amount = amount;
	}
	
	public Transactions()
	{
		
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