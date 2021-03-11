package cap.sprint.capsprinthbms.services_interfaces;

import java.util.List;
import java.util.Optional;

import cap.sprint.capsprinthbms.entities.BookingDetails;
import cap.sprint.capsprinthbms.entities.RoomDetails;

public interface IBookingDetailsService {
	
	public void addBookingDetails(BookingDetails bd);
	public BookingDetails updateBookingDetails(BookingDetails bd3);
	public void removeBookingDetails(int id);
	public Optional<BookingDetails> viewBookingDetails(int bookingId);
	public List<BookingDetails>viewBookingDetailsList();
	public RoomDetails getFile(int roomId);
}
