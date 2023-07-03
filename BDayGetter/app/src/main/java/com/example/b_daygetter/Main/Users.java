package com.example.b_daygetter.Main;

public class Users {
	public String UserName;
	public String UserSurName;
	public int UserYear;
	public int UserMonth;
	public int UserDay;
	
	public Users(String userName, String userSurName, int userYear, int userMonth, int userDay) {
		UserName = userName;
		UserSurName = userSurName;
		UserYear = userYear;
		UserMonth = userMonth;
		UserDay = userDay;
	}
	
	public String getUserName() {
		return UserName;
	}
	
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	public String getUserSurName() {
		return UserSurName;
	}
	
	public void setUserSurName(String userSurName) {
		UserSurName = userSurName;
	}
}
