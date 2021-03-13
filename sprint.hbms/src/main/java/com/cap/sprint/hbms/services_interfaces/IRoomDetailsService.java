package com.cap.sprint.hbms.services_interfaces;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cap.sprint.hbms.entities.RoomDetails;

public interface IRoomDetailsService {
	public RoomDetails addRoomDetails(RoomDetails rd);
	public RoomDetails findRoomDetails(int id);
	public List<RoomDetails> findAllRoomDetails();
	public RoomDetails updateRoomDetails(RoomDetails roomDetails);
	public void deleteRoomDetails(int id);
	public RoomDetails storeFile(MultipartFile file);
	 public RoomDetails getFile(int roomId);
}
