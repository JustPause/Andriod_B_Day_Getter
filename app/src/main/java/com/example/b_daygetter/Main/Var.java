package com.example.b_daygetter.Main;

import com.example.b_daygetter.Dao.User;

public class Var {
	
	public static int nowTimeYear;
	public static int nowTimeMonth;
	public static int nowTimeDay;
	public static int todayDay;
	public static int todayTimeH;
	public static int todayTimeM;
	public static int todayTimeS;
	public static int bDayOf;
	
	public static void Updater() {
		nowTimeYear = java.time.LocalDate.now().getYear();
		nowTimeMonth = java.time.LocalDate.now().getMonthValue();
		nowTimeDay = java.time.LocalDate.now().getDayOfMonth();
		todayDay = java.time.LocalDate.now().getDayOfYear();
		todayTimeH = java.time.LocalDateTime.now().getHour();
		todayTimeM = java.time.LocalDateTime.now().getMinute();
		todayTimeS = java.time.LocalDateTime.now().getSecond();
	}
	
	public static void GenBDayOf(User user) {
		Updater();
		bDayOf = java.time.LocalDate.of(user.getDateYear(), user.getDateMonth(), user.getDateDay()).getDayOfYear();
	}
}
