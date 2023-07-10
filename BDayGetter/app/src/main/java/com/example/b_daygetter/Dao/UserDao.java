package com.example.b_daygetter.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
	
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	void insert(User user);
	
	@Delete
	void delete(User user);
	
	@Query("DELETE FROM users")
	void deleteAllUsers();
	
	@Query("SELECT * FROM users")
	List<User> getAllUsers();
	
	@Query("SELECT * FROM users WHERE :id")
	User getUser(int id);
}
