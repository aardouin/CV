package com.aardouin.cv.models;

/**
 * Created by alexisardouin on 02/02/14.
 */
public enum CategoryCompetence {

    DEVELOPPEMENT_MOBILE{
        @Override
        public String toReadable() {
            return "Développement mobile";
        }
    },ANALYSE{
        @Override
        public String toReadable() {
            return "Analyse et conception";
        }
    };

    public abstract String toReadable();
}
