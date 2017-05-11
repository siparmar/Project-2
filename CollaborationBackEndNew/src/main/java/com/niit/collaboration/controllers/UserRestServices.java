package com.niit.collaboration.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

@RestController
public class UserRestServices {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private User user;
	
	@Autowired 
	private Session session;
	

	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody User user) {
		// client will send only username, password, email, role

		User savedUser = userDAO.save(user);
		
		if (savedUser.getUser_id() == 0) {
			Error error = new Error("Couldnt insert user details ");
			return new ResponseEntity<Error>(error, HttpStatus.CONFLICT);
		} else {
			System.out.println("user=" + savedUser.getUser_id() + "registered successfully******");
			return new ResponseEntity<User>(savedUser, HttpStatus.OK);
		}
	}
	
		/*@RequestMapping(value ="/Login" , method = RequestMethod.POST)
		public ResponseEntity<?> login(@RequestBody User user_id , HttpSession session , User password) {
			
			User validUser = userDAO.validate(user_id, password);
			if (validUser == null){
				Error error = new Error("Incorrecct credentials");
				return new ResponseEntity<Error>(error , HttpStatus.UNAUTHORIZED);
			}else{
				session.setAttribute("user", validUser);
				userDAO.update(validUser);
				return new ResponseEntity<User>(validUser, HttpStatus.OK);
				
			}
			
		}
		*/
		

	}

