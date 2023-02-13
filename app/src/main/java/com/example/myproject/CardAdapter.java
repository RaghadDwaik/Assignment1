package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CardAdapter
        extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private Context context;
    private TextView text;
    private List<Rooms> items ;

    public CardAdapter(){

    }

    public CardAdapter(Context context, List<Rooms> items) {
        this.context = context;
        this.items = items;
    }



    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview,
                parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Rooms room = items.get(position);
        text.setText("raghad f");
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.image);
        if (!room.getImage().isEmpty() && room.getImage() != null) {
            Glide.with(context).load(room.getImage()).into(imageView);
        }
        else {
            text.setText("image is empty");
        }
       // Log.e("image", room.getImage());
        //get views

        TextView type_txt = (TextView)cardView.findViewById(R.id.txtName);
        type_txt.setText(room.getName());
        ImageView tv_img = (ImageView) cardView.findViewById(R.id.image);

        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }
    }
}

