package com.example.b_daygetter.PrivetData;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.DocumentsContract;

import com.example.b_daygetter.Main.MainActivity;


public class FileAcces {
    private static final int PICK_PDF_FILE = 2;

    public void openFile(Activity activity,Uri pickerInitialUri) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/pdf");

        // Optionally, specify a URI for the file that should appear in the
        // system file picker when it loads.
        intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, pickerInitialUri);

        activity.startActivityForResult(intent, PICK_PDF_FILE);

//      Todo Taip pat apbdirbit ir istaukti duomenis is failus
    }
}
