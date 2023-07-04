package com.example.b_daygetter.ListUsers;

import android.widget.TextView;

import com.example.b_daygetter.Dao.MessageDao;
import com.example.b_daygetter.Dao.SecondDataBase;
import com.example.b_daygetter.Main.MainActivity;
import com.example.b_daygetter.R;

public class ListUsersModel {
	
	// string course_name for storing course_name
	// and imgid for storing image id.
	private String NameAndSureName;
	private String CoundDown;
	private String Age;
	private String Id;
	
	
	public ListUsersModel(String nameAndSureName, String coundDown, String age, String id) {
		NameAndSureName = nameAndSureName;
		CoundDown = coundDown;
		Age = age;
		Id = id;
	}
	
	public String getNameAndSureName() {
		return NameAndSureName;
	}
	
	public void setNameAndSureName(String nameAndSureName) {
		NameAndSureName = nameAndSureName;
	}
	
	public String getCoundDown() {
		return CoundDown;
	}
	
	public void setCoundDown(String coundDown) {
		CoundDown = coundDown;
	}
	
	public String getAge() {
		return Age;
	}
	
	public void setAge(String age) {
		Age = age;
	}
	
	public String getId() {
		return Id;
	}
	
	public void setId(String id) {
		Id = id;
	}
	
	//	-------------------------------------------
//	public ListUsersModel(String nameAndSureName, String coundDown, String age) {
//		this.NameAndSureName = nameAndSureName;
//		this.CoundDown = new MainActivity().geter_init_Data_B_day_countdown();
//		this.Age = age;
//	}
//
//	public ListUsersModel(String course_name) {
//		this.course_name = course_name;
//	}
//
//	public String getCourse_name() {
//		return course_name;
//	}
//
//	public void setCourse_name(String course_name) {
//		this.course_name = course_name;
//	}
//
//	public String getNameAndSureName() {
//		return NameAndSureName;
//	}
//
//	public String getCoundDown() {
//		return CoundDown;
//	}
//
//	public String getAge() {
//		return Age;
//	}
//
}
