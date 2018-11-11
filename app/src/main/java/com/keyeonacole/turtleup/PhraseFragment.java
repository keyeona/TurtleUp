package com.keyeonacole.turtleup;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhraseFragment extends Fragment{
    @BindView(R.id.motivation_text_contents)
    TextView motivationTV;

    public PhraseFragment() throws IOException {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_phrase, container, false);
        ButterKnife.bind(this, rootView);
        getPhrase();
        return rootView;
    }

    private void getPhrase() {
        LocalPharases phrases = new LocalPharases();
        int count = phrases.getPhraseCounts(getContext());
        Random r = new Random();
        int i1 = r.nextInt(count - 0);
        String randomPhrase = phrases.getPhrase(i1, getContext());
        motivationTV.setText(randomPhrase);
    }
}
