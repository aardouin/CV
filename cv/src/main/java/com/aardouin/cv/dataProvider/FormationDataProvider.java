package com.aardouin.cv.dataProvider;

import com.aardouin.cv.models.Formation;

import java.util.ArrayList;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class FormationDataProvider {

    private static ArrayList<Formation> formations;

    public static ArrayList<Formation> getFormations(){

        if( formations == null){
            formations = new ArrayList<Formation>();

            formations.add(new Formation("Licence MIAGE","Bordeaux","2011"));
            formations.add(new Formation("DUT Informatique","Génie Informatique","IUT de La Rochelle","2010"));
            formations.add(new Formation("Baccalauréat Scientifique","Spécialité mathématiques","Lycée Charles A. Coulomb","2008"));

        }
        return formations;
    }
}
