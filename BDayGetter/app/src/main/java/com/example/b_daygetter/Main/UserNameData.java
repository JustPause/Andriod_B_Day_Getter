package com.example.b_daygetter.Main;

import android.widget.TextView;

import com.example.b_daygetter.R;

public class UserNameData {
    private final MainActivity mainActivity;

    public UserNameData(MainActivity mainActivity) { this.mainActivity = mainActivity; }

    void user_name() {
        TextView textView = mainActivity.findViewById(R.id.User_name);
        String outputString =
                mainActivity.getUser().getName() + " " + mainActivity.getUser().getSureName();
        textView.setText(outputString);
    }
}