package com.example.b_daygetter.ListUsers;

import android.widget.TextView;

import com.example.b_daygetter.Dao.MessageDao;
import com.example.b_daygetter.Dao.SecondDataBase;
import com.example.b_daygetter.Main.MainActivity;
import com.example.b_daygetter.R;

public class ListUsersModel {
	
	// string course_name for storing course_name
	// and imgid for storing image id.
	private String course_name;
	private String NameAndSureName;
	private String CoundDown;
	private String Age;
	
	public ListUsersModel(String nameAndSureName, String coundDown, String age) {
		this.NameAndSureName = nameAndSureName;
		this.CoundDown = new MainActivity().geter_init_Data_B_day_countdown();
		this.Age = age;
	}
	
	public ListUsersModel(String course_name) {
		this.course_name = course_name;
	}
	
	public String getCourse_name() {
		return course_name;
	}
	
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	
	public String getNameAndSureName() {
		return NameAndSureName;
	}
	
	public String getCoundDown() {
		return CoundDown;
	}
	
	public String getAge() {
		return Age;
	}
	
}
