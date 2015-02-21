package com.badykov.ayrat.swkazan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ayrat on 2/17/15.
 */
public class TextWithImageAdapter extends ArrayAdapter<NamedImage> {

    private Context context;
    private ArrayList<NamedImage> items;

    public TextWithImageAdapter(Context context, int resourceID, ArrayList<NamedImage> items) {

        super(context, resourceID, items);
        this.items=items;
        this.context=context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewToPrintData = convertView;

        if (convertView == null) {

            viewToPrintData  = LayoutInflater.from(getContext()).inflate(R.layout.itemwithimage, parent, false);

        }

        NamedImage currentItem = getItem(position);

        if (currentItem !=null) {

            TextView toPrint = (TextView) viewToPrintData.findViewById(R.id.text);
            ImageView toShowImage = (ImageView) viewToPrintData.findViewById(R.id.image);
            toPrint.setText(currentItem.getName());
            toShowImage.setImageResource(currentItem.getImage());

        }

        return viewToPrintData;
    }
}
