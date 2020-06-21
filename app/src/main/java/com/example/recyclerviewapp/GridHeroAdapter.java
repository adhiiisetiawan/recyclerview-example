package com.example.recyclerviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridHeroAdapter extends RecyclerView.Adapter<GridHeroAdapter.GridViewHolder> {
    private ArrayList<Hero> heroArrayList;
    private onItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(GridHeroAdapter.onItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public GridHeroAdapter(ArrayList<Hero> heroArrayList) {
        this.heroArrayList = heroArrayList;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_hero, parent,false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(heroArrayList.get(position).getPhoto())
                .apply(new RequestOptions().override(350,350))
                .into(holder.imgPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(heroArrayList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return heroArrayList.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }

    public interface onItemClickCallback{
        void onItemClicked(Hero data);
    }
}
