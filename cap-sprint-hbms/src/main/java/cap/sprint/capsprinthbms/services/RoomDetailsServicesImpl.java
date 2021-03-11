package cap.sprint.capsprinthbms.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import cap.sprint.capsprinthbms.entities.Hotel;
import cap.sprint.capsprinthbms.entities.RoomDetails;
import cap.sprint.capsprinthbms.exceptions.FileStorageException;
import cap.sprint.capsprinthbms.exceptions.NoRoomsListedException;
import cap.sprint.capsprinthbms.exceptions.NotFoundException;

import cap.sprint.capsprinthbms.repos.IHotelRepository;
import cap.sprint.capsprinthbms.repos.IRoomDetailsRepository;
import cap.sprint.capsprinthbms.services_interfaces.IRoomDetailsService;

@Service
public class RoomDetailsServicesImpl implements IRoomDetailsService {
	
	
		@Autowired
		IRoomDetailsRepository roomDetailsRepository;
		
		@Autowired
		IHotelRepository hotelRepository;
		
		@Transactional
		public void addRoomDetails(RoomDetails rd) {
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
		}
		
		
		public RoomDetails findRoomDetails(int id)
		{
			Optional<RoomDetails> roomDetails = roomDetailsRepository.findById(id);
			
			if(!roomDetails.isPresent())
				throw new NotFoundException("No Room Details found with id "+id);
			else
				System.out.println(roomDetails.get());
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

				if(roomDetails.getRoomType()!=null)
				{updateRoom.setRoomType(roomDetails.getRoomType());}
				if(roomDetails.getRate_per_day()!= 0)
				{updateRoom.setRate_per_day(roomDetails.getRate_per_day());}
				if(roomDetails.isIsavailable()!=false||roomDetails.isIsavailable()!=true)
				{updateRoom.setIsavailable(roomDetails.isIsavailable());}
				
		
				return updateRoom;
			
			
	}
		
	
		public void deleteRoomDetails(int id){
			Optional<RoomDetails> room = roomDetailsRepository.findById(id);
			
			if(room.isPresent())
				roomDetailsRepository.deleteById(id);
			else throw new NotFoundException("No room details found with this room id "+ id+ "to delete");

		   }
		
		
		 public RoomDetails storeFile(MultipartFile file) {
		        // Normalize file name
		        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		        try {
		            // Check if the file's name contains invalid characters
		            if(fileName.contains("..")) {
		                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
		            }

		            //RoomDetails dbFile = new RoomDetails("101","deluxe",200.00,true,fileName, file.getContentType(), file.getBytes());
		          
		           // RoomDetails dbFile = new RoomDetails(1,"101","deluxe",2000.00,true,fileName,file.getContentType(), file.getBytes());
		            
		            Hotel hotel = new Hotel("Bangalore", "Taj", "yelahanka", "5 star", 1000.00, "jaz@email.com", "111", "222", "jaz.com");
		            
		            RoomDetails dbFile= new RoomDetails(1,"101","deluxe",2000.00,true,fileName,file.getContentType(), file.getBytes(),hotel);
		            

		            return roomDetailsRepository.save(dbFile);
		        } catch (IOException ex) {
		            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		        }
		    }

		    
		 
		 public RoomDetails getFile(int roomId)
		 {
		        return roomDetailsRepository.findById(roomId)
		                .orElseThrow(() -> new NotFoundException("File not found with id " + roomId));
		  }
		

}


