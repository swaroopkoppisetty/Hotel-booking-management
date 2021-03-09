package cap.sprint.capsprinthbms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cap.sprint.capsprinthbms.entities.Hotel;
import cap.sprint.capsprinthbms.repos.IHotelRepository;
import cap.sprint.capsprinthbms.services.HotelServicesImpl;

class TestHotel {

	@Autowired
	HotelServicesImpl hotelService;
    @Autowired
    IHotelRepository hotelRepository;

	@Test
	public void testaddHotel() {
		
		Hotel hotel = new Hotel("Bangalore", "HotelJaz", "yelahanka", "5 star", 1000.00, "jaz@email.com", "111", "222", "jaz.com");
		System.out.println(hotel);
		hotelService.addHotel(hotel);
		
		
	}
	@Test
	public void testremoveHotel() {
		
		hotelService.removeHotel(1);
		
	}
	
	@Test
	public void testupdateHotel() {
		
		Hotel hotel = new Hotel("Bangalore", "HotelJaz", "yelahanka", "5 star", 1000.00, "jaz@email.com", "111", "222", "jaz.com");
		
		hotelService.updateHotel(hotel);
		
	}
	@Test
	public void testviewHotel() {

		hotelService.viewHotel(4);
		
	}
	
	@Test
	public void testviewAllHotel() {
		hotelService.viewHotelList();
		
	}

}
