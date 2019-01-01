package com.speechry.timeshake.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.renderscript.Sampler;
import android.util.Log;

import com.speechry.timeshake.Models.Geofence;

import java.util.List;

public class TimeShakeDataMgmt
{
    private static final String TAG =   TimeShakeDataMgmt.class.getSimpleName();

    private SQLiteDatabase database;
    private TimeShakeSQLiteOpenHelper dbhelper;

    public TimeShakeDataMgmt(Context context)
    {
        this.dbhelper = new TimeShakeSQLiteOpenHelper(context);

    }

    public void open()
    {
        this.database = dbhelper.getWritableDatabase();
        Log.d(TAG, "Database is open");
    }

    public void close()
    {
        dbhelper.close();
        Log.d(TAG, "Database is closed");
    }

    public void createGeofence(Geofence geofence)
    {
        ContentValues values  = new ContentValues();
        values.put(TimeShakeDBContract.GeofenceEntry.COLUMN_LAT, geofence.getLat());
        values.put(TimeShakeDBContract.GeofenceEntry.COLUMN_LON, geofence.getLon());

        values.put(TimeShakeDBContract.GeofenceEntry.COLUMN_CREATEDON, geofence.getCreatedon());

        values.put(TimeShakeDBContract.GeofenceEntry.COLUMN_GFActive, geofence.isActive());
        values.put(TimeShakeDBContract.GeofenceEntry.COLUMN_LABEL, geofence.getLabel());


        long rowID = database.insert(TimeShakeDBContract.GeofenceEntry.TABLE_NAME,null,values);
        Log.d(TAG, "Geofence created with ID: "+rowID);

    }


    public void clearGeofences()
    {
        database.execSQL(TimeShakeDBContract.CLEAR_GEOFENCE_TABLE);
        Log.d(TAG, "Geofences Cleared");

    }

}
