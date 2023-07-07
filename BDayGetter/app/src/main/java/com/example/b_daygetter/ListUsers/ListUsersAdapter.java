package com.example.b_daygetter.ListUsers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.b_daygetter.Dao.User;
import com.example.b_daygetter.R;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class ListUsersAdapter extends ArrayAdapter<User> {
	
	public ListUsersAdapter(@NonNull Context context, List<User> listUsersModelArrayList) {
		super(context, 0, listUsersModelArrayList);
	}
	
	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		
		View listitemView = convertView;
		if (listitemView == null) {
			// Layout Inflater inflates each item to be displayed in GridView.
			listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
		}
		
		User user = getItem(position);
		
		TextView NameAndSureName = listitemView.findViewById(R.id.Name_SureName);
		TextView CoundDown = listitemView.findViewById(R.id.Coundown);
		TextView Age = listitemView.findViewById(R.id.Age);
		TextView Id = listitemView.findViewById(R.id.Id);
		
		NameAndSureName.setText(user.getName() + " " + user.getSureName());
//		CoundDown.setText(user.getCoundDown());
		Age.setText(countAge(user.getDateYear(), user.getDateMonth(), user.getDateDay()).toString());
		Id.setText(String.valueOf(user.getId()));
		
		return listitemView;
	}
	
	private Integer countAge(int year, int month, int day) {
		
		return Period.between(
				LocalDate.of(year, month, day),
				LocalDate.now()
		).getYears();
	}
}
