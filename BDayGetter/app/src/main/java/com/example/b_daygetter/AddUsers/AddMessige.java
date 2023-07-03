package com.example.b_daygetter.AddUsers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.b_daygetter.Dao.MainDataBase;
import com.example.b_daygetter.Dao.Message;
import com.example.b_daygetter.Dao.MessageDao;
import com.example.b_daygetter.Dao.SecondDataBase;
import com.example.b_daygetter.Dao.User;
import com.example.b_daygetter.Main.MainActivity;
import com.example.b_daygetter.R;

import java.time.LocalDate;

public class AddMessige extends AppCompatActivity {
	
	MessageDao messageDao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_messige);
		
		messageDao = SecondDataBase.getInstance(getApplicationContext()).messageDao();
	}
	
	public void submit_Button_Return_To_Main(View view) {
		EditText personEmail = (EditText) findViewById(R.id.Person_Email);
		EditText personMessage = (EditText) findViewById(R.id.Person_Message);
		
		Message message = new Message(
//				personEmail.getText().toString(),
//				personMessage.getText().toString()
				"A", "B"
		);
		
		Log.d("getText",
				message.getEmail().toString() + " | " + message.getMessage().toString());
		
		messageDao.insert(message);
		
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}