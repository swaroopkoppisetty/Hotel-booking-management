package com.cap.sprint.hbms.repos;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.cap.sprint.hbms.entities.RoomDetails;

@Repository
public interface IRoomDetailsRepository extends JpaRepository<RoomDetails, Integer>{
	
	public RoomDetails findByRoomNo(String roomNo);


	public RoomDetails findByRoomId(int roomId);



}
