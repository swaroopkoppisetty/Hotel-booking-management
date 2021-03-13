package cap.sprint.capsprinthbms.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;



import cap.sprint.capsprinthbms.entities.RoomDetails;
import cap.sprint.capsprinthbms.payload.UploadFileResponse;
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
	
	  @PostMapping("/uploadFile")
	    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
	        RoomDetails dbFile = roomDetailsServices.storeFile(file);

	       String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/downloadFile/")
	                .path(dbFile.getRoomNo())
	                .toUriString();

	        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
	                file.getContentType(), file.getSize());
	    }
	  
	  @GetMapping("/downloadFile/{roomId}")
	    public ResponseEntity<Resource> downloadFile(@PathVariable int roomId) {
	        // Load file from database
	        RoomDetails dbFile = roomDetailsServices.getFile(roomId);

	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
	                .body(new ByteArrayResource(dbFile.getData()));
	    }

	
}
