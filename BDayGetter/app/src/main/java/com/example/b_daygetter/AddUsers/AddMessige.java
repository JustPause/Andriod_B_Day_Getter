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

public class AddMessige extends AppCompatActivity {

	MessageDao messageDao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_messige);

		messageDao = SecondDataBase.getInstance(getApplicationContext()).messageDao();
	}

	public void submit_Button_Return_To_Main(View view) {
		EditText personEmail = findViewById(R.id.Person_Email);
		EditText personMessage = findViewById(R.id.Person_Message);

		Message message = new Message(
				personEmail.getText().toString(),
				personMessage.getText().toString()
		);

		messageDao.insert(message);

		Intent intent = new Intent(this, MainActivity.class);
		finish();
		startActivity(intent);
	}
}