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

        Varibales.make_birthday_of_the_personal(mainActivity.getUser());

        if (Varibales.bDayOf - Varibales.dayOfYear < 0) {
            result = String.valueOf(Varibales.bDayOf + 365 - Varibales.dayOfYear);

        } else {
            result = String.valueOf(Varibales.bDayOf - Varibales.dayOfYear);
        }

        B_day_countdown.setText(result +
                " Days " + (24 - Varibales.hour) +
                " Hour\n " + (60 - Varibales.minute) +
                " Minute " + (60 - Varibales.second) +
                " Second ");

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                mainActivity.runOnUiThread(() -> {
                    Varibales.Updater();
                    countdown();
                });
            } catch (InterruptedException ignored) {
            }
        });
        thread.start();
    }
}