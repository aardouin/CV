package com.aardouin.cv.models;

/**
 * Created by alexisardouin on 02/02/14.
 */
public class Competence {

    private String name;
    private LevelCompetence level;
    private String detailCompetence;

    public Competence(String name, LevelCompetence level) {
        this(name, level, null);
    }

    public Competence(String name, LevelCompetence level, String detailCompetence) {
        this.name = name;
        this.level = level;
        this.detailCompetence = detailCompetence;
    }

    public String getName() {
        return name;
    }

    public LevelCompetence getLevel() {
        return level;
    }

    public String getDetailCompetence() {
        return detailCompetence;
    }
}
