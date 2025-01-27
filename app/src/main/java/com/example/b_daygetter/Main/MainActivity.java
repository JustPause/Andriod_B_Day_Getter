package com.example.b_daygetter.Main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.b_daygetter.Dao.MainDataBase;
import com.example.b_daygetter.Dao.User;
import com.example.b_daygetter.Dao.UserDao;
import com.example.b_daygetter.ListUsers.ListUsers;
import com.example.b_daygetter.PrivetData.PrivetDataAndUsers;
import com.example.b_daygetter.R;

public class MainActivity extends AppCompatActivity {
    private final PrivetDataAndUsers privetDataAndUsers = new PrivetDataAndUsers();
    UserDao userDao;

    int id = 1;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO https://developer.android.com/develop/ui/views/graphics/palette-colors
        // TODO Pirdeti galimybe kad progrmama pasimtu spavas is telefono paletes

        // TODO Dar viena funcija leidzianti nuskaityti gimtadieniis is sheet tabal

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDao = MainDataBase.getInstance(this).userDao();

        if (userDao.getAllUsers().isEmpty())
        {
            privetDataAndUsers.PrivetDataAndUsersAsData(MainDataBase.getInstance(this).userDao());
        }

        user = userDao.getUser(id);

        Var.make_birthday_of_the_personal(user);

        user_name();
        date();
        countdown();
        age_will_be();
    }

    void user_name() {
        TextView textView = this.findViewById(R.id.User_name);
        String outputString =
                this.getUser().getName() + " " + this.getUser().getSureName();
        textView.setText(outputString);
    }

    void date() {
        TextView textView = this.findViewById(R.id.Date);
        String outputString =
                this.getUser().getDateYear() + " " + this.getUser().getDateMonth() +
                        " " + this.getUser().getDateDay();
        textView.setText(outputString);
    }

    @SuppressLint("SetTextI18n")
    void countdown() {
        TextView B_day_countdown = this.findViewById(R.id.B_day_countdown);

        String result;

        Var.make_birthday_of_the_personal(this.getUser());

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
                this.runOnUiThread(() -> {
                    Var.Updater();
                    countdown();
                });
            } catch (InterruptedException ignored) {
            }
        });
        thread.start();
    }

    void age_will_be() {
        TextView textView = this.findViewById(R.id.Age_will_be);
        textView.setText(getText());
    }

    private String getText() {
        if (Var.month < this.getUser().getDateMonth()) {
            return Var.year - this.getUser().getDateYear() + " metai bus";
        }

        if (Var.month == this.getUser().getDateMonth()) {
            if (Var.dayOfMonth < this.getUser().getDateMonth()) {
                return Var.year - this.getUser().getDateYear() + " metai bus";
            }
            if (Var.dayOfMonth == this.getUser().getDateMonth()) {
                return Var.year - this.getUser().getDateYear() + " metai bus";
            }
            if (Var.dayOfMonth > this.getUser().getDateMonth()) {
                return Var.year - this.getUser().getDateYear() + 1 + " metai bus";
            }
        }

        return Var.year - this.getUser().getDateYear() + 1 + " metai bus";
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    // TODO Add an feture that lets the youser get his one color, of core the data will be collected in the data base. On craision the user can have a random color and at any time he can chage it

    public void list_users_button(View view) {
        Intent intent = new Intent(this, ListUsers.class);
        startActivity(intent);
    }

    public User getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public void setId(int id) {
        this.id = id;
    }
}


