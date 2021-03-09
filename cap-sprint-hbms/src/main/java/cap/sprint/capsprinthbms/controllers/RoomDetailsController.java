package cap.sprint.capsprinthbms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import cap.sprint.capsprinthbms.entities.RoomDetails;
import cap.sprint.capsprinthbms.repos.IRoomDetailsRepository;
import cap.sprint.capsprinthbms.services.RoomDetailsServicesImpl;

@RestController
public class RoomDetailsController {
	
	@Autowired
	RoomDetailsServicesImpl roomDetailsServices;

//	public void addingroom() {
//	roomDetailsServices.addRoomDetails(RoomDetails r);
//	}
	
}
