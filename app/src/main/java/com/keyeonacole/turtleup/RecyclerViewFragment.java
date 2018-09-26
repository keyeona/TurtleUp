package com.keyeonacole.turtleup;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;

import butterknife.BindString;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class RecyclerViewFragment extends Fragment {
    @BindString(R.string.turtle_facts_from_db) String dbFactsKey;
    @BindString(R.string.tag_message) String valueIsMessage;
    @BindString(R.string.failed_to_read) String failedToRead;
    @BindString(R.string.bundle_button_id_label) String bundle_button_label;
    @BindString(R.string.facts_string_id) String facts_string_id;


    public static Bundle myBundle = null;

    public RecyclerViewFragment() throws IOException {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        //TODO: Do I initalize here
        FirebaseApp.initializeApp(getActivity().getApplicationContext());
        ButterKnife.bind(this,rootView);
        myBundle = this.getArguments();
        getButtonId(myBundle);
        return rootView;
    }

    private void getButtonId(Bundle myBundle) {
        if (myBundle != null) {
            String buttonid = myBundle.getString(bundle_button_label);
            actionsBasedOnId(buttonid);
        }
    }

    private void actionsBasedOnId(String buttonid) {
        if (buttonid == facts_string_id){
            GetTurtleFacts();
        }else {
            GetFavoritesID();
        }
    }

    private void GetFavoritesID() {
        //TODO: Dont forget I am here
    }


    public void GetTurtleFacts(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(dbFactsKey);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, valueIsMessage + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, failedToRead, error.toException());
            }
        });
    }
}
