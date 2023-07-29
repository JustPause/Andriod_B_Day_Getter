package com.example.b_daygetter.ListUsers;

import android.util.Log;

public class GlobalVaribal {
    private static int id = 1;

    public static int getIdGlobalVaribal() {
        Log.d("GettingId-Get", String.valueOf(id));
        return id;
    }

    public static void setIdGlobalVaribal(int id) {
        Log.d("GettingId-Set", String.valueOf(id));
        GlobalVaribal.id = id;
    }
}
