package com.aardouin.cv.models;

/**
 * Created by alexisardouin on 02/02/14.
 */
public class Competence {

    private String name;

    public Competence(String name, LevelCompetence level) {
        this.name = name;
        this.level = level;
    }

    private LevelCompetence level;

    public String getName() {
        return name;
    }

    public LevelCompetence getLevel() {
        return level;
    }
}
