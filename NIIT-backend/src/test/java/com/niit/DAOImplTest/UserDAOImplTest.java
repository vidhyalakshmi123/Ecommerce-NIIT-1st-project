package com.niit.DAOImplTest;

import java.util.List;
import java.util.Scanner;

//import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.DAO.UserDAO;
import com.niit.DBConfig.DBConfig;
import com.niit.model.User;

import junit.framework.TestCase;

public class UserDAOImplTest extends TestCase {

	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	UserDAO userDAO = (UserDAO) context.getBean("userDAO");
	Scanner sc = new Scanner(System.in);
	User user1=new User();
	@Test
	public void testAddUser() {
		User user=new User();
		user.setUserId(1);
		user.setUsername("shakthi");
		user.setEmail("vid@gmail.com");
		user.setMobilenumber("9788848765");
		user.setPassword("vidhya");
		assertEquals(true,userDAO.addUser(user));
		
		 
			
		
	}
	
	@Test
	public void testFindAllUsers() {
		List<User> userList = userDAO.findAllUsers();
		for(User user : userList)
		{
			System.out.print("| Id:"+user.getUserId()+"|");
			System.out.print("Name:"+user.getUsername()+"|");
		    System.out.print("MobileNumber:"+user.getMobilenumber()+"");
			System.out.print("Email:"+user.getEmail()+"|");
			System.out.println("");

		}
	}

	@Test
	public void testFindUserById() {
		System.out.println("Please enter the UserId to view User Details");
		int UserId3 = sc.nextInt();
		User user = userDAO.findUserById(UserId3);
		System.out.print("| Id:"+user.getUserId()+"|");
		System.out.print("Name:"+user.getUsername()+"|");
        System.out.print("MobileNumber:"+user.getMobilenumber()+"");
		System.out.print("Email:"+user.getEmail()+"|");
		
	}
@Test
	public void testFindUserByName() {
		System.out.println("Please enter the UserName to view User Details");
		String UserName = sc.next();
		User user2 = userDAO.findUserByName(UserName);
		System.out.print("| Id:"+user2.getUserId()+"|");
		System.out.print("Name:"+user2.getUsername()+"|");
	    System.out.print("MobileNumber:"+user2.getMobilenumber()+"");
		System.out.print("Email:"+user2.getEmail()+"|");
	}
@Test
	public void testUpdateUser() {
		List<User> userList2 = userDAO.findAllUsers();
		for(User user : userList2)
		{
			System.out.print("| Id:"+user.getUserId()+"|");
			System.out.print("Name:"+user.getUsername()+"|");
		    System.out.print("MobileNumber:"+user.getMobilenumber()+"");
			System.out.print("Email:"+user.getEmail()+"|");
			System.out.print("Email:"+user.getPassword()+"|");
			
			System.out.println("");

		}
		
		System.out.println("Please Enter the userId");
		user1.setUserId(sc.nextInt());
		System.out.println("Please Enter the user details for updation");
		
		System.out.println("UserName:");
        user1.setUsername(sc.next());
		System.out.println("Mobile Number");
	
		user1.setMobilenumber(sc.next());
		System.out.println("Email");
		
		user1.setEmail(sc.next());
		System.out.println("Password");
		
		user1.setPassword(sc.next());
		
		boolean result2 = userDAO.updateUser(user1); 
		if(result2 == true)
		{
			System.out.println("Details has been updated successfully");
		}
		
	}


	public void testDeleteUser() {
		
		List<User> userList1 = userDAO.findAllUsers();
		for(User user : userList1)
		{
			System.out.print("| Id:"+user.getUserId()+"|");
			System.out.print("Name:"+user.getUsername()+"|");
			System.out.print("MobileNumber:"+user.getMobilenumber()+"");
			System.out.print("Email:"+user.getEmail()+"");
			System.out.println("");

		}
		System.out.println("Please enter the UserId to be deleted from the above Table");
		int UserId = sc.nextInt();
		boolean result = userDAO.deleteUser(UserId);
		if(result == true)
		{
			System.out.println("The row has been successfuly deleted");
		}
		
	}

}

