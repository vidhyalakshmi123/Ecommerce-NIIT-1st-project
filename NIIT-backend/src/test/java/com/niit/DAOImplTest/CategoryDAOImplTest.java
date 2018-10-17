package com.niit.DAOImplTest;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.DAO.CategoryDAO;
import com.niit.DBConfig.DBConfig;
import com.niit.model.Category;

import junit.framework.TestCase;

public class CategoryDAOImplTest extends TestCase {
	Category Category1 = new Category();
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	CategoryDAO CategoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	Scanner sc = new Scanner(System.in);
@Test
	public void testFindAllCategorys() {
		List<Category> productCategoryList = CategoryDAO.findAllCategorys();
		for(Category productCategory : productCategoryList)
		{
			System.out.print("| Id:"+productCategory.getCategoryid()+"|"); 
			System.out.print("Name:"+productCategory.getCategoryname()+"|");
			System.out.print("Parent :"+productCategory.getParentcategory()+"|");
			System.out.println("");

		}
	}
@Test
	public void testFindCategoryById() {
		System.out.println("Please enter the CategoryId to view Category Details");
		int CategoryId3 = sc.nextInt();
		Category Category = CategoryDAO.findCategoryById(CategoryId3);
		System.out.print("| Id:"+Category.getCategoryid()+"|");
		System.out.print("Name:"+Category.getCategoryname()+"|");
		System.out.print("Parent :"+Category.getParentcategory()+"|");
		
	} 

@Test
public void testFindCategoryByName() {
		System.out.println("Please enter the CategoryName to view Category Details");
		String CategoryName = sc.next();
		Category Category2 = CategoryDAO.findCategoryByName(CategoryName);
		System.out.print("| Id:"+Category2.getCategoryid()+"|");
		System.out.print("Name:"+Category2.getCategoryname()+"|");
		System.out.print("Parent :"+Category2.getParentcategory()+"|");
		
	}
@Test
	public void testAddCategory() {
		System.out.println("Please Enter the productCategory details to enter");
		System.out.println("ProductCategory ID:");
		Category1.setCategoryid(sc.nextInt());
		System.out.println("CategoryName:");
        Category1.setCategoryname(sc.next());
		System.out.println("ParentCategory:");
        Category1.setParentcategory(sc.next());
		boolean result1 = CategoryDAO.addCategory(Category1);
		if(result1 == true)
		{
			System.out.println("Details has been added successfully");
		}
	}
@Test
	public void testUpdateCategory() {
		
	}

	public void testDeleteCategory() {
		List<Category> CategoryList1 = CategoryDAO.findAllCategorys();
		for(Category Category : CategoryList1)
		{
			System.out.print("| Id:"+Category.getCategoryid()+"|");
			System.out.print("Name:"+Category.getCategoryname()+"|");
			System.out.print("Parent :"+Category.getParentcategory()+"|");
			System.out.println("");

		}
		System.out.println("Please enter the ProductCategoryId to be deleted from the above Table");
		int ProductCategoryId = sc.nextInt();
		boolean result = CategoryDAO.deleteCategory(ProductCategoryId);
		if(result == true)
		{
			System.out.println("The row has been successfuly deleted");
		}
		
	}

}
