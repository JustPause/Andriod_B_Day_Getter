package com.example.b_daygetter.Dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Message.class}, version = 2)
public abstract class SecondDataBase extends RoomDatabase {
	private static SecondDataBase instance;
	
	public static synchronized SecondDataBase getInstance(Context context) {
		if (instance == null) {
			instance = Room.databaseBuilder(context, SecondDataBase.class,
					"database").fallbackToDestructiveMigration().allowMainThreadQueries().build();
		}
		return instance;
	}
	
	public abstract MessageDao messageDao();
}
