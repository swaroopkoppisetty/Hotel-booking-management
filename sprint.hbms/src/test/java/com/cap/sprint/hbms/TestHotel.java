package com.cap.sprint.hbms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.sprint.hbms.entities.Hotel;
import com.cap.sprint.hbms.exceptions.AlreadyExistsException;
import com.cap.sprint.hbms.repos.IHotelRepository;
import com.cap.sprint.hbms.services.HotelServicesImpl;

@SpringBootTest
class TestHotel {
	Logger logger = LogManager.getLogger(TestHotel.class);
	@Autowired
	HotelServicesImpl hotelServices;
    @Autowired
    IHotelRepository hotelRepository;

	//@Test
	public void testaddHotel() {
		
		Hotel hotel = new Hotel("Bangalore", "HotelJaz", "yelahanka", "5 star", 1000.00, "jaz@email.com", "111", "222", "jaz.com");
//		System.out.println(hotel);
		logger.info(hotel);
		hotelServices.addHotel(hotel);
		
		
	}
//	@Test
	public void testremoveHotel() {
		hotelServices.removeHotelById(4);
		
	}
	
//	@Test
	public void testupdateHotel() {
		
		Hotel hotel = new Hotel(1, "Bangalore", "Royal hotel", "Jubilee hills", "Luxury hotel", 2000.00, "royal@email.com", "123", "321", "royal.com");
		logger.info(hotel);
		hotelServices.updateHotel(hotel);
		
	}
//	@Test
	public void testviewHotel() {

		Optional<Hotel> h = hotelServices.viewHotel(4);
		logger.info(h);
	}
	
//	@Test
	public void testviewAllHotel() {
		List<Hotel> h = hotelServices.viewHotelList();
		logger.info(h);
	}

}
