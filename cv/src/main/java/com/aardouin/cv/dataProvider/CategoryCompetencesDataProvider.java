package com.aardouin.cv.dataProvider;

import com.aardouin.cv.models.CategoryCompetence;
import com.aardouin.cv.models.Competence;
import com.aardouin.cv.models.LevelCompetence;

import java.util.ArrayList;

/**
 * Created by Omnium Systems on 03/02/14.
 */
public class CategoryCompetencesDataProvider {

    private static ArrayList<CategoryCompetence> categoryCompetenceArrayList;

    public static ArrayList<CategoryCompetence> getCategoriesCompetences() {
        if (categoryCompetenceArrayList == null) {
            categoryCompetenceArrayList = new ArrayList<CategoryCompetence>();

            CategoryCompetence developpementMobile = new CategoryCompetence("Développement mobile");
            developpementMobile.addCompetence(new Competence("Android", LevelCompetence.EXPERT));
            developpementMobile.addCompetence(new Competence("IOS", LevelCompetence.AVANCE));
            developpementMobile.addCompetence(new Competence("Windows 8", LevelCompetence.INTERMEDIAIRE));
            developpementMobile.addCompetence(new Competence("Android", LevelCompetence.EXPERT));
            developpementMobile.addCompetence(new Competence("IOS", LevelCompetence.AVANCE));
            developpementMobile.addCompetence(new Competence("Windows 8", LevelCompetence.INTERMEDIAIRE));
            developpementMobile.addCompetence(new Competence("Android", LevelCompetence.EXPERT));
            developpementMobile.addCompetence(new Competence("IOS", LevelCompetence.AVANCE));
            developpementMobile.addCompetence(new Competence("Windows 8", LevelCompetence.INTERMEDIAIRE));
            categoryCompetenceArrayList.add(developpementMobile);
            CategoryCompetence analyse = new CategoryCompetence("Analyse");
            analyse.addCompetence(new Competence("UML", LevelCompetence.AVANCE));
            analyse.addCompetence(new Competence("MERISE", LevelCompetence.AVANCE));
            analyse.addCompetence(new Competence("UML", LevelCompetence.AVANCE));
            analyse.addCompetence(new Competence("UML", LevelCompetence.AVANCE));
            analyse.addCompetence(new Competence("UML", LevelCompetence.AVANCE));
            categoryCompetenceArrayList.add(analyse);
        }
        return categoryCompetenceArrayList;
    }
}
