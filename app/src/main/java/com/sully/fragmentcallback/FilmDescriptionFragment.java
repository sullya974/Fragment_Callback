package com.sully.fragmentcallback;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FilmDescriptionFragment extends Fragment {

    View rootView;
    TextView tvFilmDescription;

    String filmName;
    String filmDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_film_description, container, false);

        initUI();

        return rootView;
    }

    private void initUI(){
        tvFilmDescription = (TextView)rootView.findViewById(R.id.tv_filmDescription);
    }

//    DEPRECATED
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        filmName = bundle.getString(OnFilmSelectedListener.KEY_SELECTED_FILM, "BeetleJuice");
        filmDescription = getString(getFilmId(filmName));
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(filmName);
        tvFilmDescription.setText(filmDescription);
    }

    private int getFilmId(String filmName) {
        HashMap<String, Integer> filmIds = new HashMap<String, Integer>();
        filmIds.put("Beetlejuice", R.string.Beetlejuice);
        filmIds.put("Chat Noir Chat Blanc", R.string.Chat_Noir_Chat_Blanc);
        filmIds.put("Ghost in the Shell", R.string.Ghost_in_the_Shell);
        filmIds.put("Great Teacher Onizuka", R.string.Great_Teacher_Onizuka);
        filmIds.put("La Cité de la peur", R.string.La_Cité_de_la_peur);
        filmIds.put("La Montagne sacrée", R.string.La_Montagne_sacrée);
        filmIds.put("Las Vegas Parano", R.string.Las_Vegas_Parano);

        return filmIds.get(filmName);
    }
}