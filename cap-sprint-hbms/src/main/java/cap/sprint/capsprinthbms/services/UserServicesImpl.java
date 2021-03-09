package cap.sprint.capsprinthbms.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.sprint.capsprinthbms.entities.RoomDetails;
import cap.sprint.capsprinthbms.entities.User;
import cap.sprint.capsprinthbms.exceptions.RoomDetailsNotFoundException;
import cap.sprint.capsprinthbms.exceptions.UserNotFoundException;
import cap.sprint.capsprinthbms.repos.IUserRepository;
import cap.sprint.capsprinthbms.services_interfaces.IUserService;

@Service
public class UserServicesImpl implements IUserService {
	
	@Autowired
	IUserRepository userRepository;
	
	public User addUser(User user) {
		userRepository.save(user);
		return user;
	
	}
	
// Update User	
	@Transactional
	public User updateUser(User user) {
		Optional<User> getUpdateUser=userRepository.findById(user.getUserId());
		User updateUser=null;
		if(getUpdateUser.isPresent()) {
		updateUser=getUpdateUser.get();
		if(user.getUserName()!=null)
		{updateUser.setUserName(user.getUserName());}
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
	
// Delete User	
	public void removeUser(int id){
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent())
			userRepository.deleteById(id);
		else throw new UserNotFoundException("No user found with this  id "+ id+ "to delete");

	   }
	
// Show User
	public User viewUser(int userId) {
		Optional<User> findRemoveUser=userRepository.findById(userId);
		return findRemoveUser.get();
	}
	
	
// Show All Users	
	public List<User>viewUserList(){
		List<User>user=userRepository.findAll();
		return user;
	}
}