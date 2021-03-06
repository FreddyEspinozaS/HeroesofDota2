package com.example.fredd.heroesofdota2.Activities;

import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.fredd.heroesofdota2.Adapters.FavoritesRecyclerAdapter;
import com.example.fredd.heroesofdota2.Adapters.HeroesRecyclerAdapter;
import com.example.fredd.heroesofdota2.Fragments.FavoritesFragment;
import com.example.fredd.heroesofdota2.Fragments.HeroFragment;
import com.example.fredd.heroesofdota2.Fragments.HeroesFragment;
import com.example.fredd.heroesofdota2.R;

public class MainActivity extends AppCompatActivity
        implements HeroesFragment.OnFragmentInteractionListener,
        FavoritesFragment.OnFragmentInteractionListener,
        HeroesRecyclerAdapter.OnClickHeroListener,
        HeroesRecyclerAdapter.OnFragmentInteractionListener,
        HeroFragment.OnFragmentInteractionListener,
        FavoritesRecyclerAdapter.OnClickFavoriteListener,
        FavoritesRecyclerAdapter.OnFragmentInteractionListener{

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_heroes:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HeroesFragment()).commit();
                    return true;
                case R.id.navigation_favorites:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FavoritesFragment()).commit();
                    return true;
            }
            UpdateFragment(item);
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        HeroesFragment heroesFragment = new HeroesFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, heroesFragment).commit();
    }

    public void UpdateFragment(MenuItem item){
        Fragment newFragment = null;
        switch (item.getItemId()){
            case R.id.navigation_heroes:
                newFragment = new HeroesFragment(); break;
            case R.id.navigation_favorites:
                newFragment = new FavoritesFragment(); break;
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, newFragment)
                .commit();
    }



    public void OpenHeroFragment(){
        HeroFragment heroFragment = new HeroFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,heroFragment)
                .addToBackStack("back_to_list_heroes")
                .commit();
    }

    public void OpenFavoriteFragment(){
        Fragment heroFragment = new HeroFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,heroFragment)
                .addToBackStack("back_to_list_heroes")
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d("fragment interaction", uri.getPath());
    }

    @Override
    public void onClickHeroListener() {
        this.OpenHeroFragment();
    }

    @Override
    public void onClickFavoriteListener() {
        this.OpenFavoriteFragment();
    }
}
