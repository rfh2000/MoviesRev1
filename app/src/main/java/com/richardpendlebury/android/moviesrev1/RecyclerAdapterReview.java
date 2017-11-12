package com.richardpendlebury.android.moviesrev1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.richardpendlebury.android.moviesrev1.model.Review;

import java.util.List;

public class RecyclerAdapterReview extends RecyclerView.Adapter<RecyclerAdapterReview.ViewHolder> {

    private static final String LOG_TAG = "RecyclerAdapterReview";
    private Context mContext;
    private List<Review> mReviews;

    RecyclerAdapterReview(Context context, List<Review> reviews) {
        this.mContext = context;
        this.mReviews = reviews;
    }

    @Override
    public RecyclerAdapterReview.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_review_list_row, parent, false);
        return new RecyclerAdapterReview.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapterReview.ViewHolder holder, int position) {
        final Review review = mReviews.get(position);
        holder.tvHeader.setText(review.getAuthor());
    }

    @Override
    public int getItemCount() {
        return mReviews.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvHeader;
        ViewHolder(View itemView) {
            super(itemView);
            tvHeader = itemView.findViewById(R.id.recycler_review_list_row_tv_header);
        }
    }

}
