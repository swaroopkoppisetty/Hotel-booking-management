package cap.sprint.capsprinthbms.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import cap.sprint.capsprinthbms.entities.BookingDetails;

public interface IBookingDetailsRepository extends JpaRepository<BookingDetails, Integer> {
	
	public BookingDetails findByUserId(int id);

}
