package cap.sprint.capsprinthbms.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cap.sprint.capsprinthbms.entities.BookingDetails;
import cap.sprint.capsprinthbms.services.BookingDetailsServicesImpl;
import cap.sprint.capsprinthbms.services.HotelServicesImpl;
import cap.sprint.capsprinthbms.services.PaymentsServicesImpl;
import cap.sprint.capsprinthbms.services.RoomDetailsServicesImpl;
import cap.sprint.capsprinthbms.services.TransactionsServicesImpl;
import cap.sprint.capsprinthbms.services.UserServicesImpl;

@RestController
public class BookingDetailsController {
	
	
	@Autowired
	BookingDetailsServicesImpl bookingdetailsService;
	@Autowired
	UserServicesImpl userService;
	@Autowired
	HotelServicesImpl hotelService;
	@Autowired
	RoomDetailsServicesImpl roomDetailsService;
	@Autowired
	TransactionsServicesImpl transactionService;
	
	@Autowired
	PaymentsServicesImpl paymentService;


	@PostMapping("/bookingdetails")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addBookingDetails(@RequestBody BookingDetails bd) {
    bookingdetailsService.addBookingDetails(bd);}
	
	
	@GetMapping("/bookingdetails/{bookingId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<BookingDetails> viewBookingDetails(@PathVariable int bookingId) {
	return	bookingdetailsService.viewBookingDetails(bookingId);
	}
	
	
	@GetMapping("/bookingdetails")
	@ResponseStatus(code = HttpStatus.OK)
	public List<BookingDetails> viewBookingDetailsList() {
		return bookingdetailsService.viewBookingDetailsList();
	}
	
	
	@PutMapping("/bookingdetails")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public BookingDetails updateBookingDetails(@RequestBody BookingDetails bd3) {
		return bookingdetailsService.updateBookingDetails(bd3);
	}
	
	
	@DeleteMapping("/bookingdetails/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeBookingDetails(@PathVariable int id) {
		bookingdetailsService.removeBookingDetails(id);
	}

}
