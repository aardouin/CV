package com.aardouin.cv.models;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class Formation {

    private String name;
    private String location;
    private String date;
    private String details;

    public Formation(String name, String details, String location, String date) {
        this.name = name;
        this.details = details;
        this.location = location;
        this.date = date;
    }

    public Formation(String name, String location, String date) {
        this(name, null, location, date);
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getDetails() {
        return details;
    }
}
