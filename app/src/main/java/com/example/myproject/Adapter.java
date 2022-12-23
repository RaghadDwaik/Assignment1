package com.example.myproject;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    private final Recycler recyclerInterface;

    private String[] captions;
    private int[] imageIds;

    public Adapter(String[] captions, int[] imageIds,Recycler recyclerInterface){
        this.captions = captions;
        this.imageIds = imageIds;
        this.recyclerInterface=recyclerInterface;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView, Recycler recyclerInterface){
            super(cardView);
            this.cardView = cardView;
        }

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card,
                parent,
                false);

        return new ViewHolder(v,recyclerInterface);
    }

    @Override
    public void onBindViewHolder( Adapter.ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.image);
        Drawable dr = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(dr);
        TextView txt = (TextView)cardView.findViewById(R.id.txtName);
        txt.setText(captions[position]);
        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (recyclerInterface != null)
                {
                    int pos = holder.getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION )
                    {
                        recyclerInterface.onItemClick(pos);
                    }
                }
            }
        });
    }

    @Override
        public int getItemCount() {
            return captions.length;
        }
}
