package com.sully.fragmentcallback;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FilmListFragment extends Fragment {

    View rootView;
    ListView lvFilm;
    ArrayAdapter<String> filmNamesAdapter;
    Context context;
    String[] filmTitles;
    OnFilmSelectedListener onFilmSelectedListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_film_list, container, false);

        initUI();

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar()
                .setTitle(getString(R.string.app_name) + " -> Choisir un film");
    }

    private void addFilmFragment(){

    }

    public void setOnFilmSelectedListener(OnFilmSelectedListener onFilmSelectedListener ){
        this.onFilmSelectedListener = onFilmSelectedListener;
    }

    private void initUI(){
        context = getContext();
        filmTitles = getResources().getStringArray(R.array.film);
        lvFilm = (ListView)rootView.findViewById(R.id.lv_Film);
        //Récupération des valeurs du tableau film
        //Init l'adapter liant les films à la ListView "lvFilm"
        filmNamesAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, filmTitles);
        lvFilm.setAdapter(filmNamesAdapter);
        //Set the on click listener for the list of film titles
        lvFilm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(onFilmSelectedListener != null){
//                    onFilmSelectedListener.onFilmSelected(filmTitles[position]);
                    Bundle bundle = new Bundle();
                    bundle.putInt(OnFilmSelectedListener.ACTION_KEY, OnFilmSelectedListener.ACTION_VALUE_FILM_SELECTED);
                    bundle.putString(OnFilmSelectedListener.KEY_SELECTED_FILM, filmTitles[position]);
                    onFilmSelectedListener.onFilmSelected(bundle);
                }
            }
        });
    }
}