package com.cap.sprint.hbms.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.sprint.hbms.entities.BookingDetails;
import com.cap.sprint.hbms.entities.Payments;
import com.cap.sprint.hbms.entities.Transactions;
import com.cap.sprint.hbms.exceptions.AlreadyExistsException;
import com.cap.sprint.hbms.exceptions.NotFoundException;
import com.cap.sprint.hbms.repos.ITransactionsRepository;
import com.cap.sprint.hbms.services_interfaces.ITransactionsService;

@Service
public class TransactionsServicesImpl implements ITransactionsService
{
	@Autowired
	ITransactionsRepository transactionRepository;
	
	@Autowired
	PaymentsServicesImpl  PaymentsServicesImpl;
	
	@Autowired
	BookingDetailsServicesImpl bookingDetailsServicesImpl;
	
	
	@Transactional
	public Transactions addTransaction(Transactions transactions)
	{
		Optional<Payments> payments = PaymentsServicesImpl.viewPayments(transactions.getPayments().getPaymentId());
	
		
		
		//if payment is not found throw an exception
		if(!payments.isPresent())
					throw new NotFoundException("payment is not present to add transaction");
		else
		{
	//if Transaction is already present throw exception
			
			Transactions foundTransaction = transactionRepository.findByPayments(payments.get()); 
			
			if(foundTransaction != null)
			{
				throw new AlreadyExistsException("Transaction already exists"); 
			}
	//add transaction
			transactions.setPayments(payments.get());
			
			
			return transactionRepository.save(transactions);
		}
		
	}
	
	public Optional<Transactions> viewTransactions(int transactionId)
	{
		Optional<Transactions> transactions = transactionRepository.findById(transactionId);
		
		// if transaction is present return it or else throw exception 
		
		if(transactions.isPresent())
		{
			return transactions;
		}
			
		else
		{
				throw new NotFoundException("Transaction not found");
		}
			
			
	}
	
	public List<Transactions> findAllTransactions() {
		List<Transactions> rd = transactionRepository.findAll();
		if(rd.isEmpty())
			throw new NotFoundException("No transactions are present");
			
		 return rd;      
		
	}
	

	
}