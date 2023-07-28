package com.example.b_daygetter.Main;

import static com.example.b_daygetter.ListUsers.GlobalVaribal.getIdGlobalVaribal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.b_daygetter.AddUsers.AddUsersActivoty;
import com.example.b_daygetter.Dao.User;
import com.example.b_daygetter.Dao.UserDao;
import com.example.b_daygetter.ListUsers.ListUsers;
import com.example.b_daygetter.R;
import com.example.b_daygetter.SendEmailToTheUser.SendEmailToTheUser;

public class MainActivity extends AppCompatActivity {

    private final Countdown countdown = new Countdown(this);
    private final AddingTempUsers addingTempUsers = new AddingTempUsers(this);
    private final UserNameData userNameData = new UserNameData(this);
    private final DateData dateData = new DateData(this);
    private final AgeWillBeData ageWillBeData = new AgeWillBeData(this);
    UserDao userDao;

    int id = 0;
    // TODO pakeisti dataBaseUserYear, dataBaseUserMonth, dataBaseUserDay i int
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO https://developer.android.com/develop/ui/views/graphics/palette-colors
        // TODO Pirdeti galimybe kad progrmama pasimtu spavas is telefono paletes

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Var.GenBDayOf(new User("", "", 2003, 6, 6));
        MainActivityAddingTempUser();

        id = getIdGlobalVaribal();

        user = userDao.getUser(id);
        Var.GenBDayOf(user);

        user_name();
        date();
        countdown(id);
        age_will_be();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void add_users_button(View view) {

        Intent intent = new Intent(this, AddUsersActivoty.class);
        startActivity(intent);
    }


    // TODO Add an feture that lets the youser get his one color, of core the data will be collected in the data base. On craision the user can have a random color and at any time he can chage it

    void user_name() {
        userNameData.user_name();
    }

    void date() {
        dateData.date();
    }

    void age_will_be() {
        ageWillBeData.age_will_be();
    }

    private void countdown(int id) {
        countdown.countdown(id);
    }

    public void MainActivityAddingTempUser() {
        addingTempUsers.MainActivityAddingTempUser();
    }

    public void list_users_button(View view) {

        Intent intent = new Intent(this, ListUsers.class);
        startActivity(intent);
    }

    public void send_email_to_the_user_button(View view) {

        Intent intent = new Intent(this, SendEmailToTheUser.class);
        finish();
        startActivity(intent);
    }


    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}


