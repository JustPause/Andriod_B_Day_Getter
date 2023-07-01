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

public class ListAdapterClass extends ArrayAdapter<ListStoringData> {


//public class CourseGVAdapter
	
	public ListAdapterClass(@NonNull Context context, ArrayList<ListStoringData> courseModelArrayList) {
		super(context, 0, courseModelArrayList);
	}
	
	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		
		View listitemView = convertView;
		if (listitemView == null) {
			// Layout Inflater inflates each item to be displayed in GridView.
			listitemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_items, parent, false);
		}
		
		ListStoringData courseModel = getItem(position);
		TextView courseTV = listitemView.findViewById(R.id.TitleImgList);
		ImageView courseIV = listitemView.findViewById(R.id.TitleTextList);
		
		courseTV.setText(courseModel.getCourse_name());
		courseIV.setImageResource(courseModel.getImgid());
		return listitemView;
	}
}