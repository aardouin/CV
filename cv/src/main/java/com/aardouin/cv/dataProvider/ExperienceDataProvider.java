package com.aardouin.cv.dataProvider;

import android.net.Uri;

import com.aardouin.cv.R;
import com.aardouin.cv.models.Experience;

import java.util.LinkedHashMap;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class ExperienceDataProvider {

    private static LinkedHashMap<Integer, Experience> experiences;

    public static Integer[] getExperiencesId() {

        if (experiences == null) {
            experiences = new LinkedHashMap<Integer, Experience>();

            Experience omnium = new Experience(0, "Lead développeur mobile", "Nantes - France", "Depuis décembre 2011", "9 rue alfred Kastler 44300 Nantes", R.drawable.logo_omnium, Uri.parse("http://www.omnium-systems.com/"));
            omnium.addParagraphe("Startup spécialisée dans le mobile, Omnium Systems m'a permis d'acquerir de l'expérience dans de nombreaux domaines.");
            omnium.addParagraphe("Principalement chargé de développer des applications sur les différentes plateformes mobiles (iOS, android, Windows 8). J'ai vite évolué pour me spécialiser dans le développement Android, pour devenir référent auprès de mes collègues sur le sujet.");
            omnium.addParagraphe("De ce fait, j'ai  formé un apprenti à Android et son architecture. Ce qui m'a permis de faire évoluer mes compétences techniques mais aussi humaines et pédagogique.");
            omnium.addParagraphe("D'un autre coté, j'ai beaucoup appris dans le domaine de l'ergonomie. En effet j'assistais le designer afin d'apporter mes connaissances dans les limites technique des différents systèmes mobiles.");


            Experience applicatour = new Experience(1, "Développeur stagiaire", "Bordeaux - France", "Juin 2011 - Aout 2011", "4 rue Ferrère 33000 Bordeaux", R.drawable.logo_applicatour, Uri.parse("http://www.applicatour.com/"));
            applicatour.addParagraphe("Editeur de logiciel dans le tourisme, Applicatour dévelope une solution de création, recherche et vente de voyages sur mesure.");
            applicatour.addParagraphe("Dans un objectif d'optimisation du coût des requetes et de construction intelligente de voyages à bas prix, j'ai eu comme mission de développer un système de cache intelligent. Pour cela je me suis former au C# et aux service SOAP durant les premières semaines. Je me suit ensuite approprié la base de donnée en place.");
            applicatour.addParagraphe("Ce fût une expèrience très constructive, du fait d'un système relativement complexe.");


            Experience autoEntrepreneur = new Experience(2, "Consultant informatique", "Auto Entrepreneur", "2010-2011");
            autoEntrepreneur.addParagraphe("Suite à mon stage de fin de DUT chez We-do-IT, j'ai créé mon auto entreprise pour continuer mon sujet de stage durant ma licence. (Stage détaillé à la page suivante)");
            autoEntrepreneur.addParagraphe("À l'aide d'un <a style=\"color:#ff8c00;\" href=\"http://www.telegesis.com/ETRX3-development-Kit.htm\">ETRX3 ZigBee Development Kit</a> j'ai simulé un système de domotique pour controler la consommation électrique d'un foyer. Le but de l'opération était de brancher l'IHM produite durant mon stage avec les carte en ZigBee afin de faire des démonstrations.");

            Experience wedoit = new Experience(3, "Développeur stagiare", "Melbourne - Australie", "Avril 2009 - Juin 2009", "We-Do-It l12/200 Queen St Melbourne VIC 3000 Australie", R.drawable.logo_wedoit, Uri.parse("http://www.we-do-it.com/"));

            Experience divers = new Experience(4, "Animateur - Manutentionnaire", "Jobs etudiants", "2007 - 2011");
            divers.addParagraphe("J'ai principalement été animateur de centre de loisirs ou de parc d'attraction durant mes vacances scolaires et les week end pour financer mes études. Ces expériences ont été très enrichissante pour le coté humain.");
            divers.addParagraphe("J'ai aussi occupé des postes de manutentionnaire, préparateur de commande, durant certaines de mes vavances. La rigueur et la productivité étaient ici de mise, et ont grandment participé à la découverte du monde professionnel.");


            addExperience(omnium);
            addExperience(applicatour);
            addExperience(autoEntrepreneur);
            addExperience(wedoit);
            addExperience(divers);

        }

        Integer[] result = new Integer[experiences.size()];
        experiences.keySet().toArray(result);
        return result;
    }

    private static void addExperience(Experience experience) {
        experiences.put(experience.getId(), experience);
    }

    public static Experience getExperience(int id) {
        if (experiences != null) {
            return experiences.get(id);
        } else {
            throw new RuntimeException("Need to call getExperiencesId() before getting an experience");
        }
    }
}
