package com.example.nayem.visualaid;

/**
 * Created by Nayem on 10/25/2018.
 */

public class data {
    private double longitude;
    private double latitude;
    private String text;

    public  data(double d1,double d2,String text) {
        this.text = text;
        this.latitude=d1;
        this.longitude=d2;
    }
    public  data() {
        this.text = null;
        this.longitude=0;
        this.latitude=0;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
