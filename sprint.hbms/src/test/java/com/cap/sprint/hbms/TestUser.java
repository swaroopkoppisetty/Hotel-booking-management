package com.cap.sprint.hbms;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.sprint.hbms.entities.User;
import com.cap.sprint.hbms.exceptions.AlreadyExistsException;
import com.cap.sprint.hbms.services.UserServicesImpl;

@SpringBootTest
class TestUser {
	Logger logger = LogManager.getLogger(TestUser.class);
	@Autowired
	UserServicesImpl userServiceImpl;

	@Test
	public void testaddUser() {
		
		User user = new User("Raniiii", "raniiii@gmail","Ranii123!", "Visitor", "9870065522", "Chennai");

		logger.info(user);
		userServiceImpl.addUser(user);
		
	}
	
	//@Test
	public void testremoveUser() {
		
//		System.out.println("Removing this user");
		logger.info("Removing this user");
		userServiceImpl.removeUser(1);
		
		
		
	}
	
//	@Test
	public void testupdateUser() {
		
		User user = new User(2,"Raju", "mmtesting@gmail","TestPas123", "Guest", "87654321", "UK");

		logger.info("Updating this user"+ user);
		userServiceImpl.updateUser(user);
		
	}
	

	
	
//	@Test
	public void testviewUser() {


		logger.info(userServiceImpl.viewUser(3));
		
	}
	
//	@Test
	public void testviewUserList() {

		logger.info(userServiceImpl.viewUserList());
		
	}
}