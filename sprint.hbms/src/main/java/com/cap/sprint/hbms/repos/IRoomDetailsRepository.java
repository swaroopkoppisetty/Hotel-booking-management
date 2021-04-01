package com.cap.sprint.hbms.repos;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.cap.sprint.hbms.entities.RoomDetails;

@Repository
public interface IRoomDetailsRepository extends JpaRepository<RoomDetails, Integer>{
	
	public RoomDetails findByRoomNo(String roomNo);


	public RoomDetails findByRoomId(int roomId);


	
	
	public  List<RoomDetails> findByRoomType(String roomType);
	
	@Query("select r from RoomDetails r where r.isavailable=true and r.roomType=:roomType")
	public  List<RoomDetails> findAvailableByType(@Param("roomType")String roomType);
	
	



}
