package com.cap.sprint.hbms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.sprint.hbms.entities.RoomDetails;
import com.cap.sprint.hbms.entities.User;
import com.cap.sprint.hbms.services_interfaces.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@RestController
@CrossOrigin
@RequestMapping(path = "/api/v1")
@Api(value = "User Details", tags = { "UserManagementAPI" })
public class UserController {

	@Autowired
	IUserService userService;
	/**
	 * This method is for adding a User
	 * 
	 * @param User
	 * @return User
	 * @throws NotFoundException
	 * @throws ValidationException
	 */
	@PostMapping("/users") 
	@ApiOperation(value = "Add a user", notes = "Provide User Details ", response = User.class)
	public ResponseEntity<User> addUser(@ApiParam(value = "User Details to be added", required = true)@RequestBody User u) 
	{
		User user = userService.addUser(u); 
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}

	/**
	 * This method is for deleting a user by id
	 * 
	 * @return String
	 * @throws NotFoundException
	 * 
	 */
	@DeleteMapping("/users/{id}")
	@ApiOperation(value = "Delete User Details", notes = "Provide user id of user to be deleted", response = User.class)
	public ResponseEntity<String> deleteUser(@ApiParam(value = "ID value of the User to be deleted", required = true)@PathVariable("id") int id) 
	{
		userService.removeUser(id); 
		return new ResponseEntity<>("Successfuly deleted", HttpStatus.OK);
	}
	
	
	// VIEW USER BY ID
	/**
	 * This method is for fetching user details by id
	 * 
	 * @return User
	 * @throws NotFoundException
	 * 
	 */
		@GetMapping("/users/{id}")
		@ApiOperation(value = "View User by id", notes = "Provide user id of user to be viewed", response = User.class)
		public ResponseEntity<User> viewUser(@ApiParam(value = "ID value to view user details")@PathVariable("id") int id){
			User u = userService.viewUser(id); 
			return new ResponseEntity<>(u,HttpStatus.OK);
		}
		
		//VIEW ALL USERS
		/**
		 * This method is for getting a list of all User Details.
		 * 
		 * @return List<User>
		 * @throws NotFoundException
		 * 
		 */
		@GetMapping("/users")
		@ResponseStatus(code = HttpStatus.OK)
		@ApiOperation(value = "View all users", response = RoomDetails.class)
		public ResponseEntity<List<User>> showAllUsers() {
			List<User> u = userService.viewUserList();
			 return new ResponseEntity<>(u,HttpStatus.OK);
		}
		
		// UPDATE USER
		/**
		 * This method is for updating user details
		 * 
		 * @return String
		 * @throws NotFoundException
		 * 
		 */
		@PutMapping("/users")
		@ApiOperation(value = "Update a user", notes = "Provide user id, change necessary details", response = User.class)
			public ResponseEntity<String> viewUserList(@ApiParam(value = "User details to be updated", required = true)@RequestBody User user){
			 userService.updateUser(user); 
			return new ResponseEntity<>("Successfully Updated",HttpStatus.ACCEPTED);
		}

}