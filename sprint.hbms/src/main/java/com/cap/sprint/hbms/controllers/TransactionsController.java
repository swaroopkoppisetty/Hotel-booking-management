package com.cap.sprint.hbms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.sprint.hbms.entities.RoomDetails;
import com.cap.sprint.hbms.entities.Transactions;
import com.cap.sprint.hbms.repos.ITransactionsRepository;
import com.cap.sprint.hbms.services.TransactionsServicesImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(path = "/api/v1")
@Api(value = "Transactions", tags = { "TransactionsAPI" })
public class TransactionsController 
{
	@Autowired
	TransactionsServicesImpl  transactionsServicesImpl;
	
	/**
	 * This method is for adding a Transactions
	 * 
	 * @param Transactions
	 * @return Transactions
	 */

	@PostMapping("/transaction")

	@ApiOperation(value = "Transaction Details of Payment", notes = "Transaction Details ", response = Transactions.class)
	public ResponseEntity<Transactions> addTransaction(@ApiParam(value = "Add Transaction details of Payment done", required = true)@RequestBody Transactions transactions)
	{
		Transactions t = transactionsServicesImpl.addTransaction(transactions);
		return new ResponseEntity<Transactions>(t, HttpStatus.CREATED);
	}

	/**
	 * This method is for getting a Transaction by Id
	 * 
	 * @param Transactions
	 * @return Transactions
	 */
	 
@GetMapping("/transaction/{id}")
@ApiOperation(value = "Transaction Details of Payment", notes = "Transaction Details ", response = Transactions.class)

public ResponseEntity<Transactions> findTransaction(@ApiParam(value = "get Transaction details of Payment done", required = true)@PathVariable int id)
{
	 Transactions transaction = transactionsServicesImpl.viewTransactions(id).get();
	 return new ResponseEntity<>(transaction, HttpStatus.OK);
}
}
