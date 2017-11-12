package com.richardpendlebury.android.moviesrev1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class RecyclerAdapterTrailer extends RecyclerView.Adapter<RecyclerAdapterTrailer.ViewHolder>{

    @Override
    public RecyclerAdapterTrailer.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            return null;
            }

    @Override
    public void onBindViewHolder(RecyclerAdapterTrailer.ViewHolder holder,int position){

    }

    @Override
    public int getItemCount(){
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
