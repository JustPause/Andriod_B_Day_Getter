package com.example.b_daygetter.ListUsers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.b_daygetter.R;

import java.util.ArrayList;

public class ListUsersAdapter extends ArrayAdapter<ListUsersModel> {
	
	public ListUsersAdapter(@NonNull Context context, ArrayList<ListUsersModel> listUsersModelArrayList) {
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
		
		ListUsersModel listUsersModel = getItem(position);
		
		TextView courseTV = listitemView.findViewById(R.id.idTVCourse);
		
		courseTV.setText(listUsersModel.getCourse_name());
		
		
		TextView NameAndSureName = listitemView.findViewById(R.id.Name_SureName);
		TextView CoundDown = listitemView.findViewById(R.id.Coundown);
		TextView Age = listitemView.findViewById(R.id.Age);
		
		NameAndSureName.setText(listUsersModel.getNameAndSureName());
		CoundDown.setText(listUsersModel.getCoundDown());
		Age.setText(listUsersModel.getAge());
		
		return listitemView;
	}
}
