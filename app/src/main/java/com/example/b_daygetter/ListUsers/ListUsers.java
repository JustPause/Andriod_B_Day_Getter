package com.example.b_daygetter.ListUsers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.b_daygetter.Dao.MainDataBase;
import com.example.b_daygetter.Dao.User;
import com.example.b_daygetter.Dao.UserDao;
import com.example.b_daygetter.Main.MainActivity;
import com.example.b_daygetter.R;

import java.util.List;

public class ListUsers extends AppCompatActivity {

    GridView coursesGV;
    UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        userDao = MainDataBase.getInstance(getApplicationContext()).userDao();
        coursesGV = findViewById(R.id.idGVcourses);

        ListUsersAdapter adapter = new ListUsersAdapter(this, userDao.getAllUsers());

        coursesGV.setAdapter(adapter);
    }

    public void runOnClick(View view) {
        TextView textview = view.findViewById(R.id.Id);
        new MainActivity().setId(Integer.parseInt((String) textview.getText()));

        Intent intent = new Intent(this, MainActivity.class);

        finishAffinity();
        startActivity(intent);
    }

}


