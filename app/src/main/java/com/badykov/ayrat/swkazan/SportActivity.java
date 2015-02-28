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


public class SportActivity extends ActionBarActivity {

    private static final String[] sportNames={"Воркаут","Футбол","Баскетбол","Беговые дорожки"};
    private static final int[] sportImages={R.drawable.workout, R.drawable.soccer, R.drawable.basketball, R.drawable.running};
    private ListView toPopulateWithDisticts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        setDistrictName();
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
        actionbarTextView.setText(R.string.sport_select);

        actionbarImageView.setImageResource(R.drawable.sport);
        actionBar.setCustomView(actionbarView,
                new ActionBar.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                )
        );



    }

    private void populateListviewWithDistricts(){

        toPopulateWithDisticts = (ListView) findViewById(R.id.list_view);
        ArrayList<NamedImage> sports=getSportsNamesWithImages();

        TextWithImageAdapter adapter= new TextWithImageAdapter(this,R.layout.simpletextitem, sports);

        toPopulateWithDisticts.setAdapter(adapter);

    }



    private ArrayList<NamedImage> getSportsNamesWithImages(){
        ArrayList<NamedImage> sports=new ArrayList<NamedImage>();
        for (int i=0;i<sportNames.length;i++){
            NamedImage ni=new NamedImage(sportNames[i],sportImages[i]);
            sports.add(ni);
        }
        return sports;
    }

    private void setOnListViewItemClickAction() {

        toPopulateWithDisticts.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent startedIntent=getIntent();
                String districtName=startedIntent.getStringExtra("DistrictName");
                NamedImage clickedItem=(NamedImage)parent.getItemAtPosition(position);
                String sportName=clickedItem.getName();
                Intent intent = new Intent(SportActivity.this, GroundActivity.class);
                intent.putExtra("DistrictName",districtName);
                intent.putExtra("SportName",sportName);
                SportActivity.this.startActivity(intent);


            }

        });
    }

    private void setDistrictName(){
        Intent startedIntent=getIntent();
        String districtName=startedIntent.getStringExtra("DistrictName");
        TextView toShowDistrictName=(TextView)findViewById(R.id.textfordistrict);
        toShowDistrictName.setText(districtName);
    }

    public void onDistrictClick(View v){

        Intent intent = new Intent(SportActivity.this, DistrictActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        SportActivity.this.startActivity(intent);

    }





}
