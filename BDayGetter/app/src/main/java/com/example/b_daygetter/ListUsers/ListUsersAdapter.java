package com.example.b_daygetter.ListUsers;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.b_daygetter.Dao.User;
import com.example.b_daygetter.Main.Var;
import com.example.b_daygetter.R;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class ListUsersAdapter extends ArrayAdapter<User> {
	
	public ListUsersAdapter(@NonNull Context context, List<User> listUsersModelArrayList) {
		super(context, 0, listUsersModelArrayList);
	}
	
	@NonNull
	private static String getText(User user) {
		return user.getName() + " " + user.getSureName();
	}
	
	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		
		View listitemView = convertView;
		if (listitemView == null) {
			// Layout Inflater inflates each item to be displayed in GridView.
			listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
		}
		//https://stackoverflow.com/questions/13327571/in-a-simple-to-understand-explanation-what-is-runnable-in-java
		User user = getItem(position);
		Var.GenBDayOf(user);
		
		TextView NameAndSureName = listitemView.findViewById(R.id.Name_SureName);
		TextView CoundDown = listitemView.findViewById(R.id.Coundown);
		TextView Age = listitemView.findViewById(R.id.Age);
		TextView Id = listitemView.findViewById(R.id.Id);
		
		NameAndSureName.setText(getText(user));
		
		init_Data_B_day_countdown(CoundDown, user);
		
		Age.setText(
				String.valueOf(countAge(user.getDateYear(), user.getDateMonth(), user.getDateDay()).getYears())
		);
		
		Id.setText(String.valueOf(user.getId()));
		
		return listitemView;
	}
	
	private Period countAge(int year, int month, int day) {
		
		return Period.between(
				LocalDate.of(year, month, day),
				LocalDate.now()
		);
	}
	
	private void init_Data_B_day_countdown(TextView textView, User user) {
		
		Activity curentActivity = (Activity) super.getContext();
		
		Thread thread = new Thread(() -> {
			try {
				for (int i = 0; i < 100; i++) {
					Thread.sleep(1000);
					
					String result;
					Var.GenBDayOf(user);
					if (Var.bDayOf - Var.todayDay < 0) {
						result =
								Var.bDayOf + 365 - Var.todayDay + " Days " + (24 - Var.todayTimeH) +
								" Hour\n " +
								(60 - Var.todayTimeM) + " Minute " + (60 - Var.todayTimeS) +
								" Second ";
					} else {
						result = Var.bDayOf - Var.todayDay + " Days " + (24 - Var.todayTimeH) +
								 " Hour\n " +
								 (60 - Var.todayTimeM) + " Minute " + (60 - Var.todayTimeS) +
								 " Second ";
					}
					
					curentActivity.runOnUiThread(() -> textView.setText(
							result
					));
				}
			} catch (InterruptedException ignored) {
			}
		});
		
		thread.start();
	}

//	public String B_day_countdown(int i) {
//		if (var.bDayOf - var.todayDay < 0) {
//			return var.bDayOf + 365 - var.todayDay + " Days " + (24 - var.todayTimeH) +
//				   " Hour\n " +
//				   (60 - var.todayTimeM) + " Minute " + (60 - var.todayTimeS) +
//				   " Second ";
//		} else {
//			return var.bDayOf - var.todayDay + " Days " + (24 - var.todayTimeH) + " Hour\n " +
//				   (60 - var.todayTimeM) + " Minute " + (60 - var.todayTimeS) + " Second ";
//		}
//	}
}
