package com.cap.sprint.hbms.services;



import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.sprint.hbms.entities.BookingDetails;

import com.cap.sprint.hbms.entities.Payments;
import com.cap.sprint.hbms.entities.RoomDetails;
import com.cap.sprint.hbms.exceptions.AlreadyExistsException;
import com.cap.sprint.hbms.exceptions.NotFoundException;
import com.cap.sprint.hbms.repos.IPaymentsRepository;
import com.cap.sprint.hbms.services_interfaces.IPaymentsService;

@Service
public class PaymentsServicesImpl implements IPaymentsService
{
	@Autowired
	IPaymentsRepository paymentRepository;
	
	@Autowired
	RoomDetailsServicesImpl  roomDetailsServicesImpl;
	
	@Autowired
	BookingDetailsServicesImpl bookingDetailsServicesImpl;
	
	@Transactional
	public Payments addPayment(Payments payment)
	{
		Optional <BookingDetails> bookingDetails= bookingDetailsServicesImpl.viewBookingDetails(payment.getBookingDetails().getBookingId());
		
	//if booking details is not present throw not found exception
		
		if(!bookingDetails.isPresent())
					throw new NotFoundException("Booking details are not present to add payment"); 
			
		else 
			{
				Payments foundPayment = paymentRepository.findByBookingDetails(bookingDetails.get());

	//if payment already done for booking details throw an exception
					
				if(foundPayment != null)
					{
						throw new AlreadyExistsException("payment already exists"); 
					}
			
			payment.setBookingDetails(bookingDetails.get());
			
		//set room availability status to false after payment
			
				for(RoomDetails roomDetails : bookingDetails.get().getRoomDetailsList())
				{
					roomDetailsServicesImpl.bookRoom(roomDetails);
				}
				
		//add payment 
				
				paymentRepository.save(payment);
				return payment;

			}

	}
	
	public Optional<Payments> viewPayments(int paymentId)
	{
		Optional<Payments> payments = paymentRepository.findById(paymentId);
		
		
// if payment is present return payments or else throw exception 
		
		if(payments.isPresent())
		{
			return payments;
		}
			
		else
		{
				throw new NotFoundException("Payments not found");
		}
			
	}
	
	
	public List<Payments> findAllPayments() {
		List<Payments> rd = paymentRepository.findAll();
		if(rd.isEmpty())
			throw new NotFoundException("No payments are present");
			
		 return rd;      
		
	}
	
	

	


}