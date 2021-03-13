package com.cap.sprint.hbms.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.cap.sprint.hbms.entities.Hotel;

import com.cap.sprint.hbms.services_interfaces.IHotelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(path = "/api/v1")
@Api(value = "Hotel", tags = { "HotelManagementAPI" })
public class HotelController {
	
	@Autowired
	IHotelService hotelService;
    
	/**
	 * This method is for adding Hotel Details
	 * 
	 * @param Hotel
	 * @return Hotel
	 * @throws NotFoundException
	 * @throws ValidationException
	 */
	@PostMapping("/hotel")
//	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value = "Add a Hotel", notes = "Provide Hotel Details ", response = Hotel.class)
	public ResponseEntity<Hotel> addHotel(@ApiParam(value = "Hotel Details to be added", required = true)@RequestBody Hotel h) {
	Hotel hotel = hotelService.addHotel(h);
	return new ResponseEntity<Hotel> (hotel,HttpStatus.CREATED);}
	
	/**
	 * This method is for fetching a Hotel by id
	 * 
	 * @return Hotel
	 * @throws NotFoundException
	 * 
	 */
	@GetMapping("/hotel/{id}")
	@ApiOperation(value = "View Hotel by id", notes = "Provide hotel id of hotel to be viewed", response = Hotel.class)
//	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Optional<Hotel>> viewHotel(@ApiParam(value = "ID value to view hotel details")@PathVariable int id) {
	Optional<Hotel> hotel = hotelService.viewHotel(id);
	return new ResponseEntity<Optional<Hotel>> (hotel,HttpStatus.OK);}
	
	
	/**
	 * This method is for fetching a Hotel by name
	 * 
	 * @return Hotel
	 * @throws NotFoundException
	 * 
	 */
	@GetMapping("/hotels/{hotelName}")
	@ApiOperation(value = "View Hotel by name", notes = "Provide hotel name of hotel to be viewed", response = Hotel.class)
//	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Hotel> viewHotelByName(@ApiParam(value = "Provide name to view hotel details")@PathVariable String hotelName) {
	Hotel hotel = hotelService.viewHotelByName(hotelName);
	return new ResponseEntity<Hotel> (hotel,HttpStatus.OK);}
	
	
	/**
	 * This method is for getting a list of all Hotels by Id.
	 * 
	 * @return List<Hotel>
	 * @throws NotFoundException
	 * 
	 */
	@GetMapping("/hotel")
//	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(value = "View all hotels", response = Hotel.class)
	public ResponseEntity<List<Hotel>> viewHotelList() {
		List<Hotel> hotels = hotelService.viewHotelList();
		return new ResponseEntity<>(hotels,HttpStatus.OK);
	}
	
	/**
	 * This method is for updating hotel details
	 * 
	 * @return String
	 * @throws NotFoundException
	 * 
	 */
	@PutMapping("/hotel")
//	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@ApiOperation(value = "Update hotel details", notes = "Provide hotel id, change necessary details", response = Hotel.class)
	public ResponseEntity<String> updateHotel(@RequestBody Hotel h) {
		 hotelService.updateHotel(h);
		 return new ResponseEntity<>("Successfully Updated",HttpStatus.ACCEPTED);
	}
	
	/**
	 * This method is for deleting a hotel by id
	 * 
	 * @return String
	 * @throws NotFoundException
	 * 
	 */
	@DeleteMapping("/hotel/{id}")
//	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete Hotel Details", notes = "Provide Hotel id of hotel to be deleted", response = Hotel.class)
	public ResponseEntity<String> removeHotelId(@ApiParam(value = "ID value of the hotel to be deleted", required = true)@PathVariable int id) {
		hotelService.removeHotelById(id);
		return new ResponseEntity<>("Successfully deleted", HttpStatus.ACCEPTED);
	}
	
	
}

