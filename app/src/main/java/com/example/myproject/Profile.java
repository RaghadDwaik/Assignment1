package com.example.myproject;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Profile extends AppCompatActivity {
    private TextView name, email, phone, id,text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name = findViewById(R.id.name1);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        id = findViewById(R.id.Nid);
        text = findViewById(R.id.text);

        getUserInfo();
    }

    private void getUserInfo() {
        RequestQueue queue = Volley.newRequestQueue(this);

        // URL to retrieve the user's information
        String url = "http://10.0.2.2:80/mobileProject/profile.php?userid=+userid";
     //   name.setText("rrrrrrrrrr");
        // Make a GET request to the server
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override

                    public void onResponse(String response) {
                        try {
                            // Convert the response to a JSON object
                            JSONObject jsonObject = new JSONObject(response);

                            // Extract the user's information from the JSON object
                            String name1 = jsonObject.getString("userName");
                            String email1 = jsonObject.getString("email");
                            String phone1 = jsonObject.getString("mobileNum");
                            String id1 = jsonObject.getString("national");



                            email.setText(email1);
                            phone.setText(phone1);
                            id.setText(id1);

                        } catch (JSONException e) {
                            text.setText(e.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        text.setText(error.toString());
                    }


                });
        queue.add(stringRequest);
    }

    public void btun(View view) {
    }
}


