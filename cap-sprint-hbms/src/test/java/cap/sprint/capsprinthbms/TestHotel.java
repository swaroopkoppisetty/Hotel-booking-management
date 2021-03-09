package cap.sprint.capsprinthbms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cap.sprint.capsprinthbms.entities.Hotel;
import cap.sprint.capsprinthbms.repos.IHotelRepository;
import cap.sprint.capsprinthbms.services.HotelServicesImpl;

@SpringBootTest
class TestHotel {
	@Autowired
	HotelServicesImpl hotelServices;
    @Autowired
    IHotelRepository hotelRepository;

	//@Test
	public void testaddHotel() {
		
		Hotel hotel = new Hotel("Bangalore", "HotelJaz", "yelahanka", "5 star", 1000.00, "jaz@email.com", "111", "222", "jaz.com");
		System.out.println(hotel);
		hotelServices.addHotel(hotel);
		
		
	}
//	@Test
	public void testremoveHotel() {
		hotelServices.removeHotelById(4);
		
	}
	
//	@Test
	public void testupdateHotel() {
		
		Hotel hotel = new Hotel(1, "Bangalore", "Royal hotel", "Jubilee hills", "Luxury hotel", 2000.00, "royal@email.com", "123", "321", "royal.com");
		
		hotelServices.updateHotel(hotel);
		
	}
//	@Test
	public void testviewHotel() {

		hotelServices.viewHotel(4);
		
	}
	
//	@Test
	public void testviewAllHotel() {
		hotelServices.viewHotelList();
		
	}

}
