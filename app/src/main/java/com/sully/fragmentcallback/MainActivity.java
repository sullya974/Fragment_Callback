package com.sully.fragmentcallback;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnFilmSelectedListener {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        addFilmFragment();
    }

    @Override
    public void onFilmSelected(Bundle bundle) {
        addFilmDescriptionFragment(bundle);
    }



    private void addFilmFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        FilmListFragment filmListFragment = new FilmListFragment();
        filmListFragment.setOnFilmSelectedListener(this);
        fragmentTransaction.add(R.id.fragmentContainer, filmListFragment);
        fragmentTransaction.commit();
    }

    private void addFilmDescriptionFragment(Bundle bundle){
        fragmentTransaction  = fragmentManager.beginTransaction();
        FilmDescriptionFragment filmDescriptionFragment = new FilmDescriptionFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(OnFilmSelectedListener.KEY_SELECTED_FILM, filmName);
        fragmentTransaction.replace(R.id.fragmentContainer, filmDescriptionFragment);
        filmDescriptionFragment.setArguments(bundle);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}