package com.example.b_daygetter.ListUsers;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.example.b_daygetter.R;

import java.util.ArrayList;

public class ListUsers extends AppCompatActivity {
	
	//TODO Padaryti dinamiskai didejaenti arba mazejenti langeliu skaiciu
	//TODO Tie langeliai galetu veikti kaip miktukai
	
	GridView coursesGV;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_users);
		
		coursesGV = findViewById(R.id.idGVcourses);
		ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();
		
		courseModelArrayList.add(new CourseModel("DSA", R.drawable.ic_launcher_foreground));
		courseModelArrayList.add(new CourseModel("JAVA", R.drawable.ic_launcher_foreground));
		courseModelArrayList.add(new CourseModel("C++", R.drawable.ic_launcher_foreground));
		courseModelArrayList.add(new CourseModel("Python", R.drawable.ic_launcher_foreground));
		courseModelArrayList.add(new CourseModel("Javascript", R.drawable.ic_launcher_foreground));
		courseModelArrayList.add(new CourseModel("DSA", R.drawable.ic_launcher_foreground));
		
		CourseGVAdapter adapter = new CourseGVAdapter(this, courseModelArrayList);
		coursesGV.setAdapter(adapter);
	}
	
	//TODO idekti error atlaikimo systema
	public void runOnClic(View view) {
		view.setBackgroundColor(0xFF00FF00);
		//Pasirinkta informacija butu nusiunciama i main tenais putu pakeiciama i duota klacia
	}
}