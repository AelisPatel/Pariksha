package examportal.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import examportal.model.exam.Category;
import examportal.repo.CategoryRepository;
import examportal.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public Category getCategory(Long categoryID) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(categoryID).get();
	}

	@Override
	public void deleteCategory(Long categoryID) {
		// TODO Auto-generated method stub
		Category category=new Category();
		category.setCid(categoryID);
		this.categoryRepository.delete(category);
		
	}

}
