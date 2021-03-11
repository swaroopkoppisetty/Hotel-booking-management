package cap.sprint.capsprinthbms.services_interfaces;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cap.sprint.capsprinthbms.entities.RoomDetails;

public interface IRoomDetailsService {
	public void addRoomDetails(RoomDetails rd);
	public RoomDetails findRoomDetails(int id);
	public List<RoomDetails> findAllRoomDetails();
	public RoomDetails updateRoomDetails(RoomDetails roomDetails);
	public void deleteRoomDetails(int id);
	public RoomDetails storeFile(MultipartFile file);
	 public RoomDetails getFile(int roomId);
	
}
