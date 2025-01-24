package com.example.b_daygetter.AddUsers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.b_daygetter.Dao.Message;
import com.example.b_daygetter.Dao.MessageDao;
import com.example.b_daygetter.Dao.SecondDataBase;
import com.example.b_daygetter.Main.MainActivity;
import com.example.b_daygetter.R;

public class AddMessage extends AppCompatActivity {

	MessageDao messageDao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = new Intent(this, MainActivity.class);
		finish();
		startActivity(intent);

		messageDao = SecondDataBase.getInstance(getApplicationContext()).messageDao();
	}
}