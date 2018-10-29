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

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CreditsFragment extends Fragment {
    @BindView(R.id.credits_text_view)
    TextView credits;
    @BindString(R.string.credit_list)
    String credit;
    public CreditsFragment() throws IOException {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_credits, container, false);
        ButterKnife.bind(this, rootView);
        credits.setText(credit);
        return rootView;
    }
}
