package com.niit.collaboration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {

	@Id
	private int id;
	
	private String name;
	
	private String password;
	
	private String role;
	
	private String contact;
	
}
