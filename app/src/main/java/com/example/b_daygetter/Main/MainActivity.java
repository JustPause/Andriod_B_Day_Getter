package com.example.b_daygetter.Main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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

        user = userDao.getUser(id);

        Log.d("User", String.valueOf(user));

//        Var.make_birthday_of_the_personal(user);

         user_name();
         date();
         countdown();
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

    void countdown() {
        TextView B_day_countdown = this.findViewById(R.id.B_day_countdown);

        int result;

        Var.make_birthday_of_the_personal(this.getUser());

        if (Var.bDayOf - Var.dayOfYear < 0) {
            result = Var.bDayOf + 365 - Var.dayOfYear;

        } else {
            result = Var.bDayOf - Var.dayOfYear;
        }

        String countdownText = this.getString(
                R.string.birthday_countdown,
                result,
                24 - Var.hour,
                60 - Var.minute,
                60 - Var.second
        );

        B_day_countdown.setText(countdownText);
        
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


