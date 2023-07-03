package com.example.b_daygetter.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MessageDao {
	
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	void insert(Message message);
	
	@Delete
	void delete(Message message);
	
	@Query("DELETE FROM messages")
	void deleteAllUsers();
	
	@Query("SELECT * FROM messages ORDER BY Email DESC")
	List<User> getAllUser();
	
	@Query("SELECT * FROM messages WHERE id =:id")
	User getUser(int id);
}
