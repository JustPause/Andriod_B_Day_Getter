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

import java.util.List;

public class ListUsersAdapter extends ArrayAdapter<User> {

    public ListUsersAdapter(@NonNull Context context, List<User> listUsersModelArrayList) {
        super(context, 0, listUsersModelArrayList);
    }

    @NonNull
    private static String NameSureName(User user) {
        return user.getName() + " " + user.getSureName();
    }

    @NonNull
    private static String BbayDate(User user) {
        return user.getDateYear() + " " + user.getDateMonth() + " " + user.getDateDay();
    }

    @NonNull
    private static String Countdown(User user) {
        Var.GenBDayOf(user);
        String result;

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

        return result;
    }

    @NonNull
    private String AgeFing(@NonNull User user, View convertView) {
        String theReturn = "null";

        if (Var.nowTimeMonth < user.getDateMonth()) {
            convertView.setBackgroundColor(0xff7A7A7A);

//			CardView cardView = (CardView) convertView;

            return "Bus";
        }

        if (Var.nowTimeMonth == user.getDateMonth()) {
            if (Var.nowTimeDay < user.getDateDay()) {
                convertView.setBackgroundColor(0xff525252);
                return "Bus si menesi";
            }
            if (Var.nowTimeDay == user.getDateDay()) {
                convertView.setBackgroundColor(0xffCC8F00);
                return "Dabar yra";
            }
            if (Var.nowTimeDay > user.getDateDay()) {
                convertView.setBackgroundColor(0xff292929);
                return "Buvo si menesi";
            }
        }

        if (Var.nowTimeMonth > user.getDateMonth()) {
            convertView.setBackgroundColor(0xff141414);
            return "Buvo";
        }

        return theReturn;
    }

    private void SetCountDownWindow(TextView textView, User user) {

        Activity curentActivity = (Activity) super.getContext();

        Thread thread = new Thread(() ->
        {
            try {
                while (true) {
                    // ToDo Nesutrvrkiau, galimai problerma yra per Thread moduli kuris sikuiria dublikata Thread kai pakeiti vieta
                    curentActivity.runOnUiThread(() -> textView.setText(Countdown(user)));

                    Thread.sleep(1000);
                }
            } catch (InterruptedException ignored) {
            }
        }
        );

        thread.start();
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

        TextView NameAndSureName = listitemView.findViewById(R.id.NameSureName);
        TextView BDayDate = listitemView.findViewById(R.id.BDayDate);
        TextView CoundDown = listitemView.findViewById(R.id.Coundown);
        TextView Age = listitemView.findViewById(R.id.Age);
        TextView Id = listitemView.findViewById(R.id.Id);

        NameAndSureName.setText(NameSureName(user));

        BDayDate.setText(BbayDate(user));

        SetCountDownWindow(CoundDown, user);

        Age.setText(AgeFing(user, listitemView));

        Id.setText(String.valueOf(user.getId()));

        return listitemView;
    }

}
