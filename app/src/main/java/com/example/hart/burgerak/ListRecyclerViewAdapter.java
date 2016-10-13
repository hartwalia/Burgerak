package com.example.hart.burgerak;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hart.burgerak.model.Stall;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rashi on 1/10/2016.
 */

public class ListRecyclerViewAdapter extends RecyclerView.Adapter {
    private List<Stall> mStallList = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { // What happens when a viewholder is created
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_viewholder, parent, false); // This is android's layout

        ListViewHolder viewHolder = new ListViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ListViewHolder listViewHolder = (ListViewHolder) holder; // If using own layout with a lot of things, make sure findView by ID

        listViewHolder.setStall(mStallList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mStallList.size();
    }

    public void setStallList(List<Stall> stallList) {
        mStallList = stallList;
    }
}
