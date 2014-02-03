package com.aardouin.cv.models;

/**
 * Created by alexisardouin on 02/02/14.
 */
public enum LevelCompetence {
    DEBUTANT {
        @Override
        public String toReadable() {
            return "Débutant";
        }

        @Override
        public float getPercentValue() {
            return 0.25f;
        }
    },INTERMEDIAIRE {
        @Override
        public String toReadable() {
            return "Intermédiaire";
        }

        @Override
        public float getPercentValue() {
            return 0.5f;
        }
    },AVANCE {
        @Override
        public String toReadable() {
            return "Avancé";
        }

        @Override
        public float getPercentValue() {
            return 0.75f;
        }
    },EXPERT {
        @Override
        public String toReadable() {
            return "Expert";
        }

        @Override
        public float getPercentValue() {
            return 1f;
        }
    };
    public abstract String  toReadable();
    public abstract float getPercentValue();
}
