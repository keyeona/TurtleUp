package com.keyeonacole.turtleup;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders>{
    private List<Fact> factList;
    protected Context context;
    private View.OnClickListener mOnClickListener;


    public RecyclerViewAdapter(Context context, List<Fact> factList){
        this.factList = factList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolders viewHolders = null;
        mOnClickListener = new MyOnClickListener();
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fact_favorites_row, parent, false);
        viewHolders = new RecyclerViewHolders(layout, factList);
        layout.setOnClickListener(mOnClickListener);

        return viewHolders;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolders holder, int position) {
        if(factList.get(position).getImageLink().isEmpty()){
            holder.imageView.setImageResource(R.drawable.moti_transparent);
        }else{
            Picasso.get().load(factList.get(position).getImageLink()).placeholder(R.drawable.moti_transparent).error(R.drawable.moti_transparent).into(holder.imageView);
        }
        holder.titleTextView.setText(factList.get(position).getTitle());
        //TODO: Change this from id to a mini description
        holder.rowDescriptionTextView.setText(factList.get(position).getApplication());
    }

    @Override
    public int getItemCount() {
        return this.factList.size();
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            android.support.v4.app.FragmentManager manager = ((FragmentActivity)context).getSupportFragmentManager() ;
            FragmentTransaction ft = manager.beginTransaction();

            try {
                FactsFragment factsFragment = new FactsFragment();
                ft.replace(R.id.fragmentContainerMain, factsFragment);
                ft.addToBackStack(null);
                ft.commit();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void passBundle (Fact fact){
        Bundle bundle = new Bundle();
        bundle.putSerializable("fact", fact);
        }

}
