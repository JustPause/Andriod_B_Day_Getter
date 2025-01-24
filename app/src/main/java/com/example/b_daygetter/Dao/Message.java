package com.example.b_daygetter.Dao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "messages")
public class Message {

	@ColumnInfo(name = "email")
	private final String email;
	@ColumnInfo(name = "message")
	private final String message;
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "id")
	private int id;
	
	public Message(String email, String message) {
		this.email = email;
		this.message = message;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getMessage() {
		return message;
	}
}

