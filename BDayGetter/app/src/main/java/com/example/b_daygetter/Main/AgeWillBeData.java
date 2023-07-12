package com.example.b_daygetter.Main;

import android.widget.TextView;

import com.example.b_daygetter.R;

public class AgeWillBeData {
	private final MainActivity mainActivity;
	
	public AgeWillBeData(MainActivity mainActivity) { this.mainActivity = mainActivity; }
	
	void age_will_be() {
		TextView textView = mainActivity.findViewById(R.id.Age_will_be);
		textView.setText(String.valueOf(
				Var.nowTimeYear - mainActivity.getUser().getDateYear()));
	}
}