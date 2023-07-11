package com.example.b_daygetter.Main;

import android.widget.TextView;

import com.example.b_daygetter.R;

public class User_data {
	void user_name(MainActivity mainActivity) {
		TextView textView = mainActivity.findViewById(R.id.User_name);
		String outputString = mainActivity.user.getName() + " " + mainActivity.user.getSureName();
		textView.setText(outputString);
	}
	
	void date(MainActivity mainActivity) {
		TextView textView = mainActivity.findViewById(R.id.Date);
		String outputString =
				mainActivity.user.getDateYear() + " " + mainActivity.user.getDateMonth() + " " +
				mainActivity.user.getDateDay();
		textView.setText(outputString);
	}
	
	void age_will_be(MainActivity mainActivity) {
		TextView textView = mainActivity.findViewById(R.id.Age_will_be);
		textView.setText(String.valueOf(
				mainActivity.var.nowTimeYear - mainActivity.user.getDateYear()));
	}
}

