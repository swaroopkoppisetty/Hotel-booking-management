package cap.sprint.capsprinthbms.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cap.sprint.capsprinthbms.entities.Hotel;
import cap.sprint.capsprinthbms.services_interfaces.IHotelService;


@RestController
public class HotelController {
	
	@Autowired
	IHotelService hotelService;


	@PostMapping("/hotel")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addHotel(@RequestBody Hotel h) {
	 hotelService.addHotel(h);}
	
	
	@GetMapping("/hotel/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<Hotel> viewHotel(@PathVariable int id) {
	return hotelService.viewHotel(id);
	}
	
	
	@GetMapping("/hotel")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Hotel> viewHotelList() {
		return hotelService.viewHotelList();
	}
	
	
	@PutMapping("/hotel")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Hotel updateHotel(@RequestBody Hotel h) {
		return hotelService.updateHotel(h);
	}
	
	
	@DeleteMapping("/hotel/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeHotelId(@PathVariable int id) {
		hotelService.removeHotelById(id);
	}
	
	
}

