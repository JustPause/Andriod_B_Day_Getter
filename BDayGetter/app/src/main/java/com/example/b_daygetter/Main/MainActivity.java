package com.example.b_daygetter.Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.b_daygetter.AddUsers.AddUsersActivoty;
import com.example.b_daygetter.Dao.MainDataBase;
import com.example.b_daygetter.Dao.Message;
import com.example.b_daygetter.Dao.SecondDataBase;
import com.example.b_daygetter.Dao.User;
import com.example.b_daygetter.Dao.UserDao;
import com.example.b_daygetter.ListUsers.ListUsers;
import com.example.b_daygetter.R;
import com.example.b_daygetter.SendEmailToTheUser.SendEmailToTheUser;

public class MainActivity extends AppCompatActivity {
	
	// TODO Add an feture that lets the youser get his one color, of core the data will be collected in the data base. On craision the user can have a random color and at any time he can chage it
	
	
	// TODO pakeisti dataBaseUserYear, dataBaseUserMonth, dataBaseUserDay i int
	
	UserDao userDao;
	User user = new User("", "", 0, 0, 0);
	Var var = new Var(user);
	int id = 2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		MainActivityAddingTempUser();
		
		user = userDao.getUser(id);
		var = new Var(user);
		
		user_name();
		date();
		init_Data_B_day_countdown();
		age_will_be();
	}
	
	void user_name() {
		TextView textView = findViewById(R.id.User_name);
		String outputString = user.getName() + " " + user.getSureName();
		textView.setText(outputString);
	}
	
	void date() {
		TextView textView = findViewById(R.id.Date);
		String outputString =
				user.getDateYear() + " " + user.getDateMonth() + " " + user.getDateDay();
		textView.setText(outputString);
	}
	
	void age_will_be() {
		TextView textView = findViewById(R.id.Age_will_be);
		textView.setText(String.valueOf(var.nowTimeYear - user.getDateYear()));
	}
	
	//////////////////////
	public void UpdateInt() {
		
		var.nowTimeYear = java.time.LocalDate.now().getYear();
		var.nowTimeMonth = java.time.LocalDate.now().getMonthValue();
		var.nowTimeDay = java.time.LocalDate.now().getDayOfMonth();
		var.bDayOf = java.time.LocalDate.of(user.getDateYear(),
						user.getDateMonth(),
						user.getDateDay())
				.getDayOfYear();
		var.todayDay = java.time.LocalDate.now().getDayOfYear();
		var.todayTimeH = java.time.LocalDateTime.now().getHour();
		var.todayTimeM = java.time.LocalDateTime.now().getMinute();
		var.todayTimeS = java.time.LocalDateTime.now().getSecond();
	}
	
	public String B_day_countdown(int i) {
		user = userDao.getUser(i);
		Var var = new Var(user);
		if (var.bDayOf - var.todayDay < 0) {
			return var.bDayOf + 365 - var.todayDay + " Days " + (24 - var.todayTimeH) +
				   " Hour\n " +
				   (60 - var.todayTimeM) + " Minute " + (60 - var.todayTimeS) +
				   " Second ";
		} else {
			return var.bDayOf - var.todayDay + " Days " + (24 - var.todayTimeH) + " Hour\n " +
				   (60 - var.todayTimeM) + " Minute " + (60 - var.todayTimeS) + " Second ";
		}
	}
	
	private void init_Data_B_day_countdown() {
		TextView textView = findViewById(R.id.B_day_countdown);
		
		textView.setText(B_day_countdown(1));
		
		
		Thread thread = new Thread(() -> {
			try {
				Thread.sleep(1000);
				runOnUiThread(() -> {
					UpdateInt();
					init_Data_B_day_countdown();
				});
			} catch (InterruptedException ignored) {
			}
		});
		
		thread.start();
	}
	
	//////////////////////
	
	public void MainActivityAddingTempUser() {
		userDao = MainDataBase.getInstance(getApplicationContext()).userDao();
		if (userDao.getAllUsers().isEmpty()) {
			userDao.insert(new User("Justinas", "Stankunas", 2003, 6, 6));
			userDao.insert(new User("Adomas", "Tankas", 1980, 7, 3));
			userDao.insert(new User("Vytautas", "Stalas", 2007, 3, 1));
			userDao.insert(new User("Mindaugas", "Varna", 2014, 6, 6));
			userDao.insert(new User("Armandas", "Robotas", 2000, 8, 9));
		}
		if (SecondDataBase.getInstance(getApplicationContext()).messageDao().getAllMessages().isEmpty()) {
			SecondDataBase.getInstance(getApplicationContext()).messageDao().insert(
					new Message(
							"IamJustStan@hotmail.com",
							"Happy birthday! Wishing you a day full of love, joy, and all your favorite things."
					)
			);
			
		}
	}
	
	public void MainActivityAddingJustinas() {
		userDao = MainDataBase.getInstance(getApplicationContext()).userDao();
		if (userDao.getAllUsers().isEmpty()) {
			userDao.insert(new User("Justinas", "Stankunas", 2003, 6, 6));
		}
		if (SecondDataBase.getInstance(getApplicationContext()).messageDao().getAllMessages().isEmpty()) {
			SecondDataBase.getInstance(getApplicationContext()).messageDao().insert(
					new Message(
							"IamJustStan@hotmail.com",
							"Happy birthday! Wishing you a day full of love, joy, and all your favorite things."
					)
			);
			
		}
	}
	
	
	public void add_users_button(View view) {
		
		Intent intent = new Intent(this, AddUsersActivoty.class);
		finish();
		startActivity(intent);
	}
	
	public void list_users_button(View view) {
		
		Intent intent = new Intent(this, ListUsers.class);
		finish();
		startActivity(intent);
	}
	
	public void send_email_to_the_user_button(View view) {
		
		Intent intent = new Intent(this, SendEmailToTheUser.class);
		finish();
		startActivity(intent);
	}
	
}


