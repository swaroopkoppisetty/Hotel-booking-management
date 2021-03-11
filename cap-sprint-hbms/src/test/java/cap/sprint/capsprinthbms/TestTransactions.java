package cap.sprint.capsprinthbms;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cap.sprint.capsprinthbms.entities.BookingDetails;
import cap.sprint.capsprinthbms.entities.Hotel;
import cap.sprint.capsprinthbms.entities.Payments;
import cap.sprint.capsprinthbms.entities.RoomDetails;
import cap.sprint.capsprinthbms.entities.Transactions;
import cap.sprint.capsprinthbms.entities.User;
import cap.sprint.capsprinthbms.services.TransactionsServicesImpl;

@SpringBootTest
class TestTransactions {

	
	@Autowired
	TransactionsServicesImpl transactionServicesImpl;
	
	
	@Test
	public void testAddTransaction()
	{
	
		User user = new User(5,"Raj", "rajjj@gmail", "Visitor", "9870065522", "Chennai");
		System.out.println(user);
		Hotel hotel = new Hotel(2,"Bangalore", "Taj", "yelahanka", "5 star", 1000.00, "jaz@email.com", "111", "222", "jaz.com");
		System.out.println(hotel);
		RoomDetails rd = new RoomDetails();
		rd.setRoomId(1);
		System.out.println(rd);
		BookingDetails bd = new BookingDetails(4,user, LocalDate.of(2021, 3, 6), LocalDate.of(2021, 06, 8), 3, 4, 200.00, hotel,Arrays.asList(rd));
		System.out.println(bd);
		Payments payment = new Payments(6,bd);
		System.out.println(payment);
		
		Transactions transactions = new Transactions(bd.getAmount(),payment);
		transactionServicesImpl.addTransaction(transactions);
		
		
}
}
