package com.cap.sprint.hbms.repos;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.sprint.hbms.entities.Hotel;


public interface IHotelRepository extends JpaRepository<Hotel, Integer> {
	public Hotel findByHotelName(String hotelName);

	public Hotel findByHotelId(int hotelId);

}