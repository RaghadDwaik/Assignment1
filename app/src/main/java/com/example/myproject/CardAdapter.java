package com.example.myproject;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter
        extends RecyclerView.Adapter<CardAdapter.ViewHolder>{

    private Context mCtx;
    private java.util.List<Room> List;

    public CardAdapter(Context mCtx, List<Room> List) {
        this.mCtx = mCtx;
        this.List = List;


}

    public class ViewHolder {

    }
    }
