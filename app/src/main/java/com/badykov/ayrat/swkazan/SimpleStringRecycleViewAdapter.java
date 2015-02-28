package com.badykov.ayrat.swkazan;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ayrat on 2/23/15.
 */
public class SimpleStringRecycleViewAdapter extends RecyclerView.Adapter<SimpleStringRecycleViewAdapter.ViewHolder> {

    private String[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CardView mCardView;
        public TextView mTextView;
        public ViewHolder(View v) {
            super(v);
            mCardView = (CardView)v.findViewById(R.id.card_view);
            mTextView=(TextView)mCardView.findViewById(R.id.text);
        }

    }

    public SimpleStringRecycleViewAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public SimpleStringRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.district_card, parent,false);


        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

}
