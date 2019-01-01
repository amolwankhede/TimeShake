package com.speechry.timeshake.Models;

import java.util.List;

public class Geofence
{

    private long id;
    private String LocLat;
    private String LocLon;
    private String GFLable;
    private String GFCreatedOn;
    private String isGFActive;



    public Geofence (String locLat, String locLon, String gFLable, String gFCreatedOn, String isGFActive)
    {
        this.LocLat = locLat;
        this.LocLon = locLon;
        this.GFLable= gFLable;
        this.isGFActive= isGFActive;
        this.GFCreatedOn= gFCreatedOn;
    }

    public long getId ()
    {
        return id;
    }
    public void setId(long id)
    {
        this.id = id;
    }

    //lat
    public String getLat(){return LocLat;    }
    public void setLat(String lat)    {        this.LocLat= lat;    }

    //lon
    public String getLon(){        return LocLon;    }
    public void setLon(String lon)    {        this.LocLon= lon;    }

    //label
    public String getLabel(){return GFLable;    }
    public void SetLable(String label)    {this.GFLable= GFLable;}

    //Created on
    public String getCreatedon(){return GFCreatedOn;}
    public void setGFCreatedOn(String GFCreatedOn) {
        this.GFCreatedOn = GFCreatedOn;
    }

    //isActive
    public String isActive(){return isGFActive;}
    public void SetIsActive(String isGFActive)    {this.isGFActive= isGFActive;}

    //not bothered with overriding right now
    /*
    @Override
    public String toString ()
    {
        return "";
    }*/
}
