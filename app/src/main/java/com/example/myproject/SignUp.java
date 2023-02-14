package com.example.myproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {

    private EditText user;
    private EditText password;
    private EditText email1;
    private EditText numid;
    private EditText number;
    private TextView text;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context context;
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";
    private static final String KEY_PHONE="phone";
    private static final String KEY_ID="id";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        user = findViewById(R.id.user);
        email1 = findViewById(R.id.email);
        password = findViewById(R.id.password);
        text = findViewById(R.id.text);
        number = findViewById(R.id.number);
        numid = findViewById(R.id.numid);

        preferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String n = preferences.getString(KEY_NAME
                ,null);
        String n1 = preferences.getString(KEY_EMAIL
                ,null);
        String n2 = preferences.getString(KEY_PHONE
                ,null);
        String n3 = preferences.getString(KEY_ID
                ,null);



    }

    private void addBook(String email, String userName, String pass,String mobileNum, String id){
        String url = "http://10.0.2.2:80/mobileProject/regester.php";
        RequestQueue queue = Volley.newRequestQueue(SignUp.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    // on below line we are displaying a success toast message.
                    Toast.makeText(SignUp.this,
                            jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
               text.setText(error.toString());
            }
        }) {
            @Override
            public String getBodyContentType() {
                // as we are passing data in the form of url encoded
                // so we are passing the content type below
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() {

                // below line we are creating a map for storing
                // our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our
                // key and value pair to our parameters.
                params.put("email", email);
                params.put("userName", userName);
                params.put("PASSWORD1", pass);
                params.put("mobileNum", mobileNum);
                params.put("national", id);

                // at last we are returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_NAME,user.getText().toString());
        editor.putString(KEY_EMAIL,email1.getText().toString());
        editor.putString(KEY_PHONE,number.getText().toString());
        editor.putString(KEY_ID,numid.getText().toString());

        editor.commit();
    }



    public void login(View view) {
        Intent in = new Intent(this, LogIn.class);
        startActivity(in);
    }

    public void btnH(View view) {
        String userr = user.getText().toString();
        String email2 = email1.getText().toString();
        String pass1 = password.getText().toString();
        String numberr = number.getText().toString();
        String id1 = numid.getText().toString();


        addBook(userr,email2, pass1,numberr,id1);
        Intent in = new Intent(this, Home.class);
        startActivity(in);
    }


}
