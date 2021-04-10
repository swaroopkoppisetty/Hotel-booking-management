package com.cap.sprint.hbms.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.sprint.hbms.entities.BookingDetails;

public interface IBookingDetailsRepository extends JpaRepository<BookingDetails, Integer> {
	
	

	public BookingDetails findByBookingId(int bookingId);
	
	

}
