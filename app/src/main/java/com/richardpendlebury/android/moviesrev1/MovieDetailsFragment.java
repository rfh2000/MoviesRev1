package com.richardpendlebury.android.moviesrev1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.richardpendlebury.android.moviesrev1.api.ApiClient;
import com.richardpendlebury.android.moviesrev1.api.ApiInterface;
import com.richardpendlebury.android.moviesrev1.model.Movie;
import com.richardpendlebury.android.moviesrev1.model.Review;
import com.richardpendlebury.android.moviesrev1.model.ReviewResponse;
import com.richardpendlebury.android.moviesrev1.model.Trailer;
import com.richardpendlebury.android.moviesrev1.model.TrailerResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailsFragment extends Fragment {

    private static final String LOG_TAG = "MovieDetailsFragment";
    private static final String MOVIE_JSON = "movie_json";

    private String mMovieJson;
    private Movie mLoadedMovie;
    private int mMovieId;
    private List<Review> mReviews;
    private List<Trailer> mTrailers;

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
            mLoadedMovie = new Gson().fromJson(mMovieJson, Movie.class);
            mMovieId = mLoadedMovie.getId();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie_details, container, false);
        TextView tv = rootView.findViewById(R.id.fragment_movie_details_tv);
        tv.setText(mMovieJson);
        initReviewListApiCall();
        initTrailerListApiCall();
        return rootView;
    }

    private void initTrailerListApiCall() {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<TrailerResponse> call = apiService.getTrailers(mMovieId, BuildConfig.TMDB_API_KEY);
        call.enqueue(new Callback<TrailerResponse>() {
            @Override
            public void onResponse(@NonNull Call<TrailerResponse> call, @NonNull Response<TrailerResponse> response) {
                //noinspection ConstantConditions
                mTrailers = response.body().getResults();
            }
            @Override
            public void onFailure(@NonNull Call<TrailerResponse> call, @NonNull Throwable t) {
                // Log error here since request failed
                Log.e(LOG_TAG, t.toString());
            }
        });
    }

    private void initReviewListApiCall() {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<ReviewResponse> call = apiService.getReviews(mMovieId, BuildConfig.TMDB_API_KEY);
        call.enqueue(new Callback<ReviewResponse>() {
            @Override
            public void onResponse(@NonNull Call<ReviewResponse> call, @NonNull Response<ReviewResponse> response) {
                //noinspection ConstantConditions
                mReviews = response.body().getResults();
            }
            @Override
            public void onFailure(@NonNull Call<ReviewResponse> call, @NonNull Throwable t) {
                // Log error here since request failed
                Log.e(LOG_TAG, t.toString());
            }
        });
    }
}
