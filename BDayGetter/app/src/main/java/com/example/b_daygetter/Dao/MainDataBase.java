package com.example.b_daygetter.Dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class MainDataBase extends RoomDatabase
{
  private static MainDataBase instance;

  public static synchronized MainDataBase getInstance(Context context)
  {
    if (instance == null)
    {
      instance = Room.databaseBuilder(context, MainDataBase.class,
          "database").fallbackToDestructiveMigration().allowMainThreadQueries().build();
    }
    return instance;
  }

  public abstract UserDao userDao();
}
