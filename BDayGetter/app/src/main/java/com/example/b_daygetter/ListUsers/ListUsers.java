package com.example.b_daygetter.ListUsers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

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
		
		List<User> allUser = userDao.getAllUser();
		
		coursesGV = findViewById(R.id.idGVcourses);
//		ArrayList<ListUsersModel> listUsersModelArrayList = new ArrayList<>();

//		listUsersModelArrayList.addAll(allUser);
//		for (int i = 0; i < AllUser.size(); i++) {
//
//			addUserMetod(AllUser, listUsersModelArrayList, i);
//
//		}

//		ListUsersAdapter adapter = new ListUsersAdapter(this, listUsersModelArrayList);
		ListUsersAdapter adapter = new ListUsersAdapter(this, allUser);
		
		coursesGV.setAdapter(adapter);
	}
	
	//TODO idekti error atlaikimo systema
	public void runOnClic(View view) {
		view.setBackgroundColor(0xffff8c00);
		//TODO Pasirinkta informacija butu nusiunciama i main tenais putu pakeiciama i duota klacia

//		view.getId();
//
		TextView textView = findViewById(R.id.Id);
		textView.getText();
		
		// as noriu kad parasytas id butu israsomas i main lapa
		
		//TODO as tureciau gauti data base id
		Log.d("TheIdProblemSolving-getTexxt", String.valueOf(textView.getText()));
		
		Intent intent = new Intent(this, MainActivity.class);
		finish();
		startActivity(intent);
	}
	
	void addUserMetod(List<User> AllUser, ArrayList<ListUsersModel> listUsersModelArrayList, int i) {
		listUsersModelArrayList.add(
				new ListUsersModel(
						(AllUser.get(i).getName() + " " +
						 AllUser.get(i).getSureName()),
						mainActivity.B_day_countdown(1),
						"Amžius bus " +
						(java.time.LocalDate.now().getYear() - AllUser.get(i).getDateYear()),
						String.valueOf(AllUser.get(i).getId())));
	}
	
	public void delete_Button_ListUsers(View view) {
		userDao.deleteAllUsers();
		
		Intent intent = getIntent();
		finish();
		startActivity(intent);
	}
}