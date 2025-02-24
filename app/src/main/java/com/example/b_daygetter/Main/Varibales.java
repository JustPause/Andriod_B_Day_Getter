package com.example.b_daygetter.Main;

import com.example.b_daygetter.Dao.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Varibales {
    public static int year,
            month,
            dayOfMonth,
            dayOfYear,
            hour,
            minute,
            second,
            bDayOf;

    public static void Updater() {
        LocalDate localTime = LocalDate.now();
        LocalDateTime localDateTime = java.time.LocalDateTime.now();

        year = localTime.getYear(); // 2025
        month = localTime.getMonthValue(); // 1
        dayOfMonth = localTime.getDayOfMonth(); // 27
        dayOfYear = localTime.getDayOfYear(); // 27

        hour = localDateTime.getHour(); // 7
        minute = localDateTime.getMinute(); // 34
        second = localDateTime.getSecond(); // 53
    }

    public static void make_birthday_of_the_personal(User user) {
        Updater();

        bDayOf = java.time.LocalDate.of(
                user.getDateYear(),
                user.getDateMonth(),
                user.getDateDay()
        ).getDayOfYear();
    }
}
