package com.badykov.ayrat.swkazan;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ayrat on 2/23/15.
 */
public class SportRecycleViewAdapter extends RecyclerView.Adapter<SportRecycleViewAdapter.ViewHolder> {

    private ArrayList<NamedImage> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CardView mCardView;
        public TextView mTextView;
        public ImageView mImageView;
        public ViewHolder(View v) {
            super(v);
            mCardView = (CardView)v.findViewById(R.id.card_view);
            mTextView=(TextView)mCardView.findViewById(R.id.text);
            mImageView=(ImageView)mCardView.findViewById(R.id.image);
        }



    }

    public SportRecycleViewAdapter(ArrayList<NamedImage> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public SportRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                  int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sport_card, parent,false);


        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position).getName());
        holder.mImageView.setImageResource(mDataset.get(position).getImage());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
