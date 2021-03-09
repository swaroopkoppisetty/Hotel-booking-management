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

import cap.sprint.capsprinthbms.entities.User;
import cap.sprint.capsprinthbms.services.UserServicesImpl;

@RestController

public class UserController {
	@Autowired
	UserServicesImpl userService;
	@PostMapping("/users")
	@ResponseStatus(code = HttpStatus.CREATED)
	public User addUser(@RequestBody User user) {
	return	userService.addUser(user);}
	
	
	@GetMapping("/users/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public User viewUser(@PathVariable int id) {
	return	userService.viewUser(id);
	}
	
	
	@GetMapping("/users/all")
	@ResponseStatus(code = HttpStatus.OK)
	public List<User> viewUserList() {
		return userService.viewUserList();
	}
	
	
	@PutMapping("/users/update/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	
	@DeleteMapping("/users/delete/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeUser(@PathVariable int id) {
	userService.removeUser(id);
	}

}
