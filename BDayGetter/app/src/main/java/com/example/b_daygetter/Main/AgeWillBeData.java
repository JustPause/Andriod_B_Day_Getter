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
		if (Var.nowTimeMonth < mainActivity.getUser().getDateMonth()) {
			return Var.nowTimeYear - mainActivity.getUser().getDateYear() + " metai bus";
		}
		
		if (Var.nowTimeMonth == mainActivity.getUser().getDateMonth()) {
			if (Var.nowTimeDay < mainActivity.getUser().getDateMonth()) {
				return Var.nowTimeYear - mainActivity.getUser().getDateYear() + " metai bus";
			}
			if (Var.nowTimeDay == mainActivity.getUser().getDateMonth()) {
				return Var.nowTimeYear - mainActivity.getUser().getDateYear() + " metai bus";
			}
			if (Var.nowTimeDay > mainActivity.getUser().getDateMonth()) {
				return Var.nowTimeYear - mainActivity.getUser().getDateYear() + 1 + " metai bus";
			}
		}
		
		return Var.nowTimeYear - mainActivity.getUser().getDateYear() + 1 + " metai bus";
	}
}