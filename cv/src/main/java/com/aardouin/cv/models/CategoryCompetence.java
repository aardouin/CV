package com.aardouin.cv.models;

import java.util.ArrayList;

/**
 * Created by alexisardouin on 02/02/14.
 */
public class CategoryCompetence {
    private final int color;
    private String name;
    private ArrayList<Competence> competences;

    public CategoryCompetence(String name,int color) {
        this.name = name;
        this.color = color;

        competences = new ArrayList<Competence>();
    }

    public ArrayList<Competence> getCompetences() {
        return competences;
    }

    public String getName() {
        return name;
    }

    public void addCompetence(Competence competence) {
        competences.add(competence);
    }

    public int getColor() {
        return color;
    }
}
