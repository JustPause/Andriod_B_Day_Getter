package com.example.b_daygetter.AddUsers;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.b_daygetter.R;

public class AddUsersActivoty extends AppCompatActivity
{

  @Override protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.add_users_adtivoty);

  }

  public void submit_Button_Add_Users_Adtivoty(View view)
  {
    EditText Person_Name = (EditText) findViewById(R.id.Person_Name);
    EditText Person_Date = (EditText) findViewById(R.id.Person_Date);

    Log.d("getText", String.valueOf(Person_Name.getText()));
    Log.d("getText", Person_Date.getText().toString().substring(0,
        4) + "_" + Person_Date.getText().toString().substring(5,
        7) + "_" + Person_Date.getText().toString().substring(8, 10));
  }
}