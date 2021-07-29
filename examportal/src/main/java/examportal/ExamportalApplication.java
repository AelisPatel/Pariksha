package examportal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import examportal.helper.UserFoundException;
import examportal.model.Role;
import examportal.model.User;
import examportal.model.UserRole;
import examportal.service.UserService;

@SpringBootApplication
public class ExamportalApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ExamportalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		try {
		System.out.println("starting code");
	
		User user=new User();
		user.setFirstName("aelis");
		user.setLastName("patel");
		user.setUsername("aelis123");
		user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
		user.setEmail("abc@gmail.com");
		user.setProfile("default.png");
		
		Role role1=new Role();
		role1.setRoleId(44L);
		role1.setRoleName("ADMIN");
		
		Set<UserRole> userRoleSet=new HashSet<>();
		UserRole userRole=new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		userRoleSet.add(userRole);
		
		User user1= this.userService.createUser(user, userRoleSet);
		System.out.println(user1.getUsername());
		}catch(UserFoundException e ) {
			e.printStackTrace();
		}
	}

}
