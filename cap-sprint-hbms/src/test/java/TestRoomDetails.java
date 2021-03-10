

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cap.sprint.capsprinthbms.entities.BookingDetails;
import cap.sprint.capsprinthbms.entities.Hotel;
import cap.sprint.capsprinthbms.entities.RoomDetails;
import cap.sprint.capsprinthbms.services.BookingDetailsServicesImpl;
import cap.sprint.capsprinthbms.services.RoomDetailsServicesImpl;


@SpringBootTest
class TestRoomDetails {

	@Autowired
	BookingDetailsServicesImpl bookingDetailsServicesImpl;
	
	@Autowired
	RoomDetailsServicesImpl roomDetailsServicesImpl;

	@Test
	public void testaddRoomDetails() {
		
		Hotel hotel = new Hotel("Bangalore", "Taj", "yelahanka", "5 star", 1000.00, "jaz@email.com", "111", "222", "jaz.com");
		System.out.println(hotel);
		RoomDetails roomdetails = new RoomDetails("47", "suite", 2000.00, true, hotel);
		System.out.println(roomdetails);
		roomDetailsServicesImpl.addRoomDetails(roomdetails);
	
		
	}
	
	//@Test
	public void testfindRoomDetails() {
		RoomDetails rd = roomDetailsServicesImpl.findRoomDetails(1);
		System.out.println(rd);
	}
	
//	@Test
	public void testfindAllRoomDetails() {
		List<RoomDetails> allRoomDetails = roomDetailsServicesImpl.findAllRoomDetails();
		System.out.println(allRoomDetails);
	}

	
//	@Test
	public void testUpdateRoomDetails() {

		Hotel hotel = new Hotel(2,"Bangalore", "Taj", "yelahanka", "5 star", 1000.00, "jaz@email.com", "111", "222", "jaz.com");
		RoomDetails roomDetails = new RoomDetails(1,"87", "Non-suite", 2000.00, false, hotel);
//		roomDetails.setRoomId(1);
//		roomDetails.setRate_per_day(6000.00);
		
		
		RoomDetails rooms = roomDetailsServicesImpl.updateRoomDetails(roomDetails);
		System.out.println(rooms);

	}
	
	//@Test
	public void testdeleteRoomDetails() {
		
		roomDetailsServicesImpl.deleteRoomDetails(1);
	}
	
	

}
