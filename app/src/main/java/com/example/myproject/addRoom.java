package com.example.myproject;

import android.content.Intent;
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

public class addRoom extends AppCompatActivity {

    private EditText title;
    private EditText price;
    private EditText floor;
    private EditText beds;
    private EditText description;
   // private EditText image;
    private TextView text1;

    private String titlee;
    private String pricee;
    private String floore;
    private String bedss;
    private String desc;




    private final String KEY_TITLE = "title";
    private final String KEY_PRICE = "PRICE";
    private final String KEY_FLOOR = "FLOOR";
    private final String KEY_BEDS = "BEDS";
    private final String KEY_DESCRIPTION = "DESCRIPTION";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);

        title = findViewById(R.id.title);
        price = findViewById(R.id.price);
        floor = findViewById(R.id.floorNum);
        text1 = findViewById(R.id.text1);
        beds = findViewById(R.id.Numbed);
        description = findViewById(R.id.description);
       // image = findViewById(R.id.);

    }

    private void addRoom(String title, String price, String floorNum,String Numbed, String description){
        String url = "http://10.0.2.2:80/mobileProject/addRoom.php";
        RequestQueue queue = Volley.newRequestQueue(addRoom.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    // on below line we are displaying a success toast message.
                    Toast.makeText(addRoom.this,
                            jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                text1.setText(error.toString());
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
                params.put("title", title);
                params.put("price", price);
                params.put("floor", floorNum);
                params.put("beds", Numbed);
                params.put("description", description);
           //     params.put("image", image);

                // at last we are returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }



    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_TITLE,titlee);
        outState.putString(KEY_PRICE,pricee);
        outState.putString(KEY_FLOOR, floore);
        outState.putString(KEY_BEDS, bedss);
        outState.putString(KEY_DESCRIPTION, desc);


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        titlee = savedInstanceState.getString(KEY_TITLE);
        pricee = savedInstanceState.getString(KEY_PRICE);
        floore = savedInstanceState.getString(KEY_FLOOR);
        bedss = savedInstanceState.getString(KEY_BEDS);
        desc = savedInstanceState.getString(KEY_DESCRIPTION);

        title.setText(titlee);
        price.setText(pricee);
        floor.setText(floore);
        beds.setText(bedss);
        description.setText(desc);
    }


    public void btnH(View view) {
        String titlee = title.getText().toString();
        String pricee = price.getText().toString();
        String floorn = floor.getText().toString();
        String bed = beds.getText().toString();
        String des = description.getText().toString();
       // String image1 = image.toString();


        addRoom(titlee,pricee, floorn,bed,des);
        Intent in = new Intent(this,Room.class);
        startActivity(in);

    }

}
