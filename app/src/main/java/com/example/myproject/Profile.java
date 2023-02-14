package com.example.myproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {
    private TextView name, email, phone, id,text;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";
    private static final String KEY_PHONE="phone";
    private static final String KEY_ID="id";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name = findViewById(R.id.name1);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        id = findViewById(R.id.Nid);
        text = findViewById(R.id.text);

        preferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String n = preferences.getString(KEY_NAME
                  ,null);

        String n1 = preferences.getString(KEY_EMAIL
                ,null);
        String n2 = preferences.getString(KEY_PHONE
                ,null);

        String n3 = preferences.getString(KEY_ID
                ,null);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
       // finish();

        name.setText(n);
        email.setText(n1);
        phone.setText(n2);
        id.setText(n3);

       // getUserInfo();
    }



    public void btun(View view) {

      Intent in = new Intent(this,Welcome.class);
      startActivity(in);
    }
}


