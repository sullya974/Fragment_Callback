package com.sully.fragmentcallback;

import android.os.Bundle;

public interface OnFilmSelectedListener {
    String KEY_SELECTED_FILM = "KEY_SELECTED_FILM";
    String ACTION_KEY = "action_key";
    int ACTION_VALUE_FILM_SELECTED = 1;
    //    void onFilmSelected(String film);
    void onFilmSelected(Bundle bundle);
}
