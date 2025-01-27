package com.example.b_daygetter.Main;

import android.annotation.SuppressLint;
import android.widget.TextView;

import com.example.b_daygetter.R;

public class Countdown {
    private final MainActivity mainActivity;

    public Countdown(MainActivity mainActivity) { this.mainActivity = mainActivity; }



    @SuppressLint("SetTextI18n")
    void countdown() {
        TextView B_day_countdown = mainActivity.findViewById(R.id.B_day_countdown);

        String result;

        Var.make_birthday_of_the_personal(mainActivity.getUser());

        if (Var.bDayOf - Var.dayOfYear < 0) {
            result = String.valueOf(Var.bDayOf + 365 - Var.dayOfYear);

        } else {
            result = String.valueOf(Var.bDayOf - Var.dayOfYear);
        }

        B_day_countdown.setText(result +
                " Days " + (24 - Var.hour) +
                " Hour\n " + (60 - Var.minute) +
                " Minute " + (60 - Var.second) +
                " Second ");

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                mainActivity.runOnUiThread(() -> {
                    Var.Updater();
                    countdown();
                });
            } catch (InterruptedException ignored) {
            }
        });
        thread.start();
    }
}