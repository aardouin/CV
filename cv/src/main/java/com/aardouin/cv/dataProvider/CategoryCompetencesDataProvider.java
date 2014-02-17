package com.aardouin.cv.dataProvider;

import com.aardouin.cv.R;
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

            CategoryCompetence developpementMobile = new CategoryCompetence("Développement mobile", R.color.comp_orange);
            developpementMobile.addCompetence(new Competence("Android", LevelCompetence.EXPERT, new String[]{"Optimisations de performances", "Maitrise des fragments", "Architecture complexes d'applications"}));
            developpementMobile.addCompetence(new Competence("IOS", LevelCompetence.AVANCE, new String[]{"Réalisation de composants complexes personnalisable", "Modulara"}));
            developpementMobile.addCompetence(new Competence("Windows 8", LevelCompetence.INTERMEDIAIRE));
            developpementMobile.addCompetence(new Competence("Cordova (Phonegap)", LevelCompetence.INTERMEDIAIRE));
            categoryCompetenceArrayList.add(developpementMobile);

            CategoryCompetence developementWeb = new CategoryCompetence("Développement web", R.color.comp_green);
            developementWeb.addCompetence(new Competence("HTML5", LevelCompetence.AVANCE));
            developementWeb.addCompetence(new Competence("CSS", LevelCompetence.INTERMEDIAIRE));
            developementWeb.addCompetence(new Competence("Javascript", LevelCompetence.AVANCE));
            categoryCompetenceArrayList.add(developementWeb);


            CategoryCompetence developementBackEnd = new CategoryCompetence("Développement serveur",R.color.comp_orange);
            developementBackEnd.addCompetence(new Competence("Ruby on rails", LevelCompetence.AVANCE));
            developementBackEnd.addCompetence(new Competence("J2EE", LevelCompetence.INTERMEDIAIRE));
            developementBackEnd.addCompetence(new Competence("PHP", LevelCompetence.INTERMEDIAIRE));
            categoryCompetenceArrayList.add(developementBackEnd);

            CategoryCompetence loiciels = new CategoryCompetence("Logiciels", R.color.comp_green);
            loiciels.addCompetence(new Competence("Android Studio (IntelliJ IDEA)", LevelCompetence.EXPERT, new String[]{"Maitrise d'Android Studio et des dérivés d'intelliJ IDEA", "Maitrise de gradle"}));
            loiciels.addCompetence(new Competence("Netbeans", LevelCompetence.AVANCE));
            loiciels.addCompetence(new Competence("Eclipse", LevelCompetence.AVANCE));
            loiciels.addCompetence(new Competence("Visual Studio", LevelCompetence.INTERMEDIAIRE));
            categoryCompetenceArrayList.add(loiciels);

            CategoryCompetence analyse = new CategoryCompetence("Analyse et conception", R.color.comp_orange);
            analyse.addCompetence(new Competence("UML", LevelCompetence.AVANCE));
            analyse.addCompetence(new Competence("MERISE", LevelCompetence.INTERMEDIAIRE));
            categoryCompetenceArrayList.add(analyse);


            CategoryCompetence db = new CategoryCompetence("Base de donnée", R.color.comp_green);
            db.addCompetence(new Competence("MySQL", LevelCompetence.AVANCE));
            db.addCompetence(new Competence("SQLite", LevelCompetence.AVANCE));
            db.addCompetence(new Competence("MongoDB", LevelCompetence.INTERMEDIAIRE));
            categoryCompetenceArrayList.add(db);


            CategoryCompetence atouts = new CategoryCompetence("Mes Atouts", R.color.comp_orange);
            atouts.addCompetence(new Competence("Capacité d'apprentissae", LevelCompetence.EXPERT));
            atouts.addCompetence(new Competence("Passion", LevelCompetence.EXPERT));
            atouts.addCompetence(new Competence("Curiosité", LevelCompetence.EXPERT));
            categoryCompetenceArrayList.add(atouts);
        }
        return categoryCompetenceArrayList;
    }
}
