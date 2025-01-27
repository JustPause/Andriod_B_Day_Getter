package com.example.b_daygetter.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Query("SELECT * FROM users ORDER BY b_day_month, b_day_day")
    List<User> getAllUsers();

    @Query("SELECT * FROM users WHERE id=:id")
    User getUser(int id);
}
