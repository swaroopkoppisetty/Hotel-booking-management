package cap.sprint.capsprinthbms.services_interfaces;

import java.util.List;

import cap.sprint.capsprinthbms.entities.User;

public interface IUserService {
	
	public User addUser(User user);
	public User updateUser(User user);
	public void removeUser(int id);
	public User viewUser(int userId);
	public List<User>viewUserList();

}