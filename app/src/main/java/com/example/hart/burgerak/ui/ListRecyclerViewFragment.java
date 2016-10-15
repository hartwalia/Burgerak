package com.example.hart.burgerak.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hart.burgerak.R;
import com.example.hart.burgerak.controller.ListPopulator;

import static android.content.ContentValues.TAG;

/**
 * Created by Rashi on 1/10/2016.
 */

public class ListRecyclerViewFragment extends Fragment implements ListViewHolder.onNumberSelectedListener{

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_listrecyclerview, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_recyclerview_rv);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        // RecyclerView needs adapter to prepare data items for display in ViewHolders
        ListRecyclerViewAdapter adapter = new ListRecyclerViewAdapter();
        adapter.setStallList(ListPopulator.LoadStall());
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onNumberSelected(int number) {
        Log.d(TAG, "onNumberSelected: ");
    }
}
