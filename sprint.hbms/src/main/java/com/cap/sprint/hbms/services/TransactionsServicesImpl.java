package com.cap.sprint.hbms.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cap.sprint.hbms.entities.Payments;
import com.cap.sprint.hbms.entities.Transactions;
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
	
	
	@Transactional
	public Transactions addTransaction(Transactions transactions)
	{
		Optional<Payments> payments = PaymentsServicesImpl.viewPayments(transactions.getPayments().getPaymentId());
		

		if(!payments.isPresent())
					throw new NotFoundException("payment is not present to add transaction");
		else
		{
		transactions.setPayments(payments.get());
		return transactionRepository.save(transactions);
		}
		
	}
	
	public Optional<Transactions> viewTransactions(int transactionId)
	{
		Optional<Transactions> transactions = transactionRepository.findById(transactionId);
		
		if(transactions.isPresent())
		{
			return transactions;
		}
			
		else
		{
				throw new NotFoundException("Transaction not found");
		}
			
			
	}
	

	
}