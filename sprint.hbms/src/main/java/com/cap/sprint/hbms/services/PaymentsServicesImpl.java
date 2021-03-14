package com.cap.sprint.hbms.services;



import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cap.sprint.hbms.entities.BookingDetails;
import com.cap.sprint.hbms.entities.Hotel;
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
		
		if(!bookingDetails.isPresent())
					throw new NotFoundException("Booking details are not present to add payment");
			
			else 
			{
				Payments foundPayment = paymentRepository.findByBookingDetails(bookingDetails.get());
				
					if(foundPayment != null)
					{
						throw new AlreadyExistsException("payment already exists");
					}
			
			payment.setBookingDetails(bookingDetails.get());
				
				for(RoomDetails roomDetails : bookingDetails.get().getRoomDetailsList())
				{
					roomDetailsServicesImpl.bookRoom(roomDetails);
				}
				paymentRepository.save(payment);
				return payment;

			}

	}
	
	public Optional<Payments> viewPayments(int paymentId)
	{
		Optional<Payments> payments = paymentRepository.findById(paymentId);
		
		if(payments.isPresent())
		{
			return payments;
		}
			
		else
		{
				throw new NotFoundException("Payments not found");
		}
			
	}
	
	

	


}