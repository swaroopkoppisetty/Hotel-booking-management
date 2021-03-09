package cap.sprint.capsprinthbms.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cap.sprint.capsprinthbms.entities.Hotel;
public interface IHotelRepository extends JpaRepository<Hotel, Integer> {
	public Hotel findByHotelname(String hotelname);

}