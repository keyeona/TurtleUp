package com.keyeonacole.turtleup;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders>{
    private List<Fact> factList;
    protected Context context;
    private View.OnClickListener mOnClickListener;
    private int mposition;

    @BindString(R.string.nameQuery)
    String nameQuery;
    @BindString(R.string.dietQuery)
    String dietQuery;
    @BindString(R.string.factQuery)
    String factQuery;
    @BindString(R.string.idQuery)
    String idQuery;
    @BindString(R.string.imageQuery)
    String imageQuery;
    @BindString(R.string.landOrSeaQuery)
    String landOrSeaQuery;
    @BindString(R.string.locationsQuery)
    String locationsQuery;
    @BindString(R.string.petRatingQuery)
    String petRatingQuery;
    @BindString(R.string.scientificNameQuery)
    String scientificNameQuery;
    @BindString(R.string.typeQuery)
    String typeQuery;
    @BindString(R.string.applicationQuery)
    String applicationQuery;


    public RecyclerViewAdapter(Context context, List<Fact> factList){
        this.factList = factList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolders viewHolders = null;
        Log.d("FromOncreate", String.valueOf(viewType));
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.fact_favorites_row, parent, false);
        viewHolders = new RecyclerViewHolders(layout, factList);
        ButterKnife.bind(this, layout);
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
        holder.rowDescriptionTextView.setText(factList.get(position).getApplication());
        mOnClickListener = new MyOnClickListener(position);
        holder.imageView.setOnClickListener(mOnClickListener);



    }

    @Override
    public int getItemCount() {
        return this.factList.size();
    }

    private class MyOnClickListener implements View.OnClickListener {
        int itemPostions;
        public MyOnClickListener(int position) {
            itemPostions = position;
        }

        @Override
        public void onClick(View v) {
            ItemClickListener itemClickListener = new ItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Bundle factBundle = passBundle(factList.get(position));
                    android.support.v4.app.FragmentManager manager = ((FragmentActivity)context).getSupportFragmentManager() ;
                    FragmentTransaction ft = manager.beginTransaction();
                    FactsFragment factsFragment = new FactsFragment();
                    factsFragment.setArguments(factBundle);
                    ft.replace(R.id.fragmentContainerMain, factsFragment);
                    ft.addToBackStack(null);
                    ft.commit();
                }
            };
            itemClickListener.onItemClick(v, itemPostions);
        }
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);

    }


    private Bundle passBundle (Fact fact){
        String title;
        String type;
        String imageLink;
        String factString;
        ArrayList<String> locations;
        String diet;
        String petRating;
        String scientificName;
        String landOrSea;
        String id;
        String application;
        Bundle bundle = new Bundle();

        title = fact.getTitle();
        type = fact.getType();
        imageLink = fact.getImageLink();
        factString = fact.getFact();
        locations = fact.getLocations();
        diet = fact.getDiet();
        petRating = fact.getPetRating();
        scientificName = fact.getScientificName();
        landOrSea = fact.getLandOrSea();
        id = fact.getId();
        application = fact.getApplication();

        bundle.putString(nameQuery, title);
        bundle.putString(typeQuery, type);
        bundle.putString(imageQuery, imageLink);
        bundle.putString(factQuery, factString);
        bundle.putStringArrayList(locationsQuery, locations);
        bundle.putString(dietQuery, diet);
        bundle.putString(petRatingQuery, petRating);
        bundle.putString(scientificNameQuery, scientificName);
        bundle.putString(locationsQuery, landOrSea);
        bundle.putString(idQuery, id);
        bundle.putString(applicationQuery, application);

        return bundle;
        }

}
