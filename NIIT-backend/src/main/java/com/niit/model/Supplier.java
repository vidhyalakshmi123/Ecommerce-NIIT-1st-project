package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Supplier implements Serializable
{
	@Id	

	@GeneratedValue
	int supplierid;
	String suppliername;
	String suppliermobilenumber;
	String supplieraddress;
	String supplieremail;
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierId) {
		this.supplierid = supplierid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getSuppliermobilenumber() {
		return suppliermobilenumber;
	}
	public void setSuppliermobilenumber(String suppliermobilenumber) {
		this.suppliermobilenumber = suppliermobilenumber;
	}
	public String getSupplieraddress() {
		return supplieraddress;
	}
	public void setSupplieraddress(String supplieraddress) {
		this.supplieraddress = supplieraddress;
	}
	public String getSupplieremail() {
		return supplieremail;
	}
	public void setSupplieremail(String supplieremail) {
		this.supplieremail = supplieremail;
	}
}
	