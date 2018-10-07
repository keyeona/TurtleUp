package com.keyeonacole.turtleup;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class RecyclerViewHolders extends RecyclerView.ViewHolder {
    @BindView(R.id.go_image) ImageView imageView;
    @BindView(R.id.row_title) TextView titleTextView;
    private  List<Fact> factList;
    @BindView(R.id.row_description) TextView rowDescriptionTextView;

    public RecyclerViewHolders(View layout, List<Fact> factList) {
        super(layout);
        ButterKnife.bind(this, itemView);
        this.factList = factList;
    }
}
