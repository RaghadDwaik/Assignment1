package com.example.myproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
public class LogIn extends AppCompatActivity {
    private Button btn;
    private Button login;
    private EditText edit1;
    private EditText edit2;
    private TextView text;
    private static final String TAG = LogIn.class.getSimpleName();

    String url = "http://10.0.2.2:80/mobileProject/login.php";
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edit1 = findViewById(R.id.edt1);
        edit2 = findViewById(R.id.edt2);
        text = findViewById(R.id.text);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

    }

    public void signup(View view) {

        Intent in = new Intent(this, SignUp.class);
        startActivity(in);


    }

    public void btnRoom(View view) {
        String userName = edit1.getText().toString().trim();
        String password = edit2.getText().toString().trim();


        if (userName.equals("")) {
            Toast.makeText(this, "Enter User Name ", Toast.LENGTH_SHORT).show();
        } else if (password.equals("")) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        } else {

            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Please Wait");

            progressDialog.show();

            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    progressDialog.dismiss();

                    startActivity(new Intent(getApplicationContext(), Home.class));
                    Toast.makeText(LogIn.this, response, Toast.LENGTH_SHORT).show();
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
                    params.put("user", userName);
                    params.put("password", password);
                    return params;

                }


            };

            RequestQueue requestQueue = Volley.newRequestQueue(LogIn.this);
            requestQueue.add(request);

        }
    }




}
