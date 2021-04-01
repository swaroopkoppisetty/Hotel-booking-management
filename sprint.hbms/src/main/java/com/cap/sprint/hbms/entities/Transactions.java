package com.cap.sprint.hbms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Transaction Details Of payment")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "transactionId")
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "Transaction Id for Payment reference")
	private Integer transactionId;
	@ApiModelProperty(notes = "Amount paid by User")
	private double amount;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="payment_id")
	@ApiModelProperty(notes = "Details of Payment made by User")
	private Payments payments;
	
	

//Constructorss

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