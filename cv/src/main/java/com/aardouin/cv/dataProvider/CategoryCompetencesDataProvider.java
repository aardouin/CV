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

            CategoryCompetence developpementMobile = new CategoryCompetence("Développement mobile", R.color.comp_green);
            developpementMobile.addCompetence(new Competence("IOS", LevelCompetence.AVANCE,"details"));
            developpementMobile.addCompetence(new Competence("Android", LevelCompetence.EXPERT, "Utilisations de fragments / drawble poussés et beaucoup de txexte pour comblé le vide parceque la y'a pas assez de texte et j'ai pas envie de mettre du Lorem Ipsum \n test retour \r test 2 retour"));
            developpementMobile.addCompetence(new Competence("Windows 8", LevelCompetence.INTERMEDIAIRE));
            categoryCompetenceArrayList.add(developpementMobile);
            CategoryCompetence analyse = new CategoryCompetence("Analyse",R.color.comp_yellow);
            analyse.addCompetence(new Competence("UML", LevelCompetence.AVANCE));
            analyse.addCompetence(new Competence("MERISE", LevelCompetence.AVANCE));
            analyse.addCompetence(new Competence("UML", LevelCompetence.AVANCE));
            analyse.addCompetence(new Competence("UML", LevelCompetence.AVANCE));
            analyse.addCompetence(new Competence("UML", LevelCompetence.AVANCE));
            categoryCompetenceArrayList.add(analyse);
            CategoryCompetence developementBackEnd = new CategoryCompetence("Développement serveur",R.color.comp_orange);
            developementBackEnd.addCompetence(new Competence("Ruby on rails", LevelCompetence.AVANCE));
            developementBackEnd.addCompetence(new Competence("EJS", LevelCompetence.AVANCE));
            developementBackEnd.addCompetence(new Competence("UML", LevelCompetence.AVANCE));
            categoryCompetenceArrayList.add(developementBackEnd);
        }
        return categoryCompetenceArrayList;
    }
}
