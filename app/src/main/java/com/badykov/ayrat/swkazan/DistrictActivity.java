package com.badykov.ayrat.swkazan;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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
                Intent intent = new Intent(DistrictActivity.this, SportsActivity.class);
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
