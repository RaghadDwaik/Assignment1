package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LogIn extends AppCompatActivity {
    private Button btn;
    private EditText edt1;
    private EditText edt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);

    }
//    public void login(View view) {
//String str= edt1.toString()+edt2.toString();
//        Intent in = new Intent(this, SignUp.class);
//        startActivity(in);
//        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
//
//
//    }
}