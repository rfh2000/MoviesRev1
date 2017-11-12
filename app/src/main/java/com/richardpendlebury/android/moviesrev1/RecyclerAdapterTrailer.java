package com.richardpendlebury.android.moviesrev1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.richardpendlebury.android.moviesrev1.model.Trailer;

import java.util.List;

public class RecyclerAdapterTrailer extends RecyclerView.Adapter<RecyclerAdapterTrailer.ViewHolder>{

    private static final String LOG_TAG = "RecyclerAdapterTrailer";
    private Context mContext;
    private List<Trailer> mTrailers;

    RecyclerAdapterTrailer(Context context, List<Trailer> trailers) {
        this.mContext = context;
        this.mTrailers = trailers;
    }

    @Override
    public RecyclerAdapterTrailer.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_trailer_list_row, parent, false);
        return new RecyclerAdapterTrailer.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapterTrailer.ViewHolder holder,int position){
        final Trailer trailer = mTrailers.get(position);
        holder.tvHeader.setText(trailer.getName());
    }

    @Override
    public int getItemCount(){
        return mTrailers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvHeader;
        ViewHolder(View itemView) {
            super(itemView);
            tvHeader = itemView.findViewById(R.id.recycler_trailer_list_row_tv_header);
        }
    }

}
