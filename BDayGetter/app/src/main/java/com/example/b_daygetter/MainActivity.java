package com.example.b_daygetter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{

  String dataBaseUserName = "Justinas";
  String dataBaseUserSurName = "Stankunas";
  String dataBaseUserYear = "2003";
  String dataBaseUserMonth = "6";
  String dataBaseUserDay = "6";

  int nowTimeYear = java.time.LocalDate.now().getYear();
  int nowTimeMonth = java.time.LocalDate.now().getMonthValue();
  int nowTimeDay = java.time.LocalDate.now().getDayOfMonth();

  int bDayOf = java.time.LocalDate.of(Integer.parseInt(dataBaseUserYear),
      Integer.parseInt(dataBaseUserMonth), Integer.parseInt(dataBaseUserDay)).getDayOfYear();

  int todayDay = java.time.LocalDate.now().getDayOfYear();
  int todayTimeH = java.time.LocalDateTime.now().getHour();
  int todayTimeM = java.time.LocalDateTime.now().getMinute();
  int todayTimeS = java.time.LocalDateTime.now().getSecond();

  void UpdateInt()
  {
    nowTimeYear = java.time.LocalDate.now().getYear();
    nowTimeMonth = java.time.LocalDate.now().getMonthValue();
    nowTimeDay = java.time.LocalDate.now().getDayOfMonth();
    bDayOf = java.time.LocalDate.of(Integer.parseInt(dataBaseUserYear),
        Integer.parseInt(dataBaseUserMonth), Integer.parseInt(dataBaseUserDay)).getDayOfYear();
    todayDay = java.time.LocalDate.now().getDayOfYear();
    todayTimeH = java.time.LocalDateTime.now().getHour();
    todayTimeM = java.time.LocalDateTime.now().getMinute();
    todayTimeS = java.time.LocalDateTime.now().getSecond();
  }

  @Override protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    User_name();
    date();
    init_Data_B_day_countdown();
    age_will_be();
  }


  @SuppressLint("SetTextI18n")

  private void init_Data_B_day_countdown()
  {
    TextView textView = findViewById(R.id.B_day_countdown);

    //		Log.d("Debug1", nowTimeYear + " " + nowTimeMonth + " " + nowTimeDay);
    //		Log.d("Debug1", dataBaseUserYear + " " + dataBaseUserMonth + " " + dataBaseUserDay);

    if (bDayOf - todayDay < 0)
    {
      textView.setText(String.valueOf(
          bDayOf + 365 - todayDay) + " Days " + (24 - todayTimeH) + " Hour\n " + (60 - todayTimeM) + " Minute " + (60 - todayTimeS) + " Second ");
    }
    else
    {
      textView.setText(String.valueOf(
          bDayOf - todayDay) + " Days " + (24 - todayTimeH) + " Hour\n " + (60 - todayTimeM) + " Minute " + (60 - todayTimeS) + " Second ");
    }

    Thread thread = new Thread()
    {

      @Override public void run()
      {
        try
        {
          Thread.sleep(1000);
          runOnUiThread(new Runnable()
          {
            @Override public void run()
            {
              UpdateInt();
              init_Data_B_day_countdown();
            }
          });
        }
        catch (InterruptedException e)
        {
        }
      }
    };

    thread.start();

  }

  private void room_Data_Base()
  {
    
  }

  @SuppressLint("SetTextI18n") protected void User_name()
  {
    TextView textView = findViewById(R.id.User_name);
    textView.setText(dataBaseUserName + " " + dataBaseUserSurName);
  }

  @SuppressLint("SetTextI18n") protected void date()
  {
    TextView textView = findViewById(R.id.Date);
    textView.setText(dataBaseUserYear + " " + dataBaseUserMonth + " " + dataBaseUserDay);
  }

  @SuppressLint("SetTextI18n") protected void age_will_be()
  {
    TextView textView = findViewById(R.id.Age_will_be);
    textView.setText("21");
  }

  //	public void add_user(View view){
  //		Log.d("Button","Yes");
  //	}
}