package cap.sprint.capsprinthbms.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.sprint.capsprinthbms.entities.Hotel;
import cap.sprint.capsprinthbms.entities.RoomDetails;
import cap.sprint.capsprinthbms.exceptions.NoRoomsListedException;
import cap.sprint.capsprinthbms.exceptions.RoomDetailsNotFoundException;
import cap.sprint.capsprinthbms.repos.IHotelRepository;
import cap.sprint.capsprinthbms.repos.IRoomDetailsRepository;
import cap.sprint.capsprinthbms.services_interfaces.IRoomDetailsService;

@Service
public class RoomDetailsServicesImpl implements IRoomDetailsService {
	
	
		@Autowired
		IRoomDetailsRepository roomDetailsRepository;
		
		@Autowired
		IHotelRepository hotelRepository;
		
		
		public void addRoomDetails(RoomDetails rd) {
			try {
				Hotel hotel = hotelRepository.findByHotelname((rd.getHotel().getHotelname()));
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
				throw new RoomDetailsNotFoundException("No Room Details found with id "+id);
			else
				System.out.println(roomDetails.get());
		return roomDetails.get();
			
		}
		
		public List<RoomDetails> findAllRoomDetails() {
			List<RoomDetails> rd = roomDetailsRepository.findAll();
			if(rd.isEmpty())
				throw new NoRoomsListedException("No room are present");
				
			 return rd;      
			
		}
		
		@Transactional
		public RoomDetails updateRoomDetails(RoomDetails roomDetails) {
			
				Optional<RoomDetails> getUpdateRoomDetails=roomDetailsRepository.findById(roomDetails.getRoom_id());
				RoomDetails updateRoom=null;
				if(getUpdateRoomDetails.isPresent()) {
				updateRoom=getUpdateRoomDetails.get();
				if(roomDetails.getRoomNo()!=null)
				{updateRoom.setRoomNo(roomDetails.getRoomNo());}
				if(roomDetails.getRoomType()!=null)
				{updateRoom.setRoomType(roomDetails.getRoomType());}
				if(roomDetails.getRate_per_day()!= 0)
				{updateRoom.setRate_per_day(roomDetails.getRate_per_day());}
				if(roomDetails.getisIsavailable()!=false||roomDetails.getisIsavailable()!=true)
				{updateRoom.setIsavailable(roomDetails.getisIsavailable());}
				
		}
				return updateRoom;
	}
		
	
		public void deleteRoomDetails(int id){
			Optional<RoomDetails> room = roomDetailsRepository.findById(id);
			
			if(room.isPresent())
				roomDetailsRepository.deleteById(id);
			else throw new RoomDetailsNotFoundException("No room details found with this room id "+ id+ "to delete");

		   }
		

}


