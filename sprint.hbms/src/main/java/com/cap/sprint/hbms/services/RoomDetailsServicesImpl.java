package com.cap.sprint.hbms.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.cap.sprint.hbms.entities.Hotel;
import com.cap.sprint.hbms.entities.RoomDetails;
import com.cap.sprint.hbms.exceptions.AlreadyExistsException;
import com.cap.sprint.hbms.exceptions.FileStorageException;

import com.cap.sprint.hbms.exceptions.NotFoundException;

import com.cap.sprint.hbms.repos.IHotelRepository;
import com.cap.sprint.hbms.repos.IRoomDetailsRepository;
import com.cap.sprint.hbms.services_interfaces.IRoomDetailsService;

@Service
public class RoomDetailsServicesImpl implements IRoomDetailsService {
	Logger logger = LogManager.getLogger(RoomDetailsServicesImpl.class);
	
		@Autowired
		IRoomDetailsRepository roomDetailsRepository;
		
		@Autowired
		IHotelRepository hotelRepository;
		
		@Transactional
		public RoomDetails addRoomDetails(RoomDetails rd) {
		
		
			try {
				Hotel hotel = hotelRepository.findByHotelName((rd.getHotel().getHotelName()));
				if(hotel != null){
					rd.setHotel(hotel);
				}
			}
			catch(NoResultException e) {
				e.printStackTrace();
			}
			
			roomDetailsRepository.save(rd);
			return rd;
		}
		
		
		public RoomDetails findRoomDetails(int id)
		{
			Optional<RoomDetails> roomDetails = roomDetailsRepository.findById(id);
			
			if(!roomDetails.isPresent())
				throw new NotFoundException("No Room Details found with id "+id);
			else

				logger.info(roomDetails.get());
		return roomDetails.get();
			
		}
		
		public List<RoomDetails> findAllRoomDetails() {
			List<RoomDetails> rd = roomDetailsRepository.findAll();
			if(rd.isEmpty())
				throw new NotFoundException("No room are present");
				
			 return rd;      
			
		}
		
		@Transactional
		public RoomDetails updateRoomDetails(RoomDetails roomDetails) {
			
				RoomDetails updateRoom=roomDetailsRepository.findByRoomId(roomDetails.getRoomId());

				if(updateRoom != null)
				{

					if(roomDetails.getRate_per_day()!= 0)
					{updateRoom.setRate_per_day(roomDetails.getRate_per_day());}
					if(roomDetails.isIsavailable()!=false||roomDetails.isIsavailable()!=true)
					{updateRoom.setIsavailable(roomDetails.isIsavailable());}
					
				}
				
				else throw new NotFoundException("No room exists to update with this id" +roomDetails.getRoomId());
		
				return updateRoom;
			
			
	}
		
	
		public void deleteRoomDetails(int id){
			Optional<RoomDetails> room = roomDetailsRepository.findById(id);
			
			if(room.isPresent()) {
				try {
					roomDetailsRepository.deleteById(id);
				}
				catch(DataIntegrityViolationException e){
					throw new AlreadyExistsException("Booking exists for this room, cannot delete.");
					
				}
			}
			else throw new NotFoundException("No room details found with this room id "+ id+ "to delete");

		   }
		
	
	public RoomDetails storeFile(MultipartFile file) {
	        
			// Normalize file name
	        
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	        try
	        {
// Check if the file's name contains invalid characters
	        	
	            if(fileName.contains("..")) {
	                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
	            }
	            Hotel hotel = new Hotel("Bangalore", "Taj", "yelahanka", "5 star", 1000.00, "jaz@email.com", "9988776655", "7766554433", "jaz.com");
	            
	            RoomDetails room= new RoomDetails(3,"51","suite",2000.00,true,fileName,file.getContentType(), file.getBytes(),hotel);
	            

	            return roomDetailsRepository.save(room);
	        } 
	        catch (IOException ex) 
	        {
	            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
	        }
	    }
		
		
		
	public RoomDetails getFile(int roomId)
		 {
		        return roomDetailsRepository.findById(roomId)
		                .orElseThrow(() -> new NotFoundException("File not found with id " + roomId));
		  }
		
		
		@Transactional
		public void bookRoom(RoomDetails room)
		{
			room = this.findRoomDetails(room.getRoomId());
			room.setIsavailable(false);
		}


//		public RoomDetails findRoomType(String roomType) 
//		{
//			 return roomDetailsRepository.findByRoomType(roomType);
//		}
		                
		

}


