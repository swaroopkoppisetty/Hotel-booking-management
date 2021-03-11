package cap.sprint.capsprinthbms.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cap.sprint.capsprinthbms.entities.BookingDetails;

@Repository
public interface IBookingDetailsRepository extends JpaRepository<BookingDetails, Integer> {
	
	//public BookingDetails findByUserId(int id);

	public BookingDetails findByBookingId(int bookingId);

}
