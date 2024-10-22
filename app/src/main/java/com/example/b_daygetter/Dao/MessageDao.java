package com.example.b_daygetter.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MessageDao {
	
	@Insert
	void insert(Message message);
	
	@Delete
	void delete(Message message);
	
	@Query("DELETE FROM messages")
	void deleteAllUsers();
	
	@Query("SELECT * FROM messages ORDER BY Email DESC")
	List<Message> getAllMessages();
	
	@Query("SELECT * FROM messages WHERE :id")
	Message getMessage(int id);
}
