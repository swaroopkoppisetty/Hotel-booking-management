package com.cap.sprint.hbms.services_interfaces;

import java.util.List;
import java.util.Optional;

import com.cap.sprint.hbms.entities.BookingDetails;

public interface IBookingDetailsService {
	
	public void addBookingDetails(BookingDetails bd);
	public BookingDetails updateBookingDetails(BookingDetails bd3);
	public void removeBookingDetails(int id);
	public Optional<BookingDetails> viewBookingDetails(int bookingId);
	public List<BookingDetails>viewBookingDetailsList();
}
