package com.keyeonacole.turtleup;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
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
import android.widget.Toast;


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
    @BindString(R.string.database)
    String database_name;
    @BindString(R.string.add_to_message)
    String add_message;
    @BindString(R.string.remove_from_message)
    String remove_message;

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
        Toast.makeText(getContext(), add_message, Toast.LENGTH_SHORT).show();

        final AppDatabase db = Room.databaseBuilder(getContext(),
                AppDatabase.class, database_name).build();
        new AddAsync().execute();

    }

    @OnClick(R.id.removeFromFavoritesBTN)
    public void removeFromFavorites(){
        Toast.makeText(getContext(), remove_message, Toast.LENGTH_SHORT).show();

        final AppDatabase db = Room.databaseBuilder(getContext(),
                AppDatabase.class, database_name).build();
        new RemoveAsync().execute();

    }

    private Fact bundleToFact(Bundle bundle){
        title = bundle.getString(nameQuery);
        type = bundle.getString(typeQuery);
        imageLink = bundle.getString(imageQuery);
        fact = bundle.getString(factQuery);
        locations = bundle.getStringArrayList(locationsQuery);
        diet = bundle.getString(dietQuery);
        petRating = bundle.getString(petRatingQuery);
        scientificName = bundle.getString(scientificNameQuery);
        landOrSea = bundle.getString(landOrSeaQuery);
        id = bundle.getString(idQuery);
        application = bundle.getString(applicationQuery);

        Fact newFact = new Fact(title, type, imageLink, fact, locations, diet, petRating,
                scientificName, landOrSea, application, id);

     return newFact;
    }

    public class AddAsync extends AsyncTask{
        final AppDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(),
                AppDatabase.class, database_name).build();
        @Override
        protected Object doInBackground(Object[] objects) {
            db.factDao().insertSingleFact(bundleToFact(getArguments()));
            return null;
        }
    }

    public class RemoveAsync extends AsyncTask{
        final AppDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(),
                AppDatabase.class, database_name).build();
        @Override
        protected Object doInBackground(Object[] objects) {
            db.factDao().delete(bundleToFact(getArguments()));
            return null;
        }
    }


}
