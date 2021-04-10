    package com.cap.sprint.hbms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cap.sprint.hbms.entities.BookingDetails;
import com.cap.sprint.hbms.entities.Hotel;
import com.cap.sprint.hbms.entities.RoomDetails;
import com.cap.sprint.hbms.entities.User;
import com.cap.sprint.hbms.exceptions.AlreadyExistsException;
import com.cap.sprint.hbms.exceptions.NotFoundException;
import com.cap.sprint.hbms.repos.IBookingDetailsRepository;
import com.cap.sprint.hbms.repos.IRoomDetailsRepository;
import com.cap.sprint.hbms.services_interfaces.IBookingDetailsService;


@Service
public class BookingDetailsServicesImpl implements IBookingDetailsService {
	
	Logger logger = LogManager.getLogger(BookingDetailsServicesImpl.class);
	
	@Autowired
	IBookingDetailsRepository iBookingDetailsRepository;
	
	@Autowired
	RoomDetailsServicesImpl roomDetailsServicesImpl;
	
	@Autowired
	HotelServicesImpl hotelServicesImpl;
	
	@Autowired
	UserServicesImpl userServicesImpl;
	
	
	
	
	@Transactional
	public BookingDetails addBookingDetails(BookingDetails bd) {
		
		List<RoomDetails> rooms = new ArrayList<RoomDetails>();
		Hotel hotel= hotelServicesImpl.viewHotelByName(bd.getHotel().getHotelName());
		User user = userServicesImpl.findByUserName(bd.getUser().getUserName());
		
		
		
			for(RoomDetails rd : bd.getRoomDetailsList())
			{
				rooms.add(roomDetailsServicesImpl.findRoomDetails(rd.getRoomId()));
				
				

			}
			bd.setUser(user);
			bd.setHotel(hotel);
			bd.setRoomDetailsList(rooms);
			return iBookingDetailsRepository.save(bd);
		
}
	
				
// Update BookingDetails	
	@Transactional
	public BookingDetails updateBookingDetails(BookingDetails bd3) {
	
		BookingDetails updateBookingDetails=iBookingDetailsRepository.findByBookingId(bd3.getBookingId());
		
		if(updateBookingDetails != null)
		{

			if(bd3.getNoOfAdults()!=0)
			{updateBookingDetails.setNoOfAdults(bd3.getNoOfAdults());}
			if(bd3.getNoOfChildren()!=0)
			{updateBookingDetails.setNoOfChildren(bd3.getNoOfChildren());}
		}
		
		else throw new NotFoundException("No Booking details are there with this id " + bd3.getBookingId());
		
		
		return updateBookingDetails;
	}
		
// Delete BookingDetails	
	@Transactional
			public void removeBookingDetails(int id) {
				Optional<BookingDetails> bd = iBookingDetailsRepository.findById(id);
				if(bd.isPresent()) {
					try {
							iBookingDetailsRepository.deleteById(id);
						}
						catch(DataIntegrityViolationException e){
							throw new AlreadyExistsException("Booking exists for this room, cannot delete.");
							
						}
					}
					else throw new NotFoundException("No room details found with this room id "+ id+ "to delete");

				   }
	
			
			
// Show BookingDetails
			public Optional<BookingDetails> viewBookingDetails(int bookingId) {
				Optional<BookingDetails> findBookingDetails=iBookingDetailsRepository.findById(bookingId);
				
				
				if(!findBookingDetails.isPresent())
					
					throw new NotFoundException("Booking details not found");
					
				else 
				{
					logger.info(findBookingDetails);
					return findBookingDetails;
				}

			}
			
			
// Show All BookingDetails	
			public List<BookingDetails>viewBookingDetailsList(){
				
				List<BookingDetails> b = iBookingDetailsRepository.findAll();
				
				
				if(b.isEmpty())
					throw new NotFoundException("No hotels Found to show");
				
				
				logger.info(b);
				return b;
			}
			
			
    public List<BookingDetails>viewBookingByEmail(String email){
				
				List<BookingDetails> b = iBookingDetailsRepository.findAll();
				List<BookingDetails> bookings= new ArrayList<>();
				
				
				
				if(b.isEmpty())
					throw new NotFoundException("No hotels Found to show");
				
				for(BookingDetails booking : b)
				{
					if(booking.getUser().getEmail().equals(email))
					{
						bookings.add(booking);
					}
				}
				
				
				
				
				logger.info(b);
				return bookings;
			}
			
			
			
}
	
	
	


