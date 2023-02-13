package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Room extends AppCompatActivity {

    private List<Rooms> items = new ArrayList<>();
    private RecyclerView recycler;
    private TextView text;

    private static final String URL = "http://10.0.2.2:80/mobileProject/get_items.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        recycler = findViewById(R.id.room_recycler);
        text = findViewById(R.id.text);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        loadItems();



    }

    private void loadItems() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            text.setText(response+"hhh");
                            JSONArray array = new JSONArray(response);

                            for (int i = 0; i < array.length(); i++) {

                                JSONObject object = array.getJSONObject(i);
                                String name = object.optString("name");
                                String image = object.optString("image");
                          //      Log.e("roomrecycler pic", image);
                                Rooms room = new Rooms(name,image);

                                items.add(room);

                            }
                              //  text.setText("kk"+items.size());
                            } catch (JSONException jsonException) {
                            jsonException.printStackTrace();
                        }

                           CardAdapter adapter = new CardAdapter(Room.this, items);
                           recycler.setAdapter(adapter);



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                text.setText(error.toString());
            }
        });
        Volley.newRequestQueue(Room.this).add(stringRequest);
    }

    public void roomAdd(View view) {
        Intent in = new Intent (this,addRoom.class);
        startActivity(in);
    }
}











