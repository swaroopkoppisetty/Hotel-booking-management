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
import cap.sprint.capsprinthbms.services.PaymentsServicesImpl;

@SpringBootTest
class TestPayments {

	
		
		@Autowired
		PaymentsServicesImpl paymentsServicesImpl;
		
		@Test
		public void testAddPayment()
		{
			User user = new User("uuuu", "alien@gmail", "Visitor", "9870065522", "Chennai");
			System.out.println(user);
			Hotel hotel = new Hotel("Bangalore", "HotelJaz", "yelahanka", "5 star", 1000.00, "jaz@email.com", "111", "222", "jaz.com");
			RoomDetails rd = new RoomDetails("222", "Non-suite", 1000.00, true, hotel);
			BookingDetails bd = new BookingDetails(user, LocalDate.of(2021, 3, 6), LocalDate.of(2021, 06, 8), 3, 4, 200.00, hotel, Arrays.asList(rd));
			
			Transactions transaction = new Transactions(bd.getAmount());
			
			
			System.out.println(transaction);
			
			
			
			Payments payment =new Payments(bd,transaction);
			paymentsServicesImpl.addPayment(payment);
			
			System.out.println(payment);
			
			
		}

}


