package com.badykov.ayrat.swkazan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ayrat on 2/15/15.
 */
public class OneLineStringAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<String> items;

    public OneLineStringAdapter(Context context, int resourceID, ArrayList<String> items) {

        super(context, resourceID, items);
        this.items=items;
        this.context=context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewToPrintData = convertView;

        if (convertView == null) {

            viewToPrintData  = LayoutInflater.from(getContext()).inflate(R.layout.simpletextitem, parent, false);

        }

        String currentString = getItem(position);

        if (currentString !=null) {

            TextView toPrint = (TextView) viewToPrintData.findViewById(R.id.text);

            toPrint.setText(currentString);
        }

        return viewToPrintData;
    }
}
