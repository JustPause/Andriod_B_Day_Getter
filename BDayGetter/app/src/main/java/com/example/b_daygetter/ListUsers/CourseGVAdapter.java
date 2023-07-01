package com.example.b_daygetter.ListUsers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.b_daygetter.R;

import java.util.ArrayList;

public class CourseGVAdapter extends ArrayAdapter<CourseModel> {
	
	public CourseGVAdapter(@NonNull Context context, ArrayList<CourseModel> courseModelArrayList) {
		super(context, 0, courseModelArrayList);
	}
	
	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		
		View listitemView = convertView;
		if (listitemView == null) {
			// Layout Inflater inflates each item to be displayed in GridView.
			listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
		}
		
		CourseModel courseModel = getItem(position);
		TextView courseTV = listitemView.findViewById(R.id.idTVCourse);
		TextView NameAndSureName = listitemView.findViewById(R.id.Name_SureName);
		TextView CoundDown = listitemView.findViewById(R.id.Coundown);
		TextView Age = listitemView.findViewById(R.id.Age);
		
		
		courseTV.setText(courseModel.getCourse_name());
		NameAndSureName.setText(courseModel.getCourse_name());
		CoundDown.setText(courseModel.getCourse_name());
		Age.setText(courseModel.getCourse_name());
		
		return listitemView;
	}
}
