package com.example.fredd.heroesofdota2.Adapters;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;
import com.example.fredd.heroesofdota2.Entities.Hero;
import com.example.fredd.heroesofdota2.Fragments.HeroFragment;
import com.example.fredd.heroesofdota2.Fragments.HeroesFragment;
import com.example.fredd.heroesofdota2.R;

import java.util.ArrayList;

public class HeroesRecyclerAdapter extends RecyclerView.Adapter<HeroesRecyclerAdapter.ViewHolder> {
    ArrayList<Hero> heroArrayList;

    private  OnClickHeroListener clickHeroListener;
    private OnFragmentInteractionListener listener;

    public HeroesRecyclerAdapter(ArrayList<Hero> heroArrayList) {
        this.heroArrayList = heroArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_heroes, null, false);

        Context context = view.getContext();

        if (context instanceof OnFragmentInteractionListener){
            listener = (OnFragmentInteractionListener) context;
        }else {
            throw new RuntimeException(context.toString()
                    + "must implement OnFragmentIteractionListener");
        }

        if (context instanceof OnClickHeroListener){
            clickHeroListener = (OnClickHeroListener) context;
        }else {
            throw new RuntimeException(context.toString()
                    + "must implement OnClickHeroListener");
        }

        return new ViewHolder(view);



    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Hero hero = heroArrayList.get(position);
        holder.nameHeroTextView.setText(heroArrayList.get(position).getLocalized_name());
        holder.iconHeroANImageView.setImageUrl(heroArrayList.get(position).getURLIcon());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickHeroListener.onClickHeroListener();
            }
        });
    }

    @Override
    public int getItemCount() { return heroArrayList.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameHeroTextView;
        ANImageView iconHeroANImageView;
        LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            nameHeroTextView = itemView.findViewById(R.id.nameHeroTextView);
            iconHeroANImageView = (ANImageView) itemView.findViewById(R.id.iconHeroANImageView);
            linearLayout = itemView.findViewById(R.id.recycler_hero_linear);
        }
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



    public interface OnClickHeroListener{
        void onClickHeroListener();
    }

}
