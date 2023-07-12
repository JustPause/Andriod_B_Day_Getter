package com.example.b_daygetter.Main;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.b_daygetter.R;

public class AgeWillBeData {
	private final MainActivity mainActivity;
	
	public AgeWillBeData(MainActivity mainActivity) { this.mainActivity = mainActivity; }
	
	void age_will_be() {
		TextView textView = mainActivity.findViewById(R.id.Age_will_be);
		textView.setText(getText());
	}
	
	@NonNull
	private String getText() {
		return Var.nowTimeYear - mainActivity.getUser().getDateYear() + 1 + " metai bus";
	}
}