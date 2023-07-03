package com.example.b_daygetter.Main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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
	
	public int nowTimeYear = java.time.LocalDate.now().getYear();
	public int nowTimeMonth = java.time.LocalDate.now().getMonthValue();
	// TODO Add an feture that lets the youser get his one color, of core the data will be collected in the data base. On craision the user can have a random color and at any time he can chage it
	
	// Link https://stackoverflow.com/questions/20715503/get-result-from-activity-called-wi>
	// Link https://developer.android.com/training/basics/intents/result
	
	// TODO pakeisti dataBaseUserYear, dataBaseUserMonth, dataBaseUserDay i int
	
	// Form Data Base i get one objcet Users
	public int nowTimeDay = java.time.LocalDate.now().getDayOfMonth();
	// TODO Pakeisti java.time.LocalDate.now()
	public int todayDay = java.time.LocalDate.now().getDayOfYear();
	public int todayTimeH = java.time.LocalDateTime.now().getHour();
	public int todayTimeM = java.time.LocalDateTime.now().getMinute();
	public int todayTimeS = java.time.LocalDateTime.now().getSecond();
	UserDao userDao;
	Users user = new Users("Justinas", "Stankunas", 2003, 6, 6);
	public int bDayOf = java.time.LocalDate.of(user.UserYear, user.UserMonth, user.UserDay).getDayOfYear();
	
	void UpdateInt() {
		
		
		nowTimeYear = java.time.LocalDate.now().getYear();
		nowTimeMonth = java.time.LocalDate.now().getMonthValue();
		nowTimeDay = java.time.LocalDate.now().getDayOfMonth();
		bDayOf = java.time.LocalDate.of(user.UserYear,
						user.UserMonth,
						user.UserDay)
				.getDayOfYear();
		todayDay = java.time.LocalDate.now().getDayOfYear();
		todayTimeH = java.time.LocalDateTime.now().getHour();
		todayTimeM = java.time.LocalDateTime.now().getMinute();
		todayTimeS = java.time.LocalDateTime.now().getSecond();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		userDao = MainDataBase.getInstance(getApplicationContext()).userDao();
//		if (userDao.getAllUser().isEmpty()) {
//			userDao.insert(new User("Justinas", "Stankunas", 2003, 6, 6));
//		}
		User_name();
		date();
		init_Data_B_day_countdown();
		age_will_be();
	}
	
	@SuppressLint("SetTextI18n")
	
	public String geter_init_Data_B_day_countdown() {
		//TODO Make it static
		return bDayOf + 365 - todayDay + " Days " + (24 - todayTimeH) + " Hour\n " +
			   (60 - todayTimeM) + " Minute " + (60 - todayTimeS) + " Second ";
	}
	
	@SuppressLint("SetTextI18n")
	private void init_Data_B_day_countdown() {
		TextView textView = findViewById(R.id.B_day_countdown);
		
		//		Log.d("Debug1", nowTimeYear + " " + nowTimeMonth + " " + nowTimeDay);
		//		Log.d("Debug1", dataBaseUserYear + " " + dataBaseUserMonth + " " + dataBaseUserDay);
		
		if (bDayOf - todayDay < 0) {
			textView.setText(bDayOf + 365 - todayDay + " Days " + (24 - todayTimeH) + " Hour\n " +
							 (60 - todayTimeM) + " Minute " + (60 - todayTimeS) + " Second ");
		} else {
			textView.setText(bDayOf - todayDay + " Days " + (24 - todayTimeH) + " Hour\n " +
							 (60 - todayTimeM) + " Minute " + (60 - todayTimeS) + " Second ");
		}
		
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
		textView.setText(user.UserName + " " + user.UserSurName);
	}
	
	@SuppressLint("SetTextI18n")
	protected void date() {
		TextView textView = findViewById(R.id.Date);
		textView.setText(user.UserYear + " " + user.UserMonth + " " + user.UserDay);
	}
	
	@SuppressLint("SetTextI18n")
	protected void age_will_be() {
		TextView textView = findViewById(R.id.Age_will_be);
		textView.setText("21");
	}
	//////////////////////////////
	
	public void add_users_button(View view) {
		
		Intent intent = new Intent(this, AddUsersActivoty.class);
		startActivity(intent);
	}
	
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


