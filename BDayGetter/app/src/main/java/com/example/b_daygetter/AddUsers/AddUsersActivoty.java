package com.example.b_daygetter.AddUsers;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.b_daygetter.Dao.MainDataBase;
import com.example.b_daygetter.Dao.User;
import com.example.b_daygetter.Dao.UserDao;
import com.example.b_daygetter.R;

import java.time.LocalDate;

public class AddUsersActivoty extends AppCompatActivity
{
  UserDao userDao;

  @Override protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.add_users_adtivoty);

    userDao = MainDataBase.getInstance(getApplicationContext()).userDao();
  }

  public void submit_Button_Add_Users_Adtivoty(View view)
  {
    EditText personName = (EditText) findViewById(R.id.Person_Name);
    EditText personDate = (EditText) findViewById(R.id.Person_Date);

    //    Log.d("getText", String.valueOf(personName.getText()));
    //    Log.d("getText", personDate.getText().toString().substring(0,
    //        4) + "_" + personDate.getText().toString().substring(5,
    //        7) + "_" + personDate.getText().toString().substring(8, 10));

    String[] words = personName.getText().toString().split(" ");

    String userName = words[0];
    String userSureName = words[1];
    LocalDate bLocalDate = LocalDate.parse(personDate.getText());

    User user = new User(userName, userSureName, bLocalDate.getYear(), bLocalDate.getMonthValue(),
        bLocalDate.getDayOfMonth());
    userDao.insert(user);
    Log.d("getText",
        userName + " " + userSureName + " " + bLocalDate.getYear() + " " + bLocalDate.getMonthValue() + " " + bLocalDate.getDayOfMonth());
  }
}