package cap.sprint.capsprinthbms.services_interfaces;

import java.util.List;
import java.util.Optional;

import cap.sprint.capsprinthbms.entities.Hotel;

public interface IHotelService {
	
	public void addHotel(Hotel h);
	public Hotel updateHotel(Hotel hotel);
	public void removeHotelById(int id);
	public List<Hotel> viewHotelList();
	public Optional<Hotel> viewHotel(int hotelId);

}
