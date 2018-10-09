package com.keyeonacole.turtleup;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;


public class RecyclerViewFragment extends Fragment {
    @BindString(R.string.turtle_facts_from_db)
    String dbFactsKey;
    @BindString(R.string.tag_message)
    String valueIsMessage;
    @BindString(R.string.failed_to_read)
    String failedToRead;
    @BindString(R.string.bundle_button_id_label)
    String bundle_button_label;
    @BindString(R.string.facts_string_id)
    String facts_string_id;
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
    @BindString(R.string.scroll_state)
    String scrollState;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.Favorites_label)
    TextView favorites_label;


    public static Bundle myBundle = null;

    private LinearLayoutManager linearLayoutManager;
    private List<Fact> allFacts;
    private Parcelable state;

    public RecyclerViewFragment() throws IOException {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        FirebaseApp.initializeApp(getActivity().getApplicationContext());
        ButterKnife.bind(this, rootView);
        allFacts = new ArrayList<Fact>();
        myBundle = this.getArguments();
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        getButtonId(myBundle);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), allFacts);
        recyclerView.setAdapter(recyclerViewAdapter);

        if (savedInstanceState != null) {
            state = savedInstanceState.getParcelable(scrollState);
            recyclerView.getLayoutManager().onRestoreInstanceState(state);

        }
        return rootView;
    }

    private void getButtonId(Bundle myBundle) {
        if (myBundle != null) {
            String buttonid = myBundle.getString(bundle_button_label);
            actionsBasedOnId(buttonid);
        }
    }

    private void actionsBasedOnId(String buttonid) {
        if (buttonid == facts_string_id) {
            GetTurtleFacts();
        } else {
            GetFavoritesID();
        }
    }

    private void GetFavoritesID() {
        //TODO: Dont forget I am here
    }


    public void GetTurtleFacts() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(dbFactsKey);


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) singleSnapshot.getValue();
                    Fact factValues = createFactObjFromMap(map);
                    allFacts.add(factValues);
                }
                populateRV(allFacts);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                //TODO: Dont forget I am here
                Log.d("DataBase", failedToRead, error.toException());
            }
        });
    }

    private void populateRV(List<Fact> allFacts) {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), allFacts);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private Fact createFactObjFromMap(Map object) {
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

        title = (String) object.get(nameQuery);
        type = (String) object.get(typeQuery);
        imageLink = (String) object.get(imageQuery);
        fact = (String) object.get(factQuery);
        locations = (ArrayList<String>) object.get(locationsQuery);
        diet = (String) object.get(dietQuery);
        petRating = (String) object.get(petRatingQuery);
        scientificName = (String) object.get(scientificNameQuery);
        landOrSea = (String) object.get(landOrSeaQuery);
        id = (String) object.get(idQuery);
        application = (String) object.get(applicationQuery);


        Fact factValues = new Fact(title, type, imageLink, fact, locations, diet, petRating,
                scientificName, landOrSea, application, id);

        return factValues;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Parcelable instanceState = recyclerView.getLayoutManager().onSaveInstanceState();
        outState.putParcelable(scrollState, instanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            state = savedInstanceState.getParcelable(scrollState);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (state != null) {
            recyclerView.getLayoutManager().onRestoreInstanceState(state);
        }
    }
}
