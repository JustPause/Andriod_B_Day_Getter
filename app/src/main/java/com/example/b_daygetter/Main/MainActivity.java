package com.example.b_daygetter.Main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.b_daygetter.Dao.MainDataBase;
import com.example.b_daygetter.Dao.User;
import com.example.b_daygetter.Dao.UserDao;
import com.example.b_daygetter.ListUsers.ListUsers;
import com.example.b_daygetter.PrivetData.FileAccess;
import com.example.b_daygetter.R;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity {
    private static final int FILE = 1;
    private final FileAccess fileAccess = new FileAccess(this,FILE);

    UserDao userDao;

    int id = 1;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO https://developer.android.com/develop/ui/views/graphics/palette-colors
        // TODO Pirdeti galimybe kad progrmama pasimtu spavas is telefono paletes

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDao = MainDataBase.getInstance(this).userDao();

        if ( userDao.getAllUsers().isEmpty() ) {
            userDao.clearAllUsers();
            fileAccess.openFile(null, userDao);
        }

        if((user = userDao.getUser(id)) == null){
            user = new User("Justinas","Stankūnas", 2003, 6, 6);
        }


//        Var.make_birthday_of_the_personal(user);

         user_name();
         date();
         countdown(user);
         age_will_be();
    }

    void user_name() {
        TextView textView = this.findViewById(R.id.User_name);

        String outputString = user.getName() +
                        " " + user.getSureName();
        textView.setText(outputString);
    }

    void date() {
        TextView textView = this.findViewById(R.id.Date);
        String outputString = user.getDateYear() +
                        " " + user.getDateMonth() +
                        " " + user.getDateDay();
        textView.setText(outputString);
    }

    void countdown(User user) {
        TextView B_day_countdown = this.findViewById(R.id.B_day_countdown);

        int bDayOfLocalUser = LocalDate.of(
                user.getDateYear(),
                user.getDateMonth(),
                user.getDateDay()
        ).getDayOfYear();

        LocalDate localTime =  LocalDate.now();

        int DayOfYear = LocalDate.now().getDayOfYear();

        Var.make_birthday_of_the_personal(this.getUser());

        int result;
        if (bDayOfLocalUser - DayOfYear < 0) {
            result = bDayOfLocalUser  + 365 - DayOfYear;

        } else {
            result = bDayOfLocalUser - DayOfYear;
        }
        
        String countdownText = this.getString(
                R.string.birthday_countdown,
                result,
                24 - Var.hour,
                60 - Var.minute,
                60 - Var.second
        );

        B_day_countdown.setText(countdownText);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Var.Updater();
            countdown(user);
        }, 1000);
    }

    void age_will_be() {
        TextView textView = this.findViewById(R.id.Age_will_be);
        textView.setText(getText());
    }

    private String getText() {
        LocalDate localTime = LocalDate.now();

        int year = localTime.getYear();
        int month = localTime.getMonthValue();
        int dayOfMonth = localTime.getDayOfMonth();

        if (month < this.getUser().getDateMonth()) {
            return year - this.getUser().getDateYear() + " metai bus";
        }

        if (month == this.getUser().getDateMonth()) {
            if (dayOfMonth< this.getUser().getDateMonth()) {
                return year - this.getUser().getDateYear() + " metai bus";
            }
            if (dayOfMonth == this.getUser().getDateMonth()) {
                return year - this.getUser().getDateYear() + " metai bus";
            }
            if (dayOfMonth > this.getUser().getDateMonth()) {
                return year - this.getUser().getDateYear() + 1 + " metai bus";
            }
        }

        return year - this.getUser().getDateYear() + 1 + " metai bus";
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    // TODO Add an feature that lets the you get his one color, of core the data will be collected in the data base. On craision the user can have a random color and at any time he can change it

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == FILE && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();

            if (uri != null) {
                fileAccess.processFile(uri);
            }
        }
    }
}


