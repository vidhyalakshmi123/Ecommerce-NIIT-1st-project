package com.niit.DAO;

import java.util.List;

import com.niit.model.Category;

public interface CategoryDAO 
{
	public List<Category> findAllCategorys();
	public Category findCategoryById(int Id);
	public Category findCategoryByName(String CategoryName);
	public boolean addCategory(Category Category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(int CategoryId);
}
