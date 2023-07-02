package com.example.b_daygetter.ListUsers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.example.b_daygetter.Main.Users;
import com.example.b_daygetter.R;

import java.util.ArrayList;

public class ListUsers extends AppCompatActivity {
	
	//TODO Padaryti dinamiskai didejaenti arba mazejenti langeliu skaiciu
	//TODO Tie langeliai galetu veikti kaip miktukai
	
	GridView coursesGV;
	
	Users users1 = new Users("Justinas", "Stankunas", "2003", "6", "6");
	Users users2 = new Users("Adomas", "Akmenukas", "1922", "8", "9");
	Users users3 = new Users("Vytautas", "Mazasis", "2022", "5", "12");
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_users);
		
		coursesGV = findViewById(R.id.idGVcourses);
		ArrayList<ListUsersModel> listUsersModelArrayList = new ArrayList<ListUsersModel>();
		
		listUsersModelArrayList.add(new ListUsersModel(
				(users1.UserName + " " + users1.UserSurName),
				String.valueOf
						(
								java.time.LocalDate.now().getYear() -
								Integer.parseInt(users1.UserYear)
						),
				String.valueOf(java.time.LocalDate.now().getYear() -
							   Integer.parseInt(users1.UserYear)
				)
		));
		
		listUsersModelArrayList.add(new ListUsersModel((users2.UserName + " " + users2.UserSurName),
				String.valueOf
						(
								java.time.LocalDate.now().getYear() -
								Integer.parseInt(users2.UserYear)
						),
				String.valueOf(java.time.LocalDate.now().getYear() -
							   Integer.parseInt(users2.UserYear)
				)
		));
		
		listUsersModelArrayList.add(new ListUsersModel((users3.UserName + " " + users3.UserSurName),
				String.valueOf
						(
								java.time.LocalDate.now().getYear() -
								Integer.parseInt(users3.UserYear)
						),
				String.valueOf(java.time.LocalDate.now().getYear() -
							   Integer.parseInt(users3.UserYear)
				)
		));
		
		ListUsersAdapter adapter = new ListUsersAdapter(this, listUsersModelArrayList);
		coursesGV.setAdapter(adapter);
	}
	
	//TODO idekti error atlaikimo systema
	public void runOnClic(View view) {
		view.setBackgroundColor(0xFF00FF00);
		//Pasirinkta informacija butu nusiunciama i main tenais putu pakeiciama i duota klacia
	}
}