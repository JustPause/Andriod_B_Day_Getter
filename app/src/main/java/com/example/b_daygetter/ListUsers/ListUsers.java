package com.example.b_daygetter.ListUsers;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

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

        List<User> allUser = userDao.getAllUsers();

        coursesGV = findViewById(R.id.idGVcourses);

        ListUsersAdapter adapter = new ListUsersAdapter(this, allUser);

        coursesGV.setAdapter(adapter);
    }

    public void runOnClick(View view) {

        Debugeris.SetColorAfterPress(view);
        Debugeris.GetId(view);

        TextView textview = view.findViewById(R.id.Id);
        new MainActivity().setId(Integer.parseInt((String) textview.getText()));

        Intent intent = new Intent(this, MainActivity.class);

        finishAffinity();
        startActivity(intent);
    }


    public void delete_Button_ListUsers(View view) {
//		userDao.deleteAllUsers();
//
//		Intent intent = getIntent();
//
//		finishAffinity();
//		startActivity(intent);

        Toast.makeText(this, "Puff sitas miktukas dar neveikia", Toast.LENGTH_SHORT).show();
    }
}

class Debugeris {
    public static void SetColorAfterPress(View view) {
        view.setBackgroundColor(0xffff8c00);
    }

    public static void GetId(View view) {
        TextView textview = view.findViewById(R.id.Id);
        Log.d("GettingId", String.valueOf(textview.getText()));
    }

}


