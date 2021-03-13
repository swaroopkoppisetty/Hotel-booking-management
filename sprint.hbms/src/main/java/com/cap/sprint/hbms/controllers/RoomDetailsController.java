package com.cap.sprint.hbms.controllers;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cap.sprint.hbms.entities.RoomDetails;
import com.cap.sprint.hbms.payload.UploadFileResponse;
import com.cap.sprint.hbms.services.RoomDetailsServicesImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping(path = "/api/v1")
@Api(value = "RoomDetails", tags = { "RoomManagementAPI" })
public class RoomDetailsController {
	
	@Autowired
	RoomDetailsServicesImpl roomDetailsServices;

	/**
	 * This method is for adding a Room Details
	 * 
	 * @param RoomDetails
	 * @return RoomDetails
	 * @throws NotFoundException
	 * @throws ValidationException
	 */

	@PostMapping("/roomdetails")
	@ApiOperation(value = "Add a Room", notes = "Provide Room Details ", response = RoomDetails.class)
//	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<RoomDetails> addingRoomDetails(@ApiParam(value = "Room Details to be added", required = true)@RequestBody RoomDetails rd) {
		RoomDetails room = roomDetailsServices.addRoomDetails(rd);
		return new ResponseEntity<>(room,HttpStatus.CREATED);
	}
	
	/**
	 * This method is for fetching room details by id
	 * 
	 * @return RoomDetails
	 * @throws NotFoundException
	 * 
	 */

	@GetMapping("/roomdetails/{id}")
	@ApiOperation(value = "View Room by id", notes = "Provide room id of room to be viewed", response = RoomDetails.class)
//	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<RoomDetails> findRoomDetails(@ApiParam(value = "ID value to view room details")@PathVariable int id) {
		RoomDetails room = roomDetailsServices.findRoomDetails(id);
		 return new ResponseEntity<>(room,HttpStatus.OK);
	}
	
	/**
	 * This method is for getting a list of all Room Details.
	 * 
	 * @return List<RoomDetails>
	 * @throws NotFoundException
	 * 
	 */
	@GetMapping("/roomdetails")
//	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(value = "View all rooms", response = RoomDetails.class)
	public ResponseEntity<List<RoomDetails>> findAllRoomDetails() {
		List<RoomDetails> rooms = roomDetailsServices.findAllRoomDetails();
		return new ResponseEntity<>(rooms,HttpStatus.OK);
	}
	
	/**
	 * This method is for updating room details
	 * 
	 * @return String
	 * @throws NotFoundException
	 * 
	 */
	@PutMapping("/roomdetails")
//	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@ApiOperation(value = "Update a room", notes = "Provide room id, change necessary details", response = RoomDetails.class)
	public ResponseEntity<String> updateRoomDetails(@ApiParam(value = "Room to be updated", required = true)@RequestBody RoomDetails roomDetails) {
		 roomDetailsServices.updateRoomDetails(roomDetails);
		 return new ResponseEntity<>("Successfuly updated", HttpStatus.ACCEPTED);
	}
	
	/**
	 * This method is for deleting a room by id
	 * 
	 * @return String
	 * @throws NotFoundException
	 * 
	 */
	@DeleteMapping("/roomdetails/{id}")
//	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete Room Details", notes = "Provide room id of room to be deleted", response = RoomDetails.class)
	public ResponseEntity<String> deleteRoomDetails(@ApiParam(value = "ID value of the room to be deleted", required = true)@PathVariable int id) {
		roomDetailsServices.deleteRoomDetails(id);
		return new ResponseEntity<>("Successfully deleted", HttpStatus.ACCEPTED);
	}
	
	/**
	 * This method is for adding a Photo of a Room 
	 * 
	 * @param RoomDetails
	 * @return RoomDetails
	 * @throws FileStorageException
	 */
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
