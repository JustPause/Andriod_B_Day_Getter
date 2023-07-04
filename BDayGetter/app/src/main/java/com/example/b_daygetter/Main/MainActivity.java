package com.example.b_daygetter.Main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.b_daygetter.AddUsers.AddUsersActivoty;
import com.example.b_daygetter.Dao.MainDataBase;
import com.example.b_daygetter.Dao.User;
import com.example.b_daygetter.Dao.UserDao;
import com.example.b_daygetter.ListUsers.ListUsers;
import com.example.b_daygetter.R;
import com.example.b_daygetter.SendEmailToTheUser.SendEmailToTheUser;

public class MainActivity extends AppCompatActivity {
	
	// TODO Add an feture that lets the youser get his one color, of core the data will be collected in the data base. On craision the user can have a random color and at any time he can chage it
	
	// Link https://stackoverflow.com/questions/20715503/get-result-from-activity-called-wi>
	// Link https://developer.android.com/training/basics/intents/result
	
	// TODO pakeisti dataBaseUserYear, dataBaseUserMonth, dataBaseUserDay i int
	
	// Form Data Base i get one objcet Users
	
	UserDao userDao;
	User user = new User("Justinas", "Stankunas", 2003, 6, 6);
	Var var = new Var(user);
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		userDao = MainDataBase.getInstance(getApplicationContext()).userDao();
		if (userDao.getAllUser().isEmpty()) {
			userDao.insert(new User("Justinas", "Stankunas", 2003, 6, 6));
		}

//		User user1 = new User("Justinas", "Stankunas", 2003, 6, 6);
		user = userDao.getUser(1);
		var = new Var(user);
		
		Log.d("12345", String.valueOf(user.getDateDay()));
		
		User_name();
		date();
		init_Data_B_day_countdown();
		age_will_be();
	}
	
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
	
	@SuppressLint("SetTextI18n")
	
	public String geter_init_Data_B_day_countdown() {
		//TODO Make it static
		return var.bDayOf + 365 - var.todayDay + " Days " + (24 - var.todayTimeH) + " Hour\n " +
			   (60 - var.todayTimeM) + " Minute " + (60 - var.todayTimeS) + " Second ";
	}
	
	public String B_day_countdown() {
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
	
	@SuppressLint("SetTextI18n")
	private void init_Data_B_day_countdown() {
		TextView textView = findViewById(R.id.B_day_countdown);
		
		//		Log.d("Debug1", nowTimeYear + " " + nowTimeMonth + " " + nowTimeDay);
		//		Log.d("Debug1", dataBaseUserYear + " " + dataBaseUserMonth + " " + dataBaseUserDay);
		
		
		textView.setText(B_day_countdown());
		
		
		Thread thread = new Thread() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							UpdateInt();
							init_Data_B_day_countdown();
						}
					});
				} catch (InterruptedException e) {
				}
			}
		};
		
		thread.start();
		
	}
	
	@SuppressLint("SetTextI18n")
	protected void User_name() {
		TextView textView = findViewById(R.id.User_name);
		textView.setText(user.getName() + " " + user.getSureName());
	}
	
	@SuppressLint("SetTextI18n")
	protected void date() {
		TextView textView = findViewById(R.id.Date);
		textView.setText(user.getDateYear() + " " + user.getDateMonth() + " " + user.getDateDay());
	}
	
	@SuppressLint("SetTextI18n")
	protected void age_will_be() {
		TextView textView = findViewById(R.id.Age_will_be);
		textView.setText("21");
	}
	
	public void add_users_button(View view) {
		
		Intent intent = new Intent(this, AddUsersActivoty.class);
		startActivity(intent);
	}
	//////////////////////////////
	
	public void list_users_button(View view) {
		
		Intent intent = new Intent(this, ListUsers.class);
		startActivity(intent);
	}
	
	public void send_email_to_the_user_button(View view) {
		
		Intent intent = new Intent(this, SendEmailToTheUser.class);
		startActivity(intent);
	}
	
	//////////////////////////////
}


