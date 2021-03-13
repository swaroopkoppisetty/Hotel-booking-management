package com.cap.sprint.hbms.services;



import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.sprint.hbms.entities.BookingDetails;

import com.cap.sprint.hbms.entities.Payments;
import com.cap.sprint.hbms.exceptions.NotFoundException;
import com.cap.sprint.hbms.repos.IPaymentsRepository;
import com.cap.sprint.hbms.services_interfaces.IPaymentsService;

@Service
public class PaymentsServicesImpl implements IPaymentsService
{
	@Autowired
	IPaymentsRepository paymentRepository;
	
	
	
	@Autowired
	BookingDetailsServicesImpl bookingDetailsServicesImpl;
	
	@Transactional
	public Payments addPayment(Payments payment)
	{
		Optional <BookingDetails> bookingDetails= bookingDetailsServicesImpl.viewBookingDetails(payment.getBookingDetails().getBookingId());
		
		if(!bookingDetails.isPresent())
					throw new NotFoundException("Booking details are not present to add payment");
			else 
			{
				payment.setBookingDetails(bookingDetails.get());
				paymentRepository.save(payment);
					return payment;

			}

	}
	
	public Optional<Payments> viewPayments(int paymentId)
	{
			return paymentRepository.findById(paymentId);
			
			
	}
	


}