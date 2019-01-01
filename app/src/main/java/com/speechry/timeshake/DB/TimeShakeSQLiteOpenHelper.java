package com.speechry.timeshake.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class TimeShakeSQLiteOpenHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME="TimeShake.db";
    private static final int VERSION_NUMBER=1;


    public TimeShakeSQLiteOpenHelper (@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TimeShakeDBContract.CREATE_GEOFENCE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,  int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TimeShakeDBContract.GeofenceEntry.TABLE_NAME);

        onCreate(sqLiteDatabase);
    }
}
