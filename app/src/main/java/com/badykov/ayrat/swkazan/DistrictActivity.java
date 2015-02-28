package com.badykov.ayrat.swkazan;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class DistrictActivity extends ActionBarActivity {



    private static final String[] districtNames={"Авиастроительный","Вахитовский","Кировский","Московский","Ново-Савиновский","Приволжский","Советский"};
    private RecyclerView recyclerViewtoShowCardsOfDistricts;
    private RecyclerView.Adapter adapterForRecyclerView;
    private RecyclerView.LayoutManager layoutManagerForRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_district);


        customizeActionBar();
        setRecyclerView();
        setOnRecyclerViewClick();

    }

    private void setRecyclerView(){


        recyclerViewtoShowCardsOfDistricts = (RecyclerView) findViewById(R.id.district_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerViewtoShowCardsOfDistricts.setHasFixedSize(true);

        // use a linear layout manager
        layoutManagerForRecyclerView = new LinearLayoutManager(this);
        recyclerViewtoShowCardsOfDistricts.setLayoutManager(layoutManagerForRecyclerView);

        // specify an adapter (see also next example)

        adapterForRecyclerView = new SimpleStringRecycleViewAdapter(districtNames);
        recyclerViewtoShowCardsOfDistricts.setAdapter(adapterForRecyclerView);

    }
    private void customizeActionBar(){
        LayoutInflater mInflater = LayoutInflater.from(this);
        View actionbarView = mInflater.inflate(R.layout.action_bar, null);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayOptions(
                ActionBar.DISPLAY_SHOW_CUSTOM, ActionBar.DISPLAY_SHOW_CUSTOM |
                        ActionBar.DISPLAY_SHOW_HOME |
                        ActionBar.DISPLAY_SHOW_TITLE);




        TextView actionbarTextView=(TextView)actionbarView.findViewById(R.id.text);
        ImageView actionbarImageView=(ImageView)actionbarView.findViewById(R.id.image);
        actionbarTextView.setText(R.string.district_select);

        actionbarImageView.setImageResource(R.drawable.district);
        actionBar.setCustomView(actionbarView,
                new ActionBar.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                )
        );



    }

    private void setOnRecyclerViewClick(){
        recyclerViewtoShowCardsOfDistricts.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent = new Intent(DistrictActivity.this, SportActivity.class);
                        String clickedDistrictName =districtNames[position];
                        intent.putExtra("DistrictName",clickedDistrictName);
                        DistrictActivity.this.startActivity(intent);

                    }
                })
        );

    }




   /* */




}
