package com.example.b_daygetter.Main;

import android.widget.TextView;

import com.example.b_daygetter.R;

public class DateData {
	private final MainActivity mainActivity;
	
	public DateData(MainActivity mainActivity) { this.mainActivity = mainActivity; }
	
	void date() {
		TextView textView = mainActivity.findViewById(R.id.Date);
		String outputString =
				mainActivity.getUser().getDateYear() + " " + mainActivity.getUser().getDateMonth() +
				" " + mainActivity.getUser().getDateDay();
		textView.setText(outputString);
	}
}