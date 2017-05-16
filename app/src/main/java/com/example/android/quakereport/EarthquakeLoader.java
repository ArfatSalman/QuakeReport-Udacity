package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by Arfat Salman on 08-Apr-17.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private String mURL;

    EarthquakeLoader(Context context, String url) {
        super(context);

        mURL = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        if (mURL.isEmpty())
            return null;

        return QueryUtils.extractEarthquakes(mURL);
    }
}
