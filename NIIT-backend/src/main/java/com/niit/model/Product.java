package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	@Id
	@GeneratedValue
	
	int productid;
	int categoryid;
	int supplierid;
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierId) {
		supplierid = supplierId;
	}
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	String productname;
	String productdescription;
	double productprice;
	
	int productsize;
	int productquantity;
	
	
	
	
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductdescription() {
		return productdescription;
	}
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}
	public double getProductprice() {
		return productprice;
	}
	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}
	public int getProductsize() {
		return productsize;
	}
	public void setProductSize(int productSize) {
		productsize = productSize;
	}
	public int getProductquantity() {
		return productquantity;
	}
	public void setProductquantity(int productQuantity) {
		productquantity = productQuantity;
	}
	public MultipartFile getImage() {
		
		return null;
	}
}