package com.speechry.timeshake;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.speechry.timeshake.DB.TimeShakeDataMgmt;
import com.speechry.timeshake.Models.Geofence;

public class Storage extends AppCompatActivity implements View.OnClickListener
{
    private TimeShakeDataMgmt datasource;
    private Button btnCreateDB;
    private Button btnClearnSample;
    private Button select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnCreateDB = findViewById(R.id.btnCeate);
        Button btnClrnSample = findViewById(R.id.btnCLRnInsert);
        Button btnSelect = findViewById(R.id.btnSelect);

        btnCreateDB.setOnClickListener(this);
        btnClrnSample.setOnClickListener(this);
        btnSelect.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.btnCeate)
        {
            datasource = new TimeShakeDataMgmt(this);
            datasource.open(); //This will create the DB

            //now insert a sample row

            datasource.createGeofence(new Geofence("TestLat","Test:lon","Sample Geofence","Dec31,2018","1"));
            datasource.close();

        }

        if (view.getId() == R.id.btnCLRnInsert) //now this only clears the db
        {
            datasource = new TimeShakeDataMgmt(this);
            datasource.open(); //This will create the DB
            //now insert a sample row
           datasource.clearGeofences();
            datasource.close();

        }



    }
}
