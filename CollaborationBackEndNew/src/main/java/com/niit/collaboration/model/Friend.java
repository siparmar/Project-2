package com.niit.collaboration.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "friend")
@Component
public class Friend {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int friend_id;

	private String status; // new , accepted , rejected

	private char isOnline;

	private Date lastSeenTime;

	
	//getters and setters
	
	public int getFriend_id() {
		return friend_id;
	}

	public void setFriend_id(int friend_id) {
		this.friend_id = friend_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public char getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(char isOnline) {
		this.isOnline = isOnline;
	}

	public Date getLastSeenTime() {
		return lastSeenTime;
	}

	public void setLastSeenTime(Date lastSeenTime) {
		this.lastSeenTime = lastSeenTime;
	}

}
