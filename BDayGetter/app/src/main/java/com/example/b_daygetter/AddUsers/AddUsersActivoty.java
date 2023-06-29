package com.example.b_daygetter.AddUsers;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.b_daygetter.R;

public class AddUsersActivoty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_users_adtivoty);

    }
}

/*
    <?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".AddUsers.AddUsersActivoty">


<Button
            android:text="submit"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content" android:id="@+id/submitButton2"
                    app:layout_constraintBottom_toBottomOf="parent"
                    android:layout_marginBottom="24dp" app:layout_constraintEnd_toEndOf="parent" android:layout_marginEnd="24dp"
                    android:onClick="submitButton"/>
<TextView
            android:text="Vardas Pavarde"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content" android:id="@+id/Vardas"
                    app:layout_constraintTop_toTopOf="parent"
                    android:layout_marginTop="48dp"
                    app:layout_constraintBottom_toTopOf="@+id/editTextTextPersonName3"
                    app:layout_constraintStart_toStartOf="parent" app:layout_constraintHorizontal_bias="0.309"
                    app:layout_constraintEnd_toEndOf="parent" android:layout_marginBottom="48dp"/>
<EditText
            android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:inputType="textPersonName"
                    android:text="Name"
                    android:ems="10"
                    android:id="@+id/editTextTextPersonName3"
                    android:layout_marginBottom="48dp" app:layout_constraintBottom_toTopOf="@+id/textView4"
                    app:layout_constraintStart_toStartOf="parent" app:layout_constraintHorizontal_bias="0.5"
                    app:layout_constraintEnd_toEndOf="parent"/>
<TextView
            android:text="Gimimo Data"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content" android:id="@+id/textView4"
                    android:layout_marginBottom="48dp" app:layout_constraintBottom_toTopOf="@+id/editTextTextPersonName4"
                    app:layout_constraintStart_toStartOf="parent" app:layout_constraintHorizontal_bias="0.292"
                    app:layout_constraintEnd_toEndOf="parent"/>
<EditText
            android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:inputType="textPersonName"
                    android:text="Data"
                    android:ems="10"
                    android:id="@+id/editTextTextPersonName4"
                    android:layout_marginBottom="48dp" app:layout_constraintBottom_toTopOf="@+id/textView5"
                    app:layout_constraintStart_toStartOf="parent" app:layout_constraintHorizontal_bias="0.5"
                    app:layout_constraintEnd_toEndOf="parent"/>
<TextView
            android:text="Oprimalus Emailas"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content" android:id="@+id/textView5"
                    app:layout_constraintStart_toStartOf="parent" app:layout_constraintHorizontal_bias="0.328"
                    app:layout_constraintEnd_toEndOf="parent" android:layout_marginBottom="48dp"
                    app:layout_constraintBottom_toTopOf="@+id/editTextTextPersonName5"/>
<EditText
            android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:inputType="textPersonName"
                    android:text="Email"
                    android:ems="10"
                    android:id="@+id/editTextTextPersonName5"
                    tools:layout_editor_absoluteY="451dp" app:layout_constraintEnd_toEndOf="parent"
                    app:layout_constraintStart_toStartOf="parent" app:layout_constraintHorizontal_bias="0.5"/>
</androidx.constraintlayout.widget.ConstraintLayout>*/
