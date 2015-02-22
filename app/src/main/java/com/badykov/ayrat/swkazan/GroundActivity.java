package com.badykov.ayrat.swkazan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class GroundActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ground_activity);
        setDistrictName();
        setSportName();

    }

    private void setDistrictName(){
        Intent startedIntent=getIntent();
        String districtName=startedIntent.getStringExtra("DistrictName");
        TextView toShowDistrictName=(TextView)findViewById(R.id.text);
        toShowDistrictName.setText(districtName);
    }
    private void setSportName(){
        Intent startedIntent=getIntent();
        String sportName=startedIntent.getStringExtra("SportName");
        TextView toShowDistrictName=(TextView)findViewById(R.id.text1);
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
