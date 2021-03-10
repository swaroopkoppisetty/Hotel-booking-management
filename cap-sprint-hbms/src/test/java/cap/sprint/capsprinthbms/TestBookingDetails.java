package cap.sprint.capsprinthbms;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cap.sprint.capsprinthbms.entities.BookingDetails;
import cap.sprint.capsprinthbms.entities.Hotel;
import cap.sprint.capsprinthbms.entities.RoomDetails;
import cap.sprint.capsprinthbms.entities.User;
import cap.sprint.capsprinthbms.services.BookingDetailsServicesImpl;
import cap.sprint.capsprinthbms.services.RoomDetailsServicesImpl;

@SpringBootTest
class TestBookingDetails {
	
	@Autowired
	BookingDetailsServicesImpl bookingDetailsServicesImpl;
	
	@Test
	public void testAddBookingDetails() {
		
		User user = new User("Raj", "rajjj@gmail", "Visitor", "9870065522", "Chennai");
		System.out.println(user);
		Hotel hotel = new Hotel(2,"Bangalore", "Taj", "yelahanka", "5 star", 1000.00, "jaz@email.com", "111", "222", "jaz.com");
		System.out.println(hotel);
		RoomDetails rd = new RoomDetails();
		rd.setRoomId(1);
		System.out.println(rd);

		BookingDetails bd = new BookingDetails(user, LocalDate.of(2021, 3, 6), LocalDate.of(2021, 06, 8), 3, 4, 200.00, hotel,Arrays.asList(rd));
		bookingDetailsServicesImpl.addBookingDetails(bd);
	
	}
	
	
//	@Test
	public void testupdateBookingDetails() {
		Hotel hotel = new Hotel(3,"Hubli", "HotelJaz", "hebbal", "5 star", 1000.00, "jaz@email.com", "111", "222", "jaz.com");
	    System.out.println(hotel);
		
	    User user = new User(1,"Lasya", "alien@gmail", "Visitor", "9870065522", "Chennai");
		System.out.println("Updating this user"+ user);
		
		RoomDetails rd = new RoomDetails();
		rd.setRoomId(1);
		System.out.println(rd);
	
		BookingDetails bd = new BookingDetails(3,user, LocalDate.of(2021, 3, 6), LocalDate.of(2021, 06, 8), 55, 4, 200.00, hotel,Arrays.asList(rd));
		System.out.println("Updating this bookingdetails"+ bd);
		
		bookingDetailsServicesImpl.updateBookingDetails(bd);
	
	
	}
	
//	@Test
	public void testremoveBookingDetails() {
	
		bookingDetailsServicesImpl.removeBookingDetails(3);
	
		
	}
//	@Test
	public void testviewBookingDetails() {

		System.out.println(bookingDetailsServicesImpl.viewBookingDetails(3));
		
	}
	
//	@Test
	public void testviewBookingDetailsList() {
		System.out.println(bookingDetailsServicesImpl.viewBookingDetailsList());
		
	}
	

	
	
}
