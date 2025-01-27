package com.example.b_daygetter.ListUsers;

public class ListUsersModel {
	
	// string course_name for storing course_name
	// and imgid for storing image id.
	private String NameAndSureName;
	private String CoundDown;
	private String Age;
	private String GimimoData;
	private String Id;
	
	
	public ListUsersModel(String nameAndSureName, String gimimoData, String coundDown, String age, String id) {
		NameAndSureName = nameAndSureName;
		GimimoData = gimimoData;
		CoundDown = coundDown;
		Age = age;
		Id = id;
	}
	
	public String getGimimoData() { return GimimoData; }
	
	public void setGimimoData(String gimimoData) { GimimoData = gimimoData; }
	
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
}
