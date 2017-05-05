package com.niit.collaboration.test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

import junit.framework.Assert;

public class UserTestCase {

	@Autowired
	private static User user;

	@Autowired
	static UserDAO userDAO;

	
	// @BeforeClass it should be static
	@BeforeClass
	public static void init() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration.*");
		context.refresh();
		user = (User) context.getBean(User.class);
		userDAO = (UserDAO) context.getBean("userDAO");

	}

	@Test
	public void validateCredentialsTestCase() {

		System.out.println("Validate method started");
		boolean flag = userDAO.validate(01, "niit");
		Assert.assertEquals("validateCredentialsTestCase", true, flag);

	}

	
	//SAVE TEST CASE
	//@Test
	public void saveUserTestCase() {

		System.out.println("save method started");

		user.setName("Shaireen");
		user.setRole("Student");
		user.setAddress("Bangalore");
		user.setContact("0000");
		userDAO.save(user);
		Assert.assertEquals("saveUserTestCase", true);

	}

	//UPDATE TEST CASE
	//@Test
	public void updateUserTestCase() {

		System.out.println("update method started");
		
		user.setUser_id(02);
		user.setName("Shivani");
		user.setRole("Student");
		user.setAddress("Bangalore");
		user.setContact("0000");
		boolean flag = userDAO.update(user);
		Assert.assertEquals("updateUserTestCase", true, flag);

	}

	//DELETE TEST CASE
	//@Test
	
}
