package com.example.b_daygetter.Main;

import android.widget.TextView;

import com.example.b_daygetter.R;

public class Countdown {
    private final MainActivity mainActivity;

    public Countdown(MainActivity mainActivity) { this.mainActivity = mainActivity; }

    void countdown() {
        TextView textView = mainActivity.findViewById(R.id.B_day_countdown);

        String result;
        Var.GenBDayOf(mainActivity.getUser());
        if (Var.bDayOf - Var.todayDay < 0) {
            result = Var.bDayOf + 365 - Var.todayDay + " Days " + (24 - Var.todayTimeH) +
                    " Hour\n " +
                    (60 - Var.todayTimeM) + " Minute " + (60 - Var.todayTimeS) +
                    " Second ";
        } else {
            result = Var.bDayOf - Var.todayDay + " Days " + (24 - Var.todayTimeH) + " Hour\n " +
                    (60 - Var.todayTimeM) + " Minute " + (60 - Var.todayTimeS) + " Second ";
        }

        textView.setText(result);


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