package com.niit.collaboration.controllers;

import java.util.List;

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
	

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody User user) {
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
	
		/*@RequestMapping(value ="/login" , method = RequestMethod.POST)
		public ResponseEntity<?> login(@RequestBody User user , HttpSession session) {
			
			User loginUser = userDAO.validate(user.getUser_id(),user.getPassword());
			
			if (loginUser == null){
				loginUser = new User();
				loginUser.setErrorCode("404");
				loginUser.setErrorMessage("Invalid credentials . please enter valid credentials");
			}else{
				loginUser.setErrorCode("200");
				loginUser.setErrorMessage("You have successfully logged in");
				loginUser.setIsOnline('Y');
				
				session.setAttribute("loggedInUserID", user.getUser_id());
				session.setAttribute("loggedInUserRole", user.getRole());
				return new ResponseEntity<User>(user , HttpStatus.OK);
				}
			
			
		}
*/
	}

