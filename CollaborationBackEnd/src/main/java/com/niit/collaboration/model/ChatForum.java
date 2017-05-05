package com.niit.collaboration.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "chat_forum")
@Component
public class ChatForum extends BaseDomain{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int chat_forum_id;
	
	/*@ManyToOne
	private String userId;
*/
	private String message;

	private Date createdDate;
	
	
	
	//getters and setters
	
	public int getChat_forum_id() {
		return chat_forum_id;
	}

	public void setChat_forum_id(int chat_forum_id) {
		this.chat_forum_id = chat_forum_id;
	}

	/*public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}*/

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
