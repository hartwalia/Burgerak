package com.example.hart.burgerak.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hart.burgerak.R;
import com.example.hart.burgerak.model.Stall;

/**
 * Created by Rashi on 1/10/2016.
 */

public class ListViewHolder extends RecyclerView.ViewHolder {

    public interface onNumberSelectedListener {
        void onNumberSelected(int number);
    }

    private ImageView mImageView;
    private TextView mNameTextView;
    private TextView mStatusTextView;
    private TextView mDistanceTextView;

    public ListViewHolder(View itemView) {
        super(itemView);
        // Get all the views and assign them
        mImageView = (ImageView) itemView.findViewById(R.id.item_viewholder_iv_name);
        mNameTextView = (TextView) itemView.findViewById(R.id.item_viewholder_tv_name);
        mStatusTextView = (TextView) itemView.findViewById(R.id.item_viewholder_tv_status);
        mDistanceTextView = (TextView) itemView.findViewById(R.id.item_viewholder_tv_distance);
    }

    // Method to set the ViewHolder
    public void setStall(Stall stall, int position) {
        mNameTextView.setText("Name: " + stall.getName() + position);
        mStatusTextView.setText("Status: " + stall.getStatus());
        mDistanceTextView.setText("Distance: " + stall.getDistance());
    }
}