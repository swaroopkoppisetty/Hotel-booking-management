package com.cap.sprint.hbms;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.sprint.hbms.entities.BookingDetails;
import com.cap.sprint.hbms.entities.Hotel;
import com.cap.sprint.hbms.entities.Payments;
import com.cap.sprint.hbms.entities.RoomDetails;
import com.cap.sprint.hbms.entities.Transactions;
import com.cap.sprint.hbms.entities.User;
import com.cap.sprint.hbms.exceptions.AlreadyExistsException;
import com.cap.sprint.hbms.services.TransactionsServicesImpl;

@SpringBootTest
class TestTransactions {
	Logger logger = LogManager.getLogger(TestTransactions.class);
	
	@Autowired
	TransactionsServicesImpl transactionServicesImpl;
	
	
	@Test
	public void testAddTransaction()
	{
	
		User user = new User(4,"Raj", "rajjj@gmail","Raj123!", "Visitor", "9870065522", "Chennai");
//		System.out.println(user);
		logger.info(user);
		Hotel hotel = new Hotel(2,"Bangalore", "Taj", "yelahanka", "5 star", 1000.00, "jaz@email.com", "111", "222", "jaz.com");
//		System.out.println(hotel);
		logger.info(hotel);
		RoomDetails rd = new RoomDetails();
		rd.setRoomId(1);
//		System.out.println(rd);
		logger.info(rd);
		BookingDetails bd = new BookingDetails(3,user, LocalDate.of(2021, 3, 6), LocalDate.of(2021, 06, 8), 3, 4, 200.00, hotel,Arrays.asList(rd));
//		System.out.println(bd);
		logger.info(bd);
		Payments payment = new Payments(15,bd);
//		System.out.println(payment);
		logger.info(payment);
		
		Transactions transactions = new Transactions(bd.getAmount(),payment);
		transactionServicesImpl.addTransaction(transactions);
		
		
}
}
