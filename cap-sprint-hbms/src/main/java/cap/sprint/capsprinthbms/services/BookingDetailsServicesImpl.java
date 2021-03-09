package cap.sprint.capsprinthbms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.sprint.capsprinthbms.entities.BookingDetails;
import cap.sprint.capsprinthbms.entities.RoomDetails;
import cap.sprint.capsprinthbms.exceptions.BookingDetailsNotFoundException;
import cap.sprint.capsprinthbms.repos.IBookingDetailsRepository;


@Service
public class BookingDetailsServicesImpl {
	
	@Autowired
	IBookingDetailsRepository iBookingDetailsRepository;
	
	@Autowired
	RoomDetailsServicesImpl roomDetailsServicesImpl;
	
	
	public void addBookingDetails(BookingDetails bd) {
		
		List<RoomDetails> rooms = new ArrayList<RoomDetails>();
		for(RoomDetails rd : bd.getRoomDetailsList())
		{
	
			rooms.add(roomDetailsServicesImpl.findRoomDetails(rd.getRoom_id()));
			
		}
		bd.setRoomDetailsList(rooms);
		iBookingDetailsRepository.save(bd);
	
	}
	
				
// Update BookingDetails	
			@Transactional
			public BookingDetails updateBookingDetails(BookingDetails bd3) {
				Optional<BookingDetails> getUpdateBookingDetails=iBookingDetailsRepository.findById(bd3.getBookingId());
				BookingDetails updateBookingDetails=null;
				if(getUpdateBookingDetails.isPresent()) {
				updateBookingDetails=getUpdateBookingDetails.get();
				if(bd3.getNoOfAdults()!=0)
				{updateBookingDetails.setNoOfAdults(bd3.getNoOfAdults());}
				if(bd3.getNoOfChildren()!=0)
				{updateBookingDetails.setNoOfChildren(bd3.getNoOfChildren());}
				
				}
				return updateBookingDetails;
			}
		
// Delete BookingDetails	
			public void removeBookingDetails(int id) {
				Optional<BookingDetails> bd = iBookingDetailsRepository.findById(id);
				if(bd.isPresent())
					iBookingDetailsRepository.deleteById(id);
				else throw new BookingDetailsNotFoundException("No Booking Details found with this id"+ id);
				
				}
	
			
			
// Show BookingDetails
			public BookingDetails viewBookingDetails(int bookingId) {
				Optional<BookingDetails> findRemoveBookingDetails=iBookingDetailsRepository.findById(bookingId);
				return findRemoveBookingDetails.get();
			}
			
			
// Show All BookingDetails	
			public List<BookingDetails>viewBookingDetailsList(){
				List<BookingDetails>bookingdetails=iBookingDetailsRepository.findAll();
				return bookingdetails;
			}
			
}
	
	
	


