package cap.sprint.capsprinthbms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cap.sprint.capsprinthbms.entities.User;
import cap.sprint.capsprinthbms.services.UserServicesImpl;

@SpringBootTest
class TestUser {

	@Autowired
	UserServicesImpl userServiceImpl;

	@Test
	public void testaddUser() {
		
		User user = new User("Raj", "rajjj@gmail", "Visitor", "9870065522", "Chennai");
		System.out.println(user);
		userServiceImpl.addUser(user);
		
	}
	
	//@Test
	public void testremoveUser() {
		
		User user = new User(6,"Raj", "rajjj@gmail", "Visitor", "9870065522", "Chennai");
		System.out.println("Removing this user"+ user);
		userServiceImpl.removeUser(user);
		
	}
	
//	@Test
	public void testupdateUser() {
		
		User user = new User(3,"Mindy", "mmtesting@gmail", "Guest", "87654321", "UK");
		System.out.println("Updating this user"+ user);
		userServiceImpl.updateUser(user);
		
	}
	
	
//	@Test
	public void testviewUser() {

		System.out.println(userServiceImpl.viewUser(4));
		
	}
	
//	@Test
	public void testviewUserList() {
		System.out.println(userServiceImpl.viewUserList());
		
	}
}
