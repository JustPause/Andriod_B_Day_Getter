package com.example.b_daygetter.AddUsers;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.b_daygetter.Dao.MainDataBase;
import com.example.b_daygetter.Dao.User;
import com.example.b_daygetter.Dao.UserDao;
import com.example.b_daygetter.R;

import java.time.LocalDate;

public class AddUsersActivoty extends AppCompatActivity {
	UserDao userDao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_users_activoty);
		
		userDao = MainDataBase.getInstance(getApplicationContext()).userDao();
	}
	
	public void submit_Button_Add_Users_Adtivoty(View view) {
		EditText personName = (EditText) findViewById(R.id.Person_Name);
		EditText personDate = (EditText) findViewById(R.id.Person_Date);
		
		String[] words = personName.getText().toString().split(" ");
		
		String userName = words[0];
		String userSureName = words[1];
		LocalDate bLocalDate = LocalDate.parse(personDate.getText());
		
		User user = new User(userName, userSureName, bLocalDate.getYear(), bLocalDate.getMonthValue(),
				bLocalDate.getDayOfMonth()
		);
		
		Log.d("getText",
				user.getName() + " " + user.getSureName() + " " + user.getDateMonth() + " " +
				user.getDateMonth() + " " + user.getDateDay()
		);
		
		userDao.insert(user);
		
		Intent intent = new Intent(this, AddMessige.class);
		startActivity(intent);
	}
}