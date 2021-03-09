package cap.sprint.capsprinthbms.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.sprint.capsprinthbms.entities.Hotel;
import cap.sprint.capsprinthbms.exceptions.HotelAlreayExistsException;
import cap.sprint.capsprinthbms.repos.IHotelRepository;
import cap.sprint.capsprinthbms.services_interfaces.IHotelService;

@Service
public class HotelServicesImpl implements IHotelService{
	
	@Autowired
	IHotelRepository hotelRepository;
	
	
	public void addHotel(Hotel h) {
		Hotel hotel = hotelRepository.findByHotelname(h.getHotelname());
		if(hotel == null)
			hotelRepository.save(h);
		else throw new HotelAlreayExistsException("hotel already exists with the id" + h.getHotelid());
	}
	
		@Transactional
		public Hotel updateHotel(Hotel hotel) {
			
				Optional<Hotel> getUpdateHotel=hotelRepository.findById(hotel.getHotelid());
				Hotel updateHotel=null;
				if(getUpdateHotel.isPresent()) {
				updateHotel=getUpdateHotel.get();
				if(hotel.getHotelname()!=null)
				{updateHotel.setHotelname(hotel.getHotelname());}
				if(hotel.getDescription()!= null)
				{updateHotel.setDescription(hotel.getDescription());}
				if(hotel.getAverage_rate_per_day()!= 0.0)
				{updateHotel.setAverage_rate_per_day(hotel.getAverage_rate_per_day());}
				if(hotel.getPhone1()!= null)
				{updateHotel.setPhone1(hotel.getPhone1());}
				if(hotel.getPhone2()!= null)
				{updateHotel.setPhone2(hotel.getPhone2());}
		}
				return updateHotel;

	}
		
		
		public void removeHotel(int id) {
			
			hotelRepository.deleteById(id);;
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

	

