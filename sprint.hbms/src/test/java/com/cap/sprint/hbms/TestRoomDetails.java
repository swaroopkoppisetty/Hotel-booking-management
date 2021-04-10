package com.cap.sprint.hbms;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.sprint.hbms.entities.BookingDetails;
import com.cap.sprint.hbms.entities.Hotel;
import com.cap.sprint.hbms.entities.RoomDetails;
import com.cap.sprint.hbms.exceptions.AlreadyExistsException;
import com.cap.sprint.hbms.services.BookingDetailsServicesImpl;
import com.cap.sprint.hbms.services.RoomDetailsServicesImpl;


@SpringBootTest
class TestRoomDetails {
	Logger logger = LogManager.getLogger(TestRoomDetails.class);
	@Autowired
	BookingDetailsServicesImpl bookingDetailsServicesImpl;
	
	@Autowired
	RoomDetailsServicesImpl roomDetailsServicesImpl;

	@Test
	public void testaddRoomDetails() {
		
		Hotel hotel = new Hotel("Bangalore", "Taj", "yelahanka", "Luxury Hotel", 1000.00, "jaz@email.com", "9988776655", "7766554433", "jaz.com");
//		System.out.println(hotel);
		logger.info(hotel);
		RoomDetails roomdetails = new RoomDetails("15", "suite", 2000.00, true, hotel);
//		System.out.println(roomdetails);
		logger.info(roomdetails);
		roomDetailsServicesImpl.addRoomDetails(roomdetails);
	
		
	}
	
	//@Test
	public void testfindRoomDetails() {
		RoomDetails rd = roomDetailsServicesImpl.findRoomDetails(1);
//		System.out.println(rd);
		logger.info(rd);
	}
	
	//@Test
	public void testfindAllRoomDetails() {
		List<RoomDetails> allRoomDetails = roomDetailsServicesImpl.findAllRoomDetails();
//		System.out.println(allRoomDetails);
		logger.info(allRoomDetails);
	}

	
//	@Test
	public void testUpdateRoomDetails() {

		Hotel hotel = new Hotel(2,"Bangalore", "Taj", "yelahanka", "5 star", 1000.00, "jaz@email.com", "111", "222", "jaz.com");
		RoomDetails roomDetails = new RoomDetails(1,"87", "Non-suite", 2000.00, false, hotel);
//		roomDetails.setRoomId(1);
//		roomDetails.setRate_per_day(6000.00);
		
		
		RoomDetails rooms = roomDetailsServicesImpl.updateRoomDetails(roomDetails);
//		System.out.println(rooms);
		logger.info(rooms);

	}
	
	//@Test
	public void testdeleteRoomDetails() {
		
		roomDetailsServicesImpl.deleteRoomDetails(1);
	}
	
	

}
