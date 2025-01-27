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
        if (Var.month < mainActivity.getUser().getDateMonth()) {
            return Var.year - mainActivity.getUser().getDateYear() + " metai bus";
        }

        if (Var.month == mainActivity.getUser().getDateMonth()) {
            if (Var.dayOfMonth < mainActivity.getUser().getDateMonth()) {
                return Var.year - mainActivity.getUser().getDateYear() + " metai bus";
            }
            if (Var.dayOfMonth == mainActivity.getUser().getDateMonth()) {
                return Var.year - mainActivity.getUser().getDateYear() + " metai bus";
            }
            if (Var.dayOfMonth > mainActivity.getUser().getDateMonth()) {
                return Var.year - mainActivity.getUser().getDateYear() + 1 + " metai bus";
            }
        }

        return Var.year - mainActivity.getUser().getDateYear() + 1 + " metai bus";
    }
}