package com.richardpendlebury.android.moviesrev1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MovieDetailsFragment extends Fragment {

    private static final String LOG_TAG = "MovieDetailsFragment";
    private static final String MOVIE_JSON = "movie_json";

    private String mMovieJson;

    public MovieDetailsFragment() {
    }

    public static MovieDetailsFragment newInstance(String movieJson) {
        MovieDetailsFragment movieDetailsFragment = new MovieDetailsFragment();
        Bundle args = new Bundle();
        args.putString(MOVIE_JSON, movieJson);
        movieDetailsFragment.setArguments(args);
        return movieDetailsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMovieJson = getArguments().getString(MOVIE_JSON);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie_details, container, false);
        TextView tv = rootView.findViewById(R.id.fragment_movie_details_tv);
        tv.setText(mMovieJson);
        return rootView;
    }
}
