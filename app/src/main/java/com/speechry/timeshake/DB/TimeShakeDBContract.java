package com.speechry.timeshake.DB;

import android.provider.BaseColumns;

public class TimeShakeDBContract {

    static final String CREATE_GEOFENCE_TABLE=
            "CREATE TABLE "+ GeofenceEntry.TABLE_NAME +
                    " ( " +
                    GeofenceEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    GeofenceEntry.COLUMN_LAT + " TEXT NOT NULL, " +
                    GeofenceEntry.COLUMN_LON + " TEXT NOT NULL, " +
                    GeofenceEntry.COLUMN_LABEL + " TEXT, " +
                    GeofenceEntry.COLUMN_CREATEDON + " TEXT NOT NULL, " + //need Datetime
                    GeofenceEntry.COLUMN_GFActive + " TEXT NOT NULL, " +      //need bool
                    "UNIQUE ( "+ GeofenceEntry._ID + ") ON CONFLICT REPLACE )";


    static final String CLEAR_GEOFENCE_TABLE=
            "DELETE FROM " + GeofenceEntry.TABLE_NAME + ";";


    public static class GeofenceEntry implements BaseColumns
    {
        public static final String TABLE_NAME="Geofences";
        public static final String COLUMN_LAT="LocLat";
        public static final String COLUMN_LON="LocLon";
        public static final String COLUMN_LABEL="GFLable";
        public static final String COLUMN_CREATEDON="GFCreatedOn";
        public static final String COLUMN_GFActive="isGFActive";
    }


}
