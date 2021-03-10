package cap.sprint.capsprinthbms.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.sprint.capsprinthbms.entities.Hotel;
import cap.sprint.capsprinthbms.entities.RoomDetails;
import cap.sprint.capsprinthbms.exceptions.AlreadyExistsException;
import cap.sprint.capsprinthbms.exceptions.NotFoundException;
import cap.sprint.capsprinthbms.repos.IHotelRepository;
import cap.sprint.capsprinthbms.services_interfaces.IHotelService;

@Service
public class HotelServicesImpl implements IHotelService{
	
	@Autowired
	IHotelRepository hotelRepository;
	
	
	@Transactional
	public void addHotel(Hotel h) {
		Hotel hotel = hotelRepository.findByHotelName(h.getHotelName());
		if(hotel == null)
			hotelRepository.save(h);
		else throw new AlreadyExistsException("hotel already exists with the id" + h.getHotelId());
	}
	
	@Transactional
	public Hotel updateHotel(Hotel hotel) {
		
		Hotel updatehotel=hotelRepository.findByHotelId(hotel.getHotelId());
		
			
			
			
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
		
		
		
		public void removeHotelById(int id) 
		{
			Optional<Hotel> hotel = hotelRepository.findById(id);
			if(hotel.isPresent())
			{
				hotelRepository.deleteById(id);
			}
			
			else
			{
				throw new NotFoundException("No hotel found with this hotel id "+id);

			}
		}

		
		
		public List<Hotel> viewHotelList(){
			List<Hotel> list = hotelRepository.findAll();
			System.out.println(list);
			return list;
		}

		
		public Optional<Hotel> viewHotel(int hotelId) {
			Optional<Hotel> h = hotelRepository.findById(hotelId);
			System.out.println(h);
		    return h;
		}

		
}

	

