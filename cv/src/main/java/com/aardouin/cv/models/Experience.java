package com.aardouin.cv.models;

import android.net.Uri;

import java.util.ArrayList;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class Experience {
    private int id;

    private String title;
    private String location;
    private String date;
    private String adress;
    private String name;
    private Uri website;

    private ArrayList<String> paragraphes;

    public int getLogo() {
        return logo;
    }

    private int logo;

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public Experience(int id, String title, String location, String date, String adress, int logo, Uri website) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.date = date;
        this.adress = adress;
        this.logo = logo;
        this.website = website;
        this.paragraphes = new ArrayList<String>();
    }


    public Experience(int id, String title, String name, String date) {
        this(id, title, null, date, null, -1, null);
        this.name = name;
    }


    public String getAdress() {
        return adress;
    }

    public String getName() {
        return name;
    }

    public Uri getWebsite() {
        return website;
    }

    public ArrayList<String> getParagraphes() {
        return paragraphes;
    }

    public void addParagraphe(String paragraphe) {
        paragraphes.add(paragraphe);
    }
}
