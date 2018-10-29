package com.keyeonacole.turtleup;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;

import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends Fragment {

    @BindString(R.string.facts_string_id) String facts_string_id;
    @BindString(R.string.bundle_button_id_label) String bundle_button_label;
    @BindString(R.string.favorites_string_id) String favorites_string_id;
    public static Bundle myBundle = null;

    public MainFragment() throws IOException {
        // Required empty public constructor
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.turtle_fact_btn)
    public void Facts(){
        myBundle = new Bundle();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        try {
            RecyclerViewFragment recyclerViewFragment = new RecyclerViewFragment();
            myBundle.putString(bundle_button_label,facts_string_id);
            recyclerViewFragment.setArguments(myBundle);
            ft.replace(R.id.fragmentContainerMain, recyclerViewFragment);
            ft.addToBackStack(null);
            ft.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @OnClick(R.id.favorite_turtle_btn)
    public void Favorites() {
        myBundle = new Bundle();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        try {
            RecyclerViewFragment recyclerViewFragment = new RecyclerViewFragment();
            myBundle.putString(bundle_button_label,favorites_string_id);
            recyclerViewFragment.setArguments(myBundle);
            ft.replace(R.id.fragmentContainerMain, recyclerViewFragment);
            ft.addToBackStack(null);
            ft.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.moti_talks_btn)
    public void MotiTalks(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        try {
            PhraseFragment phraseFragment = new PhraseFragment();
            ft.replace(R.id.fragmentContainerMain, phraseFragment);
            ft.addToBackStack(null);
            ft.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @OnClick(R.id.widget_instruction_btn)
    public void WidgetInstructions(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        try {
            WidgetInstructionFragment widgetInstructionFragment = new WidgetInstructionFragment();
            ft.replace(R.id.fragmentContainerMain, widgetInstructionFragment);
            ft.addToBackStack(null);
            ft.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.credit_btn)
    public void Credit(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        try {
            CreditsFragment creditsFragment = new CreditsFragment();
            ft.replace(R.id.fragmentContainerMain, creditsFragment);
            ft.addToBackStack(null);
            ft.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
