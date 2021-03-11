package cap.sprint.capsprinthbms.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cap.sprint.capsprinthbms.entities.Hotel;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Integer> {
	public Hotel findByHotelName(String hotelName);

	public Hotel findByHotelId(int hotelId);

}