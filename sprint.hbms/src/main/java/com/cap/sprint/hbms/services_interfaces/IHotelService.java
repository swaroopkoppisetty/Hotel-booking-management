package com.cap.sprint.hbms.services_interfaces;

import java.util.List;
import java.util.Optional;

import com.cap.sprint.hbms.entities.Hotel;

public interface IHotelService {
	
	public Hotel addHotel(Hotel h);
	public Hotel updateHotel(Hotel hotel);
	public void removeHotelById(int id);
	public List<Hotel> viewHotelList();
	public Optional<Hotel> viewHotel(int hotelId);
	public Hotel viewHotelByName(String hotelName);

	

}
