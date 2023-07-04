package com.example.b_daygetter.ListUsers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.example.b_daygetter.Dao.MainDataBase;
import com.example.b_daygetter.Dao.User;
import com.example.b_daygetter.Dao.UserDao;
import com.example.b_daygetter.Main.MainActivity;
import com.example.b_daygetter.R;

import java.util.ArrayList;
import java.util.List;

public class ListUsers extends AppCompatActivity {
	
	//TODO Padaryti dinamiskai didejaenti arba mazejenti langeliu skaiciu
	//TODO Tie langeliai galetu veikti kaip miktukai
	
	GridView coursesGV;
	UserDao userDao;
	MainActivity mainActivity = new MainActivity();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_users);
		
		userDao = MainDataBase.getInstance(getApplicationContext()).userDao();
		
		List<User> AllUser = userDao.getAllUser();
		
		coursesGV = findViewById(R.id.idGVcourses);
		ArrayList<ListUsersModel> listUsersModelArrayList = new ArrayList<ListUsersModel>();
		
		for (int i = 0; i < AllUser.size(); i++) {
			Log.d("Log", String.valueOf(AllUser.size()));
			
			listUsersModelArrayList.add(
					new ListUsersModel(
							(AllUser.get(i).getName() + " " +
							 AllUser.get(i).getSureName()),
							mainActivity.B_day_countdown(),
							"Amžius bus " + String.valueOf(
									java.time.LocalDate.now().getYear() -
									AllUser.get(i).getDateYear()),
							String.valueOf(AllUser.get(i).getId())));
		}
		
		ListUsersAdapter adapter = new ListUsersAdapter(this, listUsersModelArrayList);
		coursesGV.setAdapter(adapter);
	}
	
	//TODO idekti error atlaikimo systema
	public void runOnClic(View view) {
//		view.setBackgroundColor(0xFF00FF00);
		//TODO Pasirinkta informacija butu nusiunciama i main tenais putu pakeiciama i duota klacia
		Log.d("12345", String.valueOf(view.getId()));
		
		Intent intent = new Intent(this, MainActivity.class);
		finish();
		startActivity(intent);
	}
	
	public void delete_Button_ListUsers(View view) {
		userDao.deleteAllUsers();
		
		Intent intent = getIntent();
		finish();
		startActivity(intent);
	}
}