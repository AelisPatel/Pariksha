package examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import examportal.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
