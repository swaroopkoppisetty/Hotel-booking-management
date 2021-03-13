package com.cap.sprint.hbms.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cap.sprint.hbms.entities.BookingDetails;
import com.cap.sprint.hbms.entities.User;
import com.cap.sprint.hbms.exceptions.AlreadyExistsException;

import com.cap.sprint.hbms.exceptions.NotFoundException;
import com.cap.sprint.hbms.repos.IUserRepository;
import com.cap.sprint.hbms.services_interfaces.IUserService;



@Service
public class UserServicesImpl implements IUserService{

	@Autowired
	IUserRepository userRepository;

// ADD USER
	@Transactional
	public User addUser(User user) {
		User u = userRepository.findByUserName(user.getUserName());
		if(u == null) {
			userRepository.save(user);
		}else {
			throw new AlreadyExistsException("User " +user.getUserId()+" already exixts");
		}
		return user;
	}
	
	// VIEW ALL USERS
		public List<User> viewUserList() {
			return userRepository.findAll();
		}

// DELETE USER
	public void removeUser(int id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {try {
			userRepository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new AlreadyExistsException("Booking of a room exists for this user , cannot delete.");
		}
		}
		else throw new NotFoundException("No User Details found with this id"+ id);

	}
	// SHOW USER BY ID
		public User viewUser(int user_id) {
			Optional<User> user = userRepository.findById(user_id);
			if (user.isPresent()) {
				return user.get();
			} else {
				throw new NotFoundException("User Doesnt Exist");
			}

		}

	// UPDATE USER
	@Transactional
	public User updateUser(User user) {
		Optional<User> getUpdateUser=userRepository.findById(user.getUserId());
		User updateUser=null;
		if(getUpdateUser.isPresent()) {
		updateUser=getUpdateUser.get();
		if(user.getUserName()!=null)
		{updateUser.setUserName(user.getUserName());}
		if(user.getPassword()!=null)
		{updateUser.setPassword(user.getPassword());}
		if(user.getEmail()!=null)
		{updateUser.setEmail(user.getEmail());}
		if(user.getRole()!=null)
		{updateUser.setRole(user.getRole());}
		if(user.getMobile()!=null)
		{updateUser.setMobile(user.getMobile());}
		if(user.getAddress()!=null)
		{updateUser.setAddress(user.getAddress());}
		}
		return updateUser;
	}

}