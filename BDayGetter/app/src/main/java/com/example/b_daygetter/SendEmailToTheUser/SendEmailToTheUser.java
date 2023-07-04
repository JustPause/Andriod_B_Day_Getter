package com.example.b_daygetter.SendEmailToTheUser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.b_daygetter.Dao.MainDataBase;
import com.example.b_daygetter.Dao.Message;
import com.example.b_daygetter.Dao.MessageDao;
import com.example.b_daygetter.Dao.SecondDataBase;
import com.example.b_daygetter.R;

public class SendEmailToTheUser extends AppCompatActivity {
	
	MessageDao messageDao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_email_to_the_user);
		
		messageDao = SecondDataBase.getInstance(getApplicationContext()).messageDao();
		
		sendEmail(1);
	}
	
	
	protected void sendEmail(int id) {
//		String email = messageDao.getMessage(id).getEmail();
//		String message = messageDao.getMessage(id).getMessage();
		
		String email = "Emial@email.com";
		String message = "email email emal email";
		
		Log.i("Send email", "Justinas");
		
		String[] TO = {email};
		String[] CC = {"xyz@gmail.com"};
		Intent emailIntent = new Intent(Intent.ACTION_SEND);
		emailIntent.setData(Uri.parse("mailto:"));
		emailIntent.setType("text/plain");
		
		
		emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
		emailIntent.putExtra(Intent.EXTRA_CC, CC);
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Happy Birthday, \"User Name goes hare\"");
		emailIntent.putExtra(Intent.EXTRA_TEXT,
				"Happy Birthday to you\nand the message is " +
				message);
		
		try {
			startActivity(Intent.createChooser(emailIntent, "Send mail..."));
			finish();
			Log.i("Finished sending email...", "");
		} catch (android.content.ActivityNotFoundException ex) {
			Toast.makeText(SendEmailToTheUser.this,
					"There is no email client installed.", Toast.LENGTH_SHORT).show();
		}
	}
	
}