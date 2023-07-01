package com.example.b_daygetter.Main;

public class Users {
	public String UserName;
	public String UserSurName;
	public String UserYear;
	public String UserMonth;
	public String UserDay;
	
	public Users(String userName, String userSurName, String userYear, String userMonth, String userDay) {
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
	
	public String getUserYear() {
		return UserYear;
	}
	
	public void setUserYear(String userYear) {
		UserYear = userYear;
	}
	
	public String getUserMonth() {
		return UserMonth;
	}
	
	public void setUserMonth(String userMonth) {
		UserMonth = userMonth;
	}
	
	public String getUserDay() {
		return UserDay;
	}
	
	public void setUserDay(String userDay) {
		UserDay = userDay;
	}
}
