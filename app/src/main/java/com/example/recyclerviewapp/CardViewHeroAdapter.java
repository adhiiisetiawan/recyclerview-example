package com.example.recyclerviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewHeroAdapter extends RecyclerView.Adapter<CardViewHeroAdapter.CardViewHolder> {
    private ArrayList<Hero> heroArrayList;

    public CardViewHeroAdapter(ArrayList<Hero> heroArrayList) {
        this.heroArrayList = heroArrayList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_hero, parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder holder, int position) {
        final Hero hero = heroArrayList.get(position);

        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(350,350))
                .into(holder.imgPhoto);

        holder.txtName.setText(hero.getName());
        holder.txtDescription.setText(hero.getDescription());

        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Favorite "+heroArrayList.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Share "+heroArrayList.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "You Choose "+heroArrayList.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return heroArrayList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView txtName, txtDescription;
        Button btnShare, btnFavorite;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            txtName = itemView.findViewById(R.id.tv_item_name);
            txtDescription = itemView.findViewById(R.id.tv_item_description);
            btnShare = itemView.findViewById(R.id.btn_share);
            btnFavorite = itemView.findViewById(R.id.btn_favorite);
        }
    }
}
