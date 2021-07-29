package examportal.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import examportal.helper.UserFoundException;
import examportal.model.User;
import examportal.model.UserRole;
import examportal.repo.RoleRepository;
import examportal.repo.UserRepository;
import examportal.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		// TODO Auto-generated method stub
		
	User local=	this.userRepository.findByusername(user.getUsername());
	if(local!=null) {
		System.out.println("user is already there!!!");
		throw new UserFoundException();
	}
	else {
		//user create
		for(UserRole ur:userRoles) {
			roleRepository.save(ur.getRole());
		}
		user.getUserRoles().addAll(userRoles);
		local= this.userRepository.save(user);
	}
	
	return local;
	}

	//getting user by username
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByusername(username);
	}

	
	//delete 
	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(userId);
		
	}

}
