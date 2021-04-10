package com.cap.sprint.hbms.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.cap.sprint.hbms.entities.BookRequest;
import com.cap.sprint.hbms.entities.BookingDetails;
import com.cap.sprint.hbms.entities.Hotel;
import com.cap.sprint.hbms.entities.RoomDetails;
import com.cap.sprint.hbms.entities.User;
import com.cap.sprint.hbms.exceptions.NotFoundException;
import com.cap.sprint.hbms.repos.IRoomDetailsRepository;
import com.cap.sprint.hbms.services.BookingDetailsServicesImpl;
import com.cap.sprint.hbms.services.HotelServicesImpl;
import com.cap.sprint.hbms.services.PaymentsServicesImpl;
import com.cap.sprint.hbms.services.RoomDetailsServicesImpl;
import com.cap.sprint.hbms.services.TransactionsServicesImpl;
import com.cap.sprint.hbms.services.UserServicesImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/v1")
@Api(value = "Booking", tags = { "BookingAPI" })
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
	
	@Autowired
	IRoomDetailsRepository  iRoomDetailsRepository;
//	
//	@Autowired
//	BookRequest request;
	
	/**
	 * This method is for adding a booking
	 * 
	 * @param Booking
	 * @return Booking
	 * @throws NotFoundException
	 * @throws ValidationException
	 */

	@PostMapping("/bookingdetails")
	@ApiOperation(value = "Add a booking", notes = "Provide Booking Details ", response = BookingDetails.class)
//	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<BookingDetails> addBookingDetails(@ApiParam(value = "Booking to be added", required = true)@RequestBody BookRequest request) {
		//BookingDetails b =bookingdetailsService.addBookingDetails(bd);
		
		BookingDetails b = new BookingDetails();
		Hotel hotel= new Hotel();
		User user = new User();
		List<RoomDetails> list = iRoomDetailsRepository.findAvailableByType(request.getRoomType());
		
		if(list.size()<request.getRoomCount())
		{
			
			throw new NotFoundException("No rooms available to book");
		}
		user.setUserName(request.getUserName());
		hotel.setHotelName(request.getHotelName());
		b.setRoomDetailsList(list.subList(0, request.getRoomCount()));
		b.setUser(user);
		b.setHotel(hotel);
		b.setBookedFrom(request.getBookedFrom());
		b.setBookedTo(request.getBookedTo());
		b.setNoOfAdults(request.getNoOfAdults());
		b.setNoOfChildren(request.getNoOfChildren());
		b.setAmount(request.getAmount());
		return new ResponseEntity<>(bookingdetailsService.addBookingDetails(b),HttpStatus.CREATED);}
	
	/**
	 * This method is for fetching a booking by id
	 * 
	 * @return BookingDetails
	 * @throws NotFoundException
	 * 
	 */
	@GetMapping("/bookingdetails/{bookingId}")
	@ApiOperation(value = "View booking by id", notes = "Provide booking id to be viewed", response = BookingDetails.class)
//	@ResponseStatus(code = HttpStatus.OK)
	 public ResponseEntity<Optional<BookingDetails>> viewBookingDetails(@ApiParam(value = "ID value to view booking", required = true) @PathVariable ("bookingId") int bookingId) {
		Optional<BookingDetails> bd = bookingdetailsService.viewBookingDetails(bookingId);
		return new ResponseEntity<>(bd,HttpStatus.OK);
	}
	
	@GetMapping("/bookingdetails/email/{email}")
	@ApiOperation(value = "View booking by id", notes = "Provide booking id to be viewed", response = BookingDetails.class)
//	@ResponseStatus(code = HttpStatus.OK)
	 public ResponseEntity<List<BookingDetails>> viewBookingDetails(@ApiParam(value = "ID value to view booking", required = true) @PathVariable ("email") String email) {
		List<BookingDetails> bookings = bookingdetailsService.viewBookingByEmail(email);
		return new ResponseEntity<>(bookings,HttpStatus.OK);
	}
	/**
	 * This method is for getting a list of all bookings .
	 * 
	 * @return List<BookingDetails>
	 * @throws NotFoundException
	 * 
	 */
	@GetMapping("/bookingdetails")
//	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(value = "View all bookings", response = BookingDetails.class)
	public ResponseEntity<List<BookingDetails>> viewBookingDetailsList() {
		List<BookingDetails> bookings = bookingdetailsService.viewBookingDetailsList();
		return new ResponseEntity<>(bookings,HttpStatus.OK);
	}
	

	
	/**
	 * This method is for updating no_of_adults and no_of_children of a booking
	 * 
	 * @return String
	 * @throws NotFoundException
	 * 
	 */
	@PutMapping("/bookingdetails")
	@ApiOperation(value = "Update a booking", notes = "Provide booking id, new no_of_adults and new no_of_children", response = BookingDetails.class)
//	
	public ResponseEntity<String> updateBookingDetails
	(@ApiParam(value = "Booking to be updated", required = true)@RequestBody BookingDetails bookingDetails) {
		  bookingdetailsService.updateBookingDetails(bookingDetails);
		 return new ResponseEntity<>("Successfuly updated", HttpStatus.ACCEPTED);
	}
	
	/**
	 * This method is for deleting a booking by id
	 * 
	 * @return String
	 * @throws NotFoundException
	 * 
	 */
	@DeleteMapping("/bookingdetails/{id}")
	@ApiOperation(value = "Delete a booking", notes = "Provide booking id of booking to be deleted", response = BookingDetails.class)
//	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<String> removeBookingDetails
	(@ApiParam(value = "ID value of the booking to be deleted", required = true) 
	@PathVariable("id") int id) {
        bookingdetailsService.removeBookingDetails(id);
        return new ResponseEntity<>("Successfuly deleted", HttpStatus.OK);
	}

}



// create a seperate class Bookrequest
