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

import com.cap.sprint.hbms.entities.Payments;
import com.cap.sprint.hbms.entities.RoomDetails;
import com.cap.sprint.hbms.repos.IPaymentsRepository;
import com.cap.sprint.hbms.services.PaymentsServicesImpl;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping(path = "/api/v1")
@Api(value = "Payments", tags = { "PaymentsAPI" })
public class PaymentsController 
{
	@Autowired
	PaymentsServicesImpl paymentsServicesImpl;
	
	@Autowired
	IPaymentsRepository p;
	/**
	 * This method is for adding Payment Details
	 * 
	 * @param RoomDetails
	 * @return RoomDetails
	 * @throws NotFoundException
	 * @throws ValidationException
	 */

	@PostMapping("/payment")
//	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value = "Add payment", notes = "Provide Payment Details ", response = Payments.class)
	public ResponseEntity<Payments> addPayments(@ApiParam(value = "Payment for Booking")@RequestBody Payments p)
	{
		Payments ps = paymentsServicesImpl.addPayment(p);
		return new ResponseEntity<Payments>(ps,HttpStatus.CREATED);
	}
	/**
	 * This method is for fetching payment details by id
	 * 
	 * @return Payments
	 * @throws NotFoundException
	 * 
	 */
	@GetMapping("/payment/{id}")
//	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@ApiOperation(value = "View Payment by id", notes = "Provide payment id of payment to be viewed", response = Payments.class)
	public ResponseEntity<Payments> findPayment(@ApiParam(value = "ID value to view payment")@PathVariable int id)
	{
		Payments ps = p.findById(id).get();
		return new ResponseEntity<>(ps,HttpStatus.OK);
				
	}
}
