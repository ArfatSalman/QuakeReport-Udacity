package com.example.android.quakereport;

/**
 * Created by Arfat Salman on 02-Apr-17.
 */

public class Earthquake {

    private double mMagnitude;
    private String mLocation;
    private long mTimeInMillisecond;
    String mURL;

    public Earthquake(double mag, String loc, long milliseconds, String url) {
        mMagnitude = mag;
        mLocation = loc;
        mTimeInMillisecond = milliseconds;
        mURL = url;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMillisecons() {
        return mTimeInMillisecond;
    }

    public String getURL() { return mURL; }
}
