package com.richardpendlebury.android.moviesrev1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class MovieDetailsActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MovieDetailsActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.movie_detail_container, MovieDetailsFragment.newInstance(getJsonStringFromIntent(getIntent())))
                    .commit();
        }
    }

    private String getJsonStringFromIntent(Intent intent) {
        return intent.getStringExtra("MOVIE_JSON");
    }

}
