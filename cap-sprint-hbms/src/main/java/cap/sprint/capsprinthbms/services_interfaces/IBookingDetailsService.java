package cap.sprint.capsprinthbms.services_interfaces;

import java.util.List;

import cap.sprint.capsprinthbms.entities.BookingDetails;

public interface IBookingDetailsService {
	
	public void addBookingDetails(BookingDetails bd);
	public BookingDetails updateBookingDetails(BookingDetails bd3);
	public void removeBookingDetails(int id);
	public BookingDetails viewBookingDetails(int bookingId);
	public List<BookingDetails>viewBookingDetailsList();
}
