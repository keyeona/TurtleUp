package com.keyeonacole.turtleup;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FactsFragment extends Fragment {
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
    @BindString(R.string.n_a)
    String na;

    @BindView(R.id.fact_imageView)
    ImageView image;
    @BindView(R.id.fact_scientific_name)
    TextView scientificNameTextView;
    @BindView(R.id.fact_fact)
    TextView factTextView;
    @BindView(R.id.fact_application) TextView applicationTextView;
    @BindView(R.id.fact_diet) TextView dietTextView;
    @BindView(R.id.fact_location) TextView locationTextView;
    @BindView(R.id.fact_pet_rating) TextView petRatingTextView;
    @BindView(R.id.fact_type) TextView typeTextView;
    @BindView(R.id.fact_name) TextView nameTextView;

    String title;
    String type;
    String imageLink;
    String fact;
    ArrayList<String> locations;
    String diet;
    String petRating;
    String scientificName;
    String landOrSea;
    String id;
    String application;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fact, container, false);
        ButterKnife.bind(this, rootView);
        Bundle factBundle = getArguments();
        prepareDataFromArgument(factBundle);
        return rootView;
    }

    private void prepareDataFromArgument(Bundle factBundle) {


        title = factBundle.getString(nameQuery);
        type = factBundle.getString(typeQuery);
        imageLink = factBundle.getString(imageQuery);
        fact = factBundle.getString(factQuery);
        locations = factBundle.getStringArrayList(locationsQuery);
        diet = factBundle.getString(dietQuery);
        petRating = factBundle.getString(petRatingQuery);
        scientificName = factBundle.getString(scientificNameQuery);
        landOrSea = factBundle.getString(landOrSeaQuery);
        id = factBundle.getString(idQuery);
        application = factBundle.getString(applicationQuery);

        if(imageLink.isEmpty()){
            image.setImageResource(R.drawable.moti_transparent);
        }else{
            Picasso.get().load(imageLink).placeholder(R.drawable.moti_transparent).error(R.drawable.moti_transparent).into(image);

        }

        Log.d("DataBase", fact);

        if(fact.isEmpty()){
            factTextView.setText(na);
        }else {
            factTextView.setText(fact);
        }

        if(diet.isEmpty()){
            dietTextView.setText(na);
        }else {
            dietTextView.setText(diet);
        }

        if(petRating.isEmpty()){
            petRatingTextView.setText(na);
        }else {
            petRatingTextView.setText(petRating);
        }

        if(scientificName.isEmpty()){
            scientificNameTextView.setText(na);
        }else {
            scientificNameTextView.setText(scientificName);
        }

        if(application.isEmpty()){
            applicationTextView.setText(na);
        }else {
            applicationTextView.setText(application);
        }

        if(type.isEmpty()){
            typeTextView.setText(na);
        }else {
            typeTextView.setText(type);
        }

        if(title.isEmpty()){
            nameTextView.setText(na);
        }else {
            nameTextView.setText(title);
        }

    }


    @OnClick(R.id.addToFavoritesBTN)
    public void addtoFavorites(){


    }


}
