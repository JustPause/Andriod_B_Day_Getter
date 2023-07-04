package com.example.b_daygetter.Main;

import com.example.b_daygetter.Dao.User;

public class Var {
	public int nowTimeYear = java.time.LocalDate.now().getYear();
	public int nowTimeMonth = java.time.LocalDate.now().getMonthValue();
	public int nowTimeDay = java.time.LocalDate.now().getDayOfMonth();
	public int todayDay = java.time.LocalDate.now().getDayOfYear();
	public int todayTimeH = java.time.LocalDateTime.now().getHour();
	public int todayTimeM = java.time.LocalDateTime.now().getMinute();
	public int todayTimeS = java.time.LocalDateTime.now().getSecond();
	User user = new User("Justinas", "Stankunas", 2003, 6, 6);
	public int bDayOf = java.time.LocalDate.of(user.getDateYear(), user.getDateMonth(), user.getDateDay()).getDayOfYear();
	
	public Var(User user) {
		this.user = user;
	}
	
	
}
