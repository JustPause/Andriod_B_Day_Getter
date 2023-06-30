package com.example.b_daygetter;

import androidx.room.PrimaryKey;

public class DataBase
{
  @PrimaryKey(autoGenerate = true) int id;
  String FirstName, LastName, b_Year, b_Month, b_Day;

}
