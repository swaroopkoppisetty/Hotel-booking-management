package com.cap.sprint.hbms;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.sprint.hbms.entities.BookingDetails;
import com.cap.sprint.hbms.entities.Hotel;
import com.cap.sprint.hbms.entities.Payments;
import com.cap.sprint.hbms.entities.RoomDetails;
import com.cap.sprint.hbms.entities.Transactions;
import com.cap.sprint.hbms.entities.User;
import com.cap.sprint.hbms.exceptions.AlreadyExistsException;
import com.cap.sprint.hbms.services.PaymentsServicesImpl;

@SpringBootTest
class TestPayments {
	Logger logger = LogManager.getLogger(TestPayments.class);
	@Autowired
	PaymentsServicesImpl paymentsServicesImpl;
	
	@Test
	public void testAddPayment()
	{
	User user = new User(12,"Raj", "rajjj@gmail", "Raj123!","Visitor", "9870065522", "Chennai");

	logger.info(user);
	Hotel hotel = new Hotel(2,"Bangalore", "Taj", "yelahanka", "5 star", 1000.00, "jaz@email.com", "111", "222", "jaz.com");

	logger.info(hotel);
	RoomDetails rd = new RoomDetails();
	rd.setRoomId(5);
	rd.setIsavailable(false);

	logger.info(rd);
	BookingDetails bd = new BookingDetails(11,user, LocalDate.of(2021, 3, 6), LocalDate.of(2021, 06, 8), 3, 4, 200.00, hotel,Arrays.asList(rd));
		

		
		Payments payment = new Payments(bd);
		paymentsServicesImpl.addPayment(payment);
		

		logger.info(payment);
}
	
	
	
}
