package com.niit.DAO;

import java.util.List;

import com.niit.model.Category;
import com.niit.model.Product;

public interface ProductDAO 
{
	public List<Product> findAllProduct();
	public Product findProductById(int ProductId);
	public Product findProductByName(String ProductName);
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(int ProductId);
	List<Category> findAllCategories();
	Product getProduct(int id);
}
