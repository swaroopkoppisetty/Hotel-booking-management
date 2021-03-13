package com.cap.sprint.hbms.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cap.sprint.hbms.entities.Hotel;

import com.cap.sprint.hbms.exceptions.AlreadyExistsException;
import com.cap.sprint.hbms.exceptions.NotFoundException;
import com.cap.sprint.hbms.repos.IHotelRepository;
import com.cap.sprint.hbms.services_interfaces.IHotelService;

@Service
public class HotelServicesImpl implements IHotelService{
	Logger logger = LogManager.getLogger(HotelServicesImpl.class);
	@Autowired
	IHotelRepository hotelRepository;
	
	
	@Transactional
	public Hotel addHotel(Hotel h) {
		Hotel hotel = hotelRepository.findByHotelName(h.getHotelName());
		if(hotel == null) {
			hotelRepository.save(h);
		   return h;}
		else throw new AlreadyExistsException("hotel already exists with the id" + h.getHotelId());
	}
	
	@Transactional
	public Hotel updateHotel(Hotel hotel) {
		
		Hotel updatehotel=hotelRepository.findByHotelId(hotel.getHotelId());
		
		if(updatehotel != null)
		{
			if(hotel.getDescription()!= null)
			{updatehotel.setDescription(hotel.getDescription());}
			if(hotel.getAverage_rate_per_day()!= 0.0)
			{updatehotel.setAverage_rate_per_day(hotel.getAverage_rate_per_day());}
			if(hotel.getEmail()!= null)
			{updatehotel.setEmail(hotel.getEmail());}
			if(hotel.getPhone1()!= null)
			{updatehotel.setPhone1(hotel.getPhone1());}
			if(hotel.getPhone2()!= null)
			{updatehotel.setPhone2(hotel.getPhone2());}
			if(hotel.getWebsite()!= null)
			{updatehotel.setWebsite(hotel.getWebsite());}
			
			return updatehotel;
		}
		else throw new NotFoundException("No hotel exists to update");
			
	
		

}
		
		
		
		public void removeHotelById(int id) 
		{
			Optional<Hotel> hotel = hotelRepository.findById(id);
			if(hotel.isPresent())
			{
				try 
				{
				hotelRepository.deleteById(id);
				}
			catch(DataIntegrityViolationException e){
				throw new AlreadyExistsException("Booking exists for a room in this hotel, cannot delete.");}
			}
			
			else
			{
				throw new NotFoundException("No hotel found with this hotel id "+id);

			}
		}

		
		
		public List<Hotel> viewHotelList(){
			List<Hotel> list = hotelRepository.findAll();
			if(list.isEmpty())
				throw new NotFoundException("No hotels Found to show");
			
			
			logger.info(list);
			return list;
		}

		
		public Optional<Hotel> viewHotel(int hotelId) {
			Optional<Hotel> h = hotelRepository.findById(hotelId);
			
			if(!h.isPresent())
			
				throw new NotFoundException("Hotel not found");
				
			else 
			{
				logger.info(h);
			    return h;
			}
				
}

		
		public Hotel viewHotelByName(String hotelName) {
			Hotel h = hotelRepository.findByHotelName(hotelName);
			if(h == null)
			
				throw new NotFoundException("Hotel not found");
			
			else 
			{
				logger.info(h);
			    return h;
			}
				
	
		}

		
}

	

