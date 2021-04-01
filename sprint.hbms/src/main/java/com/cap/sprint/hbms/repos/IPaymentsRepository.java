package com.cap.sprint.hbms.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.sprint.hbms.entities.BookingDetails;
import com.cap.sprint.hbms.entities.Payments;

@Repository
public interface IPaymentsRepository extends JpaRepository<Payments, Integer> 
{
	public Payments findByBookingDetails(BookingDetails bookingDetails);

	
}