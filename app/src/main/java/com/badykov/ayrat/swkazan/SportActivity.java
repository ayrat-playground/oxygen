package com.badykov.ayrat.swkazan;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
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


public class SportActivity extends ActionBarActivity {

    private static final String[] sportNames={"Воркаут","Футбол","Баскетбол","Беговые дорожки"};
    private static final int[] sportImages={R.drawable.workout, R.drawable.soccer, R.drawable.basketball, R.drawable.running};
    private RecyclerView recyclerViewtoShowCardsOfSports;
    private RecyclerView.Adapter adapterForRecyclerView;
    private RecyclerView.LayoutManager layoutManagerForRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        setDistrictName();
        customizeActionBar();
        setRecyclerView();
        setOnRecyclerViewClick();

    }

    private void setRecyclerView(){

        ArrayList<NamedImage> sports=getSportsNamesWithImages();

        recyclerViewtoShowCardsOfSports= (RecyclerView) findViewById(R.id.sport_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerViewtoShowCardsOfSports.setHasFixedSize(true);

        // use a linear layout manager
        layoutManagerForRecyclerView = new LinearLayoutManager(this);
        recyclerViewtoShowCardsOfSports.setLayoutManager(layoutManagerForRecyclerView);

        // specify an adapter (see also next example)

        adapterForRecyclerView = new SportRecycleViewAdapter(sports);
        recyclerViewtoShowCardsOfSports.setAdapter(adapterForRecyclerView);

    }

    private void setOnRecyclerViewClick(){
        recyclerViewtoShowCardsOfSports.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent startedIntent=getIntent();
                        String districtName=startedIntent.getStringExtra("DistrictName");
                        String sportName=sportNames[position];
                        Intent intent = new Intent(SportActivity.this, GroundActivity.class);
                        intent.putExtra("DistrictName",districtName);
                        intent.putExtra("SportName",sportName);
                        SportActivity.this.startActivity(intent);

                    }
                })
        );

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




    private ArrayList<NamedImage> getSportsNamesWithImages(){
        ArrayList<NamedImage> sports=new ArrayList<NamedImage>();
        for (int i=0;i<sportNames.length;i++){
            NamedImage ni=new NamedImage(sportNames[i],sportImages[i]);
            sports.add(ni);
        }
        return sports;
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
