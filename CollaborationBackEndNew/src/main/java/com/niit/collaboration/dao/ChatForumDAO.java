package com.niit.collaboration.dao;

import java.util.List;
import com.niit.collaboration.model.ChatForum;

public interface ChatForumDAO {

	public List<ChatForum> list();

	public boolean save(ChatForum chatForum);
	
	public boolean update(ChatForum chatForum);
	
	public boolean delete(ChatForum chatForum);
	
	public ChatForum getChatForumById(int chat_forum_id);
	
}
