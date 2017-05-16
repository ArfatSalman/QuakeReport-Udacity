package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Arfat Salman on 03-Apr-17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private final int PRIMARY = 1;
    private final int SECONDARY = 0;

    public EarthquakeAdapter(Activity context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake earthquake = getItem(position);

        TextView mag = (TextView)listItem.findViewById(R.id.magnitude);

        GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();
        int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        mag.setText(magnitudeFormat(earthquake.getMagnitude()));


        String[] separateLocations = splitLocation(earthquake.getLocation());

        TextView primary_loc = (TextView)listItem.findViewById(R.id.primary_location);
        primary_loc.setText(separateLocations[PRIMARY]);

        TextView secondary_loc = (TextView) listItem.findViewById(R.id.secondary_location);
        secondary_loc.setText(separateLocations[SECONDARY]);

        Date dateObject = new Date(earthquake.getTimeInMillisecons());

        TextView date = (TextView) listItem.findViewById(R.id.date);
        date.setText(formatDate(dateObject));

        TextView time = (TextView) listItem.findViewById(R.id.time);
        time.setText(formatTime(dateObject));

        return listItem;
        //return super.getView(position, convertView, parent);
    }

    private int getMagnitudeColor(double mag) {
        int magColorResID;

        switch ((int)mag) {
            case 0:
            case 1:
            case 2:
                magColorResID = R.color.magnitude1;
                break;
            case 3:
                magColorResID = R.color.magnitude2;
                break;
            case 4:
                magColorResID = R.color.magnitude3;
                break;
            case 5:
                magColorResID = R.color.magnitude4;
                break;
            case 6:
                magColorResID = R.color.magnitude5;
                break;
            case 7:
                magColorResID = R.color.magnitude6;
                break;
            case 8:
                magColorResID = R.color.magnitude7;
                break;
            case 9:
                magColorResID = R.color.magnitude8;
                break;
            case 10:
                magColorResID = R.color.magnitude9;
                break;
            default:
                magColorResID = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magColorResID);
    }

    private String magnitudeFormat(Double mag) {
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(mag);
    }

    private String formatDate(Date dateObj) {
        SimpleDateFormat formatter = new SimpleDateFormat("LLL dd, yyyy");
        return formatter.format(dateObj);
    }

    private String formatTime(Date dateObj) {
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        return timeFormatter.format(dateObj);
    }

    private String[] splitLocation(String location) {
        String[] separatedLocations = new String[2];

        if (location.contains("of")){
            separatedLocations = location.split("of ");
            separatedLocations[0] = separatedLocations[0] + "of";
        } else {
            separatedLocations[0] = "Near the";
            separatedLocations[1] = location;
        }
        return separatedLocations;

    }
}
