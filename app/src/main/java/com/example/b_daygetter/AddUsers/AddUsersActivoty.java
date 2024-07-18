package com.example.b_daygetter.AddUsers;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.b_daygetter.Dao.MainDataBase;
import com.example.b_daygetter.Dao.User;
import com.example.b_daygetter.Dao.UserDao;
import com.example.b_daygetter.R;

import java.time.LocalDate;

public class AddUsersActivoty extends AppCompatActivity {
    UserDao userDao;
    String userName;
    String userSureName;
    LocalDate bLocalDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_users_activoty);

        userDao = MainDataBase.getInstance(getApplicationContext()).userDao();
    }

    public void submit_Button_Add_Users_Adtivoty(View view) {
        EditText personName = findViewById(R.id.Person_Name);
        EditText personDate = findViewById(R.id.Person_Date);

        Exception error = null;

        error = VardasPavardeSetteris(personName, error);
        error = GimimoDataSetteris(personDate, error);

        if (error == null) {
            AddingUser();

            Intent intent = new Intent(this, AddMessige.class);
            finishAffinity();
            startActivity(intent);
        }
    }

    private Exception GimimoDataSetteris(EditText personDate, Exception error) {
        try {
            bLocalDate = LocalDate.parse(personDate.getText());
        } catch (Exception e) {
            error = e;
            Toast.makeText(this,
                    "Įvyko klaida nuskaitant antroje eilute, įsitikinkitia, kad parašėtia teisingai metus, viska atskyretia per bruksnialį",
                    Toast.LENGTH_SHORT).show();
        }
        return error;
    }

    private Exception VardasPavardeSetteris(EditText personName, Exception error) {
        try {
            String[] words = personName.getText().toString().split(" ");

            userName = words[0];
            userSureName = words[1];
        } catch (Exception e) {
            error = e;
            Toast.makeText(this,
                    "Įvyko klaida nuskaitant pirmaja eilute, įsitikinkitia, kad parašėtia varda bei pavarde",
                    Toast.LENGTH_SHORT).show();
        }
        return error;
    }

    private void AddingUser() {
        User user = new User(userName, userSureName, bLocalDate.getYear(), bLocalDate.getMonthValue(),
                bLocalDate.getDayOfMonth()
        );

        Log.d("getText",
                user.getName() + " " + user.getSureName() + " " + user.getDateMonth() + " " +
                        user.getDateMonth() + " " + user.getDateDay()
        );

        userDao.insert(user);
    }

}