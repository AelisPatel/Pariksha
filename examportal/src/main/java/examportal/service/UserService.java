package examportal.service;

import java.util.Set;

import examportal.model.User;
import examportal.model.UserRole;

public interface UserService {

	
	//creating user
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
	//get user by username
	public User getUser(String username);
	
	//delete user by ID
	public void deleteUser(Long userId);
}
