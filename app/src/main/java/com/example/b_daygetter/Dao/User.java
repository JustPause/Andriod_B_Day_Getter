package com.example.b_daygetter.Dao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "sureName")
    private String sureName;
    @ColumnInfo(name = "b_day_year")
    private Integer dateYear;
    @ColumnInfo(name = "b_day_month")
    private Integer dateMonth;
    @ColumnInfo(name = "b_day_day")
    private Integer dateDay;

    public User(String name, String sureName, Integer dateYear, Integer dateMonth, Integer dateDay) {
        this.name = name;
        this.sureName = sureName;
        this.dateYear = dateYear;
        this.dateMonth = dateMonth;
        this.dateDay = dateDay;
    }

//    @Ignore
//    public User(int id, String name, String sureName, Integer dateYear, Integer dateMonth, Integer dateDay) {
//        this.id = id;
//        this.name = name;
//        this.sureName = sureName;
//        this.dateYear = dateYear;
//        this.dateMonth = dateMonth;
//        this.dateDay = dateDay;
//    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }

    public String getName() { return name; }
    public String getSureName() { return sureName; }
    public Integer getDateYear() { return dateYear; }
    public Integer getDateMonth() { return dateMonth; }
    public Integer getDateDay() { return dateDay; }
}
