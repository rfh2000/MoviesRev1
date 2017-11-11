package com.richardpendlebury.android.moviesrev1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.richardpendlebury.android.moviesrev1.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.ViewHolder> {

    private Context mContext;
    private List<Movie> mMovies;

    MovieRecyclerAdapter(Context context, List<Movie> movies) {
        this.mContext = context;
        this.mMovies = movies;
    }

    @Override
    public MovieRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieRecyclerAdapter.ViewHolder holder, int position) {
        final Movie movie = mMovies.get(position);
        Picasso.with(mContext)
                .load(buildPosterImageString(movie.getPosterPath()))
                .into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.movie_items_image_view);
        }
    }

    private String buildPosterImageString(String posterRelativePath){
        final String BASE_URL = "http://image.tmdb.org/t/p/";
        final String DEVICE_SIZE = "w185";
        return BASE_URL + DEVICE_SIZE + posterRelativePath;
    }
}
