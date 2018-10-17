package com.niit.DAOImplTest;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ProductDAO;
import com.niit.DAOImpl.ProductDAOImpl;
import com.niit.DBConfig.DBConfig;
import com.niit.model.Product;

import junit.framework.TestCase;

public class ProductDAOImplTest extends TestCase {
	 ApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class,ProductDAOImpl.class);
	   ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
	   Product product= new Product();

	  @Test		
		public void testAddProduct() {
			product.setProductid(1);
			product.setProductprice(100); 
			product.setProductquantity(1);
			product.setProductname("mobile");
			product.setProductdescription("Blue color - l litre");
			boolean p=productDAO.addProduct(product);
			assertTrue(product.getProductid()>0);  
		}	
		
	

@Test
public void testFindAllProduct() {
		List<Product> productList = productDAO.findAllProduct();
		product.setProductid(1);
		product.setProductname("mobile");
		product.setProductdescription("apple");
		product.setProductSize(2);
		product.setProductquantity(2);
		product.setProductprice(1000);
		
	
}
@Test
	public void testFindProductById() {
		Product product = productDAO.findProductById(37);
	    product.setProductid(2);
	    product.setProductname("headset");
	    product.setProductdescription("black");
	    product.setProductSize(2);
		product.setProductquantity(5);
		product.setProductprice(1500);
		
	
	}
@Test
	public void testFindProductByName() {
		Product product = productDAO.findProductByName("mobile");
		product.getProductid();
		product.getProductname();
		product.getProductdescription();
		product.getProductsize();
		product.getProductquantity();
		product.getProductprice();
		
	}

@Test
	public void testUpdateProduct() {
		List<Product> productList = productDAO.findAllProduct();
		product.setProductid(37);
		product.setProductprice(2000);
		product.setProductquantity(25);
		assertTrue(product.getProductprice()==2000);
		assertTrue(product.getProductquantity()==25);
		boolean p=productDAO.updateProduct(product);
		assertTrue(product.getProductid()>0); 
		
	}
		
	
	/*
	public void testDeleteProduct() {
		List<Product> productList = productDAO.findAllProduct();
	        product.setProductId(2);
			product.setProductName("headset");
		    product.setProductDescription("black");
			product.setProductSize(2);
		    product.setProductQuantity(5);
		    product.setProductPrice(1500);
		    boolean p=productDAO.deleteProduct(2);
			assertTrue(product.getProductId()>0); 
		
	
			
}*/

}
