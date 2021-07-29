package examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import examportal.model.exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
