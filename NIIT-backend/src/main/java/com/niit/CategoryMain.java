package com.niit;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.DAO.CategoryDAO;
import com.niit.DBConfig.DBConfig;
import com.niit.model.Category;

public class CategoryMain {

	public void categoryOut() 
	{

Category Category1 = new Category();
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		CategoryDAO CategoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("choose a  product category to do the manipulation");
		System.out.println("1.Add Category /n 2.Delete Category /n 3.Update Category /n 4.View All Category's /n 5.View Category's by ID /n 6.View Category's by Name");
		
		int choice = sc.nextInt();
		
		switch(choice){
		case 1:
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
			break;
		case 2:
			
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
			break;
		case 3:
			List<Category> CategoryList2 = CategoryDAO.findAllCategorys();
			for(Category Category : CategoryList2)
			{
				System.out.print("| Id:"+Category.getCategoryid()+"|");
				System.out.print("Name:"+Category.getCategoryname()+"|");
				System.out.print("Parent :"+Category.getParentcategory()+"|");
				System.out.println("");

			}
			System.out.println("Please Enter the CategoryId");
			Category1.setCategoryid(sc.nextInt());
			System.out.println("Please Enter the Category details for updation");
			
			System.out.println("CategoryName:");

		 Category1.setCategoryname(sc.next());
			
			System.out.println("ParentCategory:");

			Category1.setParentcategory(sc.next());
			
			boolean result2 = CategoryDAO.updateCategory(Category1);
			if(result2 == true)
			{
				System.out.println("Details has been updated successfully");
			}
			break;
			
		case 4:
			List<Category> productCategoryList = CategoryDAO.findAllCategorys();
			for(Category productCategory : productCategoryList)
			{
				System.out.print("| Id:"+productCategory.getCategoryid()+"|");
				System.out.print("Name:"+productCategory.getCategoryname()+"|");
				System.out.print("Parent :"+productCategory.getParentcategory()+"|");
				System.out.println("");

			}
			break;
			
		case 5:
			System.out.println("Please enter the CategoryId to view Category Details");
			int CategoryId3 = sc.nextInt();
			Category Category = CategoryDAO.findCategoryById(CategoryId3);
			System.out.print("| Id:"+Category.getCategoryid()+"|");
			System.out.print("Name:"+Category.getCategoryname()+"|");
			System.out.print("Parent :"+Category.getParentcategory()+"|");

			break;
		case 6:
			System.out.println("Please enter the CategoryName to view Category Details");
			String CategoryName = sc.next();
			Category Category2 = CategoryDAO.findCategoryByName(CategoryName);
			System.out.print("| Id:"+Category2.getCategoryid()+"|");
			System.out.print("Name:"+Category2.getCategoryname()+"|");
			System.out.print("Parent :"+Category2.getParentcategory()+"|");

			break;
			
	 default: System.out.println("Please enter a valid input");
			
		}
		
		
		
		context.close();
		sc.close();
		

	}

}

