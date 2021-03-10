package cap.sprint.capsprinthbms.controllers;
import java.util.List;
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

import cap.sprint.capsprinthbms.entities.RoomDetails;
import cap.sprint.capsprinthbms.services.RoomDetailsServicesImpl;

@RestController
public class RoomDetailsController {
	
	@Autowired
	RoomDetailsServicesImpl roomDetailsServices;


	@PostMapping("/roomdetails")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addingRoomDetails(@RequestBody RoomDetails rd) {
		roomDetailsServices.addRoomDetails(rd);
	}
	
	
	@GetMapping("/roomdetails/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public RoomDetails findRoomDetails(@PathVariable int id) {
		return roomDetailsServices.findRoomDetails(id);
	}
	
	
	@GetMapping("/roomdetails")
	@ResponseStatus(code = HttpStatus.OK)
	public List<RoomDetails> findAllRoomDetails() {
		return roomDetailsServices.findAllRoomDetails();
	}
	
	
	@PutMapping("/roomdetails")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public RoomDetails updateRoomDetails(@RequestBody RoomDetails roomDetails) {
		return roomDetailsServices.updateRoomDetails(roomDetails);
	}
	
	
	@DeleteMapping("/roomdetails/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteRoomDetails(@PathVariable int id) {
		roomDetailsServices.deleteRoomDetails(id);
	}
	
}
