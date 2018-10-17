package com.niit.DAOImplTest;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.DAO.SupplierDAO;
import com.niit.DBConfig.DBConfig;
import com.niit.model.Supplier;

import junit.framework.TestCase;

public class SupplierDAOImplTest extends TestCase {
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	Supplier supplier=new Supplier();
    Scanner sc = new Scanner(System.in);
@Test
	public void testFindAllSuppliers() {
		 
	}
@Test
	public void testFindSupplierById() {
		
	}
@Test
	public void testFindSupplierByName() {
		
	}
@Test
	public void testAddSupplier() {
		System.out.println("Please enter the supplier details to enter");
		System.out.println("Supplier ID:");

		supplier.setSupplierid(sc.nextInt());
		
		System.out.println("Supplier Name:");

		supplier.setSuppliername(sc.next());
		
		System.out.println("Supplier Mobile Number:");

		supplier.setSuppliermobilenumber(sc.next());
		System.out.println("Supplier Address:");

		supplier.setSupplieraddress(sc.next());
		System.out.println("Supplier MailId:");

		supplier.setSupplieremail(sc.next());

		boolean result1 = supplierDAO.addSupplier(supplier);
		if(result1 == true)
		{
			System.out.println("Details has been added successfully");
		}
		
		
	}
@Test
	public void testUpdateSupplier() {
		
	}

	/*public void testDeleteSupplier() {
		List<Supplier> supplierList1 = supplierDAO.findAllSuppliers();
		for(Supplier supplier1 : supplierList1)
		{
			System.out.print("| Id:"+supplier1.getSupplierId()+"|");
			System.out.print("Name:"+supplier1.getSupplierName()+"|");
			System.out.print("Mobile Number:"+supplier1.getSupplierMobileNumber()+"|");
			System.out.print("Address:"+supplier1.getSupplierAddress()+"|");
			System.out.print("Email:"+supplier1.getSupplierEmail()+"|");
			
			System.out.println("");

		}
		System.out.println("Please enter the supplier id to be deleted from the above table");
		int SupplierId = sc.nextInt();
		boolean result = supplierDAO.deleteSupplier(SupplierId);
		if(result == true)
		{
			System.out.println("The row has been successfuly deleted");
		}
		
	}*/

}

