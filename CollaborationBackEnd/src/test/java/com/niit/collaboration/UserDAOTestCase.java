package com.niit.collaboration;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

import junit.framework.Assert;

public class UserDAOTestCase {

	@Autowired
	private static User user;

	@Autowired
	static UserDAO userDAO;
	
	@Autowired
	static AnnotationConfigApplicationContext context;

	// @BeforeClass it should be static

	@BeforeClass
	public static void init() {
		
		context.scan("com.niit.*");
		context.refresh();
		user = (User) context.getBean("user");
		userDAO = (UserDAO) context.getBean("userDAO");

	}
	
	public void validateCredentialsTestCase()
	{
		boolean flag = userDAO.isvalidCredentials("niit", "niit");
		Assert.assertEquals("validateCredentialsTestCase", true , flag);
	}
	
	@Test   
	public void saveUserTestCase() {
		user.setUser_id(111);
		user.setName("Shaireen");
		user.setRole("Student");
		user.setAddress("Bangalore");
		user.setContact("0000");
		boolean flag = userDAO.save(user);
		Assert.assertEquals("saveUserTestCase", true, flag);

	}

	@Test
	public void updateUserTestCase() {
		user.setUser_id(111);
		user.setName("Shivani");
		user.setRole("Student");
		user.setAddress("Bangalore");
		user.setContact("0000");
		boolean flag = userDAO.update(user);
		Assert.assertEquals("updateUserTestCase", true, flag);

	}
	


}
		 
	 


