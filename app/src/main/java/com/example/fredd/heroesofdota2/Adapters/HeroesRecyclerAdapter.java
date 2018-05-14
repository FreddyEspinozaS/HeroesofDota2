package com.example.fredd.heroesofdota2.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;
import com.example.fredd.heroesofdota2.Entities.Hero;
import com.example.fredd.heroesofdota2.R;

import java.util.ArrayList;

public class HeroesRecyclerAdapter extends RecyclerView.Adapter<HeroesRecyclerAdapter.ViewHolder> {
    ArrayList<Hero> heroArrayList;


    public HeroesRecyclerAdapter(ArrayList<Hero> heroArrayList) {
        this.heroArrayList = heroArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_heroes, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nameHeroTextView.setText(heroArrayList.get(position).getLocalized_name());
        holder.iconHeroANImageView.setImageUrl(heroArrayList.get(position).getURLIcon());
    }

    @Override
    public int getItemCount() { return heroArrayList.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameHeroTextView;
        ANImageView iconHeroANImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            nameHeroTextView = itemView.findViewById(R.id.nameHeroTextView);
            iconHeroANImageView = (ANImageView) itemView.findViewById(R.id.iconHeroANImageView);
        }
    }
}
