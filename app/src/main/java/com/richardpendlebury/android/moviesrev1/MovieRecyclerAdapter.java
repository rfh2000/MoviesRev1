package com.richardpendlebury.android.moviesrev1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.richardpendlebury.android.moviesrev1.model.Movie;

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
        holder.tv1.setText(movie.getTitle());
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1;
        ViewHolder(View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.textview1);
        }
    }
}
