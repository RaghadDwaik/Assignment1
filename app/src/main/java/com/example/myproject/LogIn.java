package com.example.myproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
public class LogIn extends AppCompatActivity {
    private Button btn;
    private Button login;
    private EditText edit1;
    private EditText edit2;
    private TextView text;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context context;
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_NAME="name";
    private static final String KEY_PASS="pass";

    private static final String TAG = LogIn.class.getSimpleName();



    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edit1 = findViewById(R.id.edt1);
        edit2 = findViewById(R.id.edt2);
        text = findViewById(R.id.text);
      //  setUp();
        preferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String n = preferences.getString(KEY_NAME
        ,null);



        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

    }


   /* public class LoginPreferences {
        private SharedPreferences preferences;
        private SharedPreferences.Editor editor;
        private Context context;

        private static final String PREFERENCE_NAME = "LoginPreferences";
        private static final int PRIVATE_MODE = 0;

        private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
        private static final String KEY_USERNAME = "username";
        private static final String KEY_PASSWORD = "password";

        public LoginPreferences(Context context) {
            this.context = context;
            preferences = context.getSharedPreferences(PREFERENCE_NAME, 0);
            editor = preferences.edit();
        }

        public void setLogin(String username, String password) {
            editor.putBoolean(KEY_IS_LOGGED_IN, true);
            editor.putString(KEY_USERNAME, username);
            editor.putString(KEY_PASSWORD, password);
            editor.apply();
        }

        public void logout() {
            editor.putBoolean(KEY_IS_LOGGED_IN, false);
            editor.remove(KEY_USERNAME);
            editor.remove(KEY_PASSWORD);
            editor.apply();
        }

        public boolean isLoggedIn() {
            return preferences.getBoolean(KEY_IS_LOGGED_IN, false);
        }

        public String getUsername() {
            return preferences.getString(KEY_USERNAME, null);
        }

        public String getPassword() {
            return preferences.getString(KEY_PASSWORD, null);
        }
    }*/

    public void signup(View view) {

        Intent in = new Intent(this, SignUp.class);
        startActivity(in);


    }

    public void btnRoom(View view) {
        String userName = edit1.getText().toString();
        String password = edit2.getText().toString();

        String url = "http://10.0.2.2:80/mobileProject/login.php";
        if (userName.equals("")) {
            Toast.makeText(this, "Enter User Name ", Toast.LENGTH_SHORT).show();
        } else if (password.equals("")) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        } else {
           // text.setText("gg"+userName);
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Please Wait");

            progressDialog.show();

            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                  String t = "correct";
                    if(response.equals(t) ) {

                        Toast.makeText(LogIn.this, response, Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(getApplicationContext(), Home.class));
                    }
                    else {
                        Toast.makeText(LogIn.this, response, Toast.LENGTH_LONG).show();
                    }


                    progressDialog.dismiss();

                   // startActivity(new Intent(getApplicationContext(), Home.class));
                    //Toast.makeText(LogIn.this, response, Toast.LENGTH_SHORT).show();
                }

                }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    text.setText(error.toString());
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("userName", userName);
                    params.put("PASSWORD1", password);
                    return params;

                }


            };

            RequestQueue requestQueue = Volley.newRequestQueue(LogIn.this);
            requestQueue.add(request);


            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(KEY_NAME,edit1.getText().toString());
            editor.putString(KEY_PASS,edit2.getText().toString());
            editor.commit();




        }
    }




}
