package com.example.b_daygetter.PrivetData;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.DocumentsContract;

public class FileAccess {
    private static final int FILE = 1;

    public void openFile(Activity activity, Uri pickerInitialUri) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/markdown");

        intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, pickerInitialUri);
        activity.startActivityForResult(intent, FILE);

//      Todo Taip pat apbdirbit ir istaukti duomenis is failus
    }
}
