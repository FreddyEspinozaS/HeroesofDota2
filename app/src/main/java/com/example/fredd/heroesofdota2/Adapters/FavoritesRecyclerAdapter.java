package com.example.fredd.heroesofdota2.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;
import com.example.fredd.heroesofdota2.Entities.Hero;
import com.example.fredd.heroesofdota2.R;

import java.util.ArrayList;

public class FavoritesRecyclerAdapter extends RecyclerView.Adapter<FavoritesRecyclerAdapter.ViewHolder> {
    ArrayList<Hero> favoriteArrayList;

    private  OnClickFavoriteListener clickFavoriteListener;
    private OnFragmentInteractionListener listener;

    public FavoritesRecyclerAdapter(ArrayList<Hero> favoriteArrayList) {
        this.favoriteArrayList = favoriteArrayList;
    }

    @NonNull
    @Override
    public FavoritesRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_favorites, null, false);

        Context context = view.getContext();

        if (context instanceof OnFragmentInteractionListener){
            listener = (OnFragmentInteractionListener) context;
        }else {
            throw new RuntimeException(context.toString()
                    + "must implement OnFragmentIteractionListener");
        }

        if (context instanceof OnClickFavoriteListener){
            clickFavoriteListener = (OnClickFavoriteListener) context;
        }else {
            throw new RuntimeException(context.toString()
                    + "must implement OnClickHeroListener");
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesRecyclerAdapter.ViewHolder holder, int position) {
        final Hero hero = favoriteArrayList.get(position);
        holder.nameFavoriteTextView.setText(favoriteArrayList.get(position).getLocalized_name());
        holder.iconFavoriteANImageView.setImageUrl(favoriteArrayList.get(position).getURLIcon());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickFavoriteListener.onClickFavoriteListener();
            }
        });
    }

    @Override
    public int getItemCount() {
        return favoriteArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameFavoriteTextView;
        ANImageView iconFavoriteANImageView;
        LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            nameFavoriteTextView = itemView.findViewById(R.id.nameFavoriteTextView);
            iconFavoriteANImageView = (ANImageView) itemView.findViewById(R.id.iconFavoriteANImageView);
            linearLayout = itemView.findViewById(R.id.recycler_favorite_linear);
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



    public interface OnClickFavoriteListener{
        void onClickFavoriteListener();
    }

}
