package com.richardpendlebury.android.moviesrev1.api;

import com.richardpendlebury.android.moviesrev1.model.Movie;
import com.richardpendlebury.android.moviesrev1.model.MoviesResponse;
import com.richardpendlebury.android.moviesrev1.model.ReviewResponse;
import com.richardpendlebury.android.moviesrev1.model.TrailerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<Movie> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("discover/movie")
    Call<MoviesResponse> getMostPopular(@Query("api_key") String apiKey, @Query("sort_by") String sortBy);

    @GET("movie/{id}/reviews")
    Call<ReviewResponse> getReviews(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("movie/{id}/videos")
    Call<TrailerResponse> getTrailers(@Path("id") int id, @Query("api_key") String apiKey);

}
