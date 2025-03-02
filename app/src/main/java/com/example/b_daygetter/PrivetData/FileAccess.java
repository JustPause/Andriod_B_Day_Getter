package com.example.b_daygetter.PrivetData;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.b_daygetter.Dao.User;
import com.example.b_daygetter.Dao.UserDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class FileAccess extends AppCompatActivity {
    private int FILE = 0;
    private final Activity activity;
    private UserDao userDao;

    public FileAccess(Activity activity, int FILE) {
        this.activity = activity;
        this.FILE = FILE;
    }

    public void openFile(Uri fileUri, UserDao userDao) {
        this.userDao = userDao;
//        userDao.clearAllUsers();
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/markdown");

        intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, fileUri);
        activity.startActivityForResult(intent, FILE);
    }

    public void processFile(Uri fileUri) {
        try {
            InputStream inputStream = activity.getContentResolver().openInputStream(fileUri);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

            reader.close();

            String fileContent = stringBuilder.toString();

            putInToDatabase(fileContent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void putInToDatabase(String Content) {
        String[] lines = Content.split("\n");

        for (int line = 2; line < lines.length; line++) {
            String[] words = lines[line].split("\\|");
            String fullName = words[1].trim();
            String date = words[2].trim();

            if (Objects.equals(fullName, "-") || Objects.equals(date, "N")) {
                continue;
            }

            int spaceIndex = fullName.indexOf(' ');
            String Name = (spaceIndex != -1) ? fullName.substring(0, spaceIndex) : fullName;
            String Surname = (spaceIndex != -1) ? fullName.substring(spaceIndex + 1) : "";

            int firstSlash = date.indexOf('/');
            spaceIndex = date.indexOf('/', firstSlash + 1);

            int Year = Integer.parseInt(date.substring(0, firstSlash));
            int Month = Integer.parseInt(date.substring(firstSlash + 1, spaceIndex));
            int Day = Integer.parseInt(date.substring(spaceIndex + 1));
            Log.d("fileContent", Name + " " + Surname + " | " + Year + " " + Month + " " + Day);
            userDao.insert(new User(Name, Surname, Year, Month, Day));


        }
    }
}
