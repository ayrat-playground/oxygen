package com.badykov.ayrat.swkazan;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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
    private ListView toPopulateWithDisticts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_district);

        populateListviewWithDistricts();
        setOnListViewItemClickAction();
        customizeActionBar();

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

    private void populateListviewWithDistricts(){

        toPopulateWithDisticts = (ListView) findViewById(R.id.list_view);

        ArrayList<String> districtNamesAsArray=getArrayListFromStringArray(districtNames);

        OneLineStringAdapter sa= new OneLineStringAdapter(this,R.layout.simpletextitem, districtNamesAsArray);

        toPopulateWithDisticts.setAdapter(sa);

    }

    private void setOnListViewItemClickAction(){

        toPopulateWithDisticts.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(DistrictActivity.this, SportActivity.class);
                String clickedDistrictName =(String) parent.getItemAtPosition(position);
                intent.putExtra("DistrictName",clickedDistrictName);
                DistrictActivity.this.startActivity(intent);


            }

        });

    }




    private ArrayList<String> getArrayListFromStringArray(String[] stringArray){

       return  new ArrayList<String>(Arrays.asList(stringArray));

    }



}
