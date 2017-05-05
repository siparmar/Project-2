package com.niit.collaboration.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.config.ApplicationContextConfig;
import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

public class UserClient {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

		UserDAO userdao = (UserDAO) ctx.getBean("UserDAO");

		User user = new User();
		user.setUser_id(1);
		user.setName("Shaireen");
		user.setPassword("niit");
		user.setRole("Admin");
		user.setAddress("India");
		user.setContact("1010");

		if (userdao.update(user)) {

			System.out.println("saved..");
		}

		else {

			System.out.println("Not saved..");
		}

	}
}




