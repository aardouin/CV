package com.aardouin.cv.dataProvider;

import android.net.Uri;

import com.aardouin.cv.R;
import com.aardouin.cv.models.Experience;

import java.util.LinkedHashMap;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class ExperienceDataProvider {

    private static LinkedHashMap<Integer,Experience> experiences;

    public static Integer[] getExperiencesId(){

        if( experiences == null){
            experiences = new LinkedHashMap<Integer, Experience>();

            Experience omnium = new Experience(0,"Lead développeur mobile","Nantes - France","Depuis décembre 2011", "9 rue alfred Kastler 44300 Nantes",R.drawable.logo_omnium,Uri.parse("http://www.omnium-systems.com/"));

            omnium.addParagraphe("Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un peintre anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre cinq siècles, mais s'est aussi adapté à la bureautique informatique, sans que son contenu n'en soit modifié. Il a été popularisé dans les années 1960 grâce à la vente de feuilles Letraset contenant des passages du Lorem Ipsum, et, plus récemment, par son inclusion dans des applications de mise en page de texte, comme Aldus PageMaker");
            omnium.addParagraphe("Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un peintre anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre cinq siècles, mais s'est aussi adapté à la bureautique informatique, sans que son contenu n'en soit modifié. Il a été popularisé dans les années 1960 grâce à la vente de feuilles Letraset contenant des passages du Lorem Ipsum, et, plus récemment, par son inclusion dans des applications de mise en page de texte, comme Aldus PageMaker");
            omnium.addParagraphe("Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un peintre anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre cinq siècles, mais s'est aussi adapté à la bureautique informatique, sans que son contenu n'en soit modifié. Il a été popularisé dans les années 1960 grâce à la vente de feuilles Letraset contenant des passages du Lorem Ipsum, et, plus récemment, par son inclusion dans des applications de mise en page de texte, comme Aldus PageMaker");
            Experience autoEntrepreneur =new Experience(1,"Consultant informatique","Auto Entrepreneur","2010-2011");
            Experience wedoit = new Experience(2, "Développeur stagiare", "Melbourne - Australie", "Avril 2009 - Juin 2009", "We-Do-It l12/200 Queen St Melbourne VIC 3000 Australie", R.drawable.logo_wedoit,Uri.parse("http://www.we-do-it.com/"));

            addExperience(omnium);
            addExperience(autoEntrepreneur);
            addExperience(wedoit);

        }

        Integer[] result = new Integer[experiences.size()];
        experiences.keySet().toArray(result);
        return result;
    }

    private static void addExperience(Experience experience) {
        experiences.put(experience.getId(),experience);
    }

    public static Experience getExperience(int id) {
        if( experiences != null){
            return experiences.get(id);
        }else{
            throw new RuntimeException("Need to call getExperiencesId() before getting an experience");
        }
    }
}
