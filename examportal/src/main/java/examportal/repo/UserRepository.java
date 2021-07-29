package examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import examportal.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

	public User findByusername(String username);
}
