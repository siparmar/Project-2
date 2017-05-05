package com.niit.collaboration.dao;

import java.util.List;
import com.niit.collaboration.model.User;

public interface UserDAO {

	public List<User> list();
	
	public User save(User user);

	public boolean update(User user);
	
	public boolean delete(User user);
	
	public User getUserById(int user_id);
	

	// If you are not using spring security
	public boolean validate(int user_id, String password);

	


}
