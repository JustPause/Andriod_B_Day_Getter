package com.example.b_daygetter.PrivetData;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileAccess extends AppCompatActivity {
    private  int FILE = 0;
    private final Activity activity;

    public FileAccess(Activity activity, int FILE){
        this.activity = activity;
        this.FILE = FILE;
    }

    public void openFile(Uri fileUri) {
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

            Log.d("fileContent",fileContent);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
