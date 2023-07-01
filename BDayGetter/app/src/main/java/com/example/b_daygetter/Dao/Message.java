package com.example.b_daygetter.Dao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "messages")
public class Message {
	//TODO Padaryti Email, Messige DataBase.
	//TODO Kartu jei zomgus parasota ta paty email - messige priskiria prie to email naudotoko
	//TODO Jei meilo nera tai ir parasyti
	
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "id")
	private int id;
	@ColumnInfo(name = "email")
	private String email;
	@ColumnInfo(name = "message")
	private String message;
	
	@Ignore
	public Message(int id, String email, String message) {
		this.id = id;
		this.email = email;
		this.message = message;
	}
	
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
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}

