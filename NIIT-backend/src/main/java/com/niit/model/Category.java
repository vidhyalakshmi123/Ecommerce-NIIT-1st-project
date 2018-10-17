package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 int categoryid;
	 String categoryname;
	 String parentcategory;
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getParentcategory() {
		return parentcategory;
	}
	public void setParentcategory(String parentcategory) {
		this.parentcategory = parentcategory;
	}
	
}
