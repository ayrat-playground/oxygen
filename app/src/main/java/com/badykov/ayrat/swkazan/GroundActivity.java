package com.badykov.ayrat.swkazan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class GroundActivity extends ActionBarActivity {
    private Intent intentThatStartedThisActivity;
    private RecyclerView recyclerViewtoShowCardsOfGrounds;
    private RecyclerView.Adapter adapterForRecyclerView;
    private RecyclerView.LayoutManager layoutManagerForRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ground_activity);
        intentThatStartedThisActivity=getIntent();
        setRecyclerView();
        setDistrictName();
        setSportName();

    }


    private void setRecyclerView(){

        recyclerViewtoShowCardsOfGrounds= (RecyclerView) findViewById(R.id.ground_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerViewtoShowCardsOfGrounds.setHasFixedSize(true);

        // use a linear layout manager
        layoutManagerForRecyclerView = new LinearLayoutManager(this);
        recyclerViewtoShowCardsOfGrounds.setLayoutManager(layoutManagerForRecyclerView);

        // specify an adapter (see also next example)
        String[] data={"Rocknroll", "Rock","Punk"};
        adapterForRecyclerView = new GroundRecycleViewAdapter(data);
        recyclerViewtoShowCardsOfGrounds.setAdapter(adapterForRecyclerView);

    }

    private void setDistrictName(){

        String districtName=intentThatStartedThisActivity.getStringExtra("DistrictName");
        TextView toShowDistrictName=(TextView)findViewById(R.id.textfordistrict);
        toShowDistrictName.setText(districtName);
    }
    private void setSportName(){

        String sportName=intentThatStartedThisActivity.getStringExtra("SportName");
        TextView toShowDistrictName=(TextView)findViewById(R.id.textforsport);
        toShowDistrictName.setText(sportName);
    }

    public void onDistrictClick(View v){

        Intent intent = new Intent(GroundActivity.this, DistrictActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        GroundActivity.this.startActivity(intent);

    }

    public void onSportClick(View v){
        Intent startedIntent=getIntent();
        Intent intent = new Intent(GroundActivity.this, SportActivity.class);
        String districtName=startedIntent.getStringExtra("DistrictName");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("DistrictName",districtName);
        GroundActivity.this.startActivity(intent);

    }



}
