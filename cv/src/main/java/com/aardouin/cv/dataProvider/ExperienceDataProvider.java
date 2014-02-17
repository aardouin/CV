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
            omnium.addParagraphe("Omnium Systems développe des applications mobiles natives et web pour smartphones et tablettes");
            omnium.addParagraphe("Chargé de développer des applications sur les différentes plateformes mobiles (iOS, android, Windows 8) je suis vite devenu le référent android auprès de de l'entreprise.");
            omnium.addParagraphe("Optimisation des performances sur Android et iOS. Essentiellement détection de fuite mémoire et optimisation de vues.");
            omnium.addParagraphe("Formation d'un apprenti sur Android et son architecture. Ce qui m'a permis de faire évoluer mes compétences techniques mais aussi humaines et pédagogiques.");
            omnium.addParagraphe("Conception de serveurs web (Ruby on Rails, MongoDB)");
            omnium.addParagraphe("Collaboration avec les designers afin d'apporter mes connaissances dans les limites technique des différents systèmes mobiles.");


            Experience applicatour = new Experience(1, "Développeur stagiaire", "Bordeaux - France", "Juin 2011 - Aout 2011", "4 rue Ferrère 33000 Bordeaux", R.drawable.logo_applicatour, Uri.parse("http://www.applicatour.com/"));
            applicatour.addParagraphe("Editeur de logiciel dans le tourisme, Applicatour développe une solution de création, recherche et vente de voyages sur mesure.");
            applicatour.addParagraphe("Dans un objectif d'optimisation du coût des requêtes et de construction intelligente de voyages à bas prix, j'ai eu comme mission de développer un système de cache intelligent. Pour cela je me suis formé au C# et aux services SOAP.");
            applicatour.addParagraphe("J'ai ensuite approprié la base de donnée en place. Celle-ci étant rélativement complexe du fait de son rôle central dans le système, faisant lien entre différents systèmes de réservation externe.");


            Experience wedoit = new Experience(3, "Développeur stagiare", "Melbourne - Australie", "Avril 2009 - Juin 2009", "We-Do-It l12/200 Queen St Melbourne VIC 3000 Australie", R.drawable.logo_wedoit, Uri.parse("http://www.we-do-it.com/"));
            wedoit.addParagraphe("We-do-it m'a accueilli pour mon stage de fin de DUT. Le projet auquel j'ai participé était une solution domotique visant à controller les prises éléctriques d'un foyer en fonction de conditions extérieures (température, horaire, consommation mensuelle). Par exemple régulation automatique du chauffage de la piscine en fonction de la température extérieure.");
            wedoit.addParagraphe("À mon arrivée le stage, le projet n'étant qu'au stade de réflexion, mon rôle a été de définir les besoins techniques et matériels en fonction des resources nécessaires à sa réalisation.");
            wedoit.addParagraphe("Après avoir indentifié les besoins, j'ai réalisé un prototype du système de controle principal embarqué sur un SheevaPlug. Celui-ci comprenait un serveur web communiquant avec une base de données destinée à contrôler le système. Je me suis pour cela auto-formé sur le langage EJScript, un dérivé du Javascript côté serveur, conçu pour être embarqué sur des systèmes à faibles ressources.");
            wedoit.addParagraphe("Étant hébergé chez un collègue  de travail, j'ai eu la chance d'évoluer dans un environnement totalement anglophone. Ce qui m'a permis de perfectionner mon anglais avec lequel j'ai de grandes facilités depuis.");

            Experience autoEntrepreneur = new Experience(2, "Consultant informatique", "Auto Entrepreneur", "2010-2011");
            autoEntrepreneur.addParagraphe("Suite à mon stage chez We-do-IT, l'entreprise m'a recontacté pour continuer le projet. Pour cela j'ai créé mon auto-entreprise en parrallèle de mes études.");
            autoEntrepreneur.addParagraphe("À l'aide d'un ETRX3 ZigBee Development Kit, constitué de plusieurs entités controlables en ZigBee, j'ai été chargé de réaliser une maquette communiquant avec le serveur réalisé en stage pour permettre des démonstrations du produit fini.");

            Experience divers = new Experience(4, "Animateur - Manutentionnaire", "Jobs étudiants", "2007 - 2011");
            divers.addParagraphe("Depuis mes 17 ans et jusqu'à la fin de mes études, j'ai occupé plusieurs postes d'emplois saisonniers.");
            divers.addParagraphe("Après avoir passé mon BAFA en 2006, j'ai occupé des postes d'animateur de centres de loisirs et de parcs d'attractions durant mes vacances scolaires et mes week-end. Ces jobs ont été très enrichissants d'un point de vue humain et m'ont offert mes premières expériences de travail en équipe.");
            divers.addParagraphe("J'ai aussi occupé des postes de manutentionnaire et préparateur de commande. La rigueur et la productivité étaient ici de mise, et ont grandement participé à ma découverte du monde professionnel.");


            addExperience(omnium);
            addExperience(applicatour);
            addExperience(wedoit);
            addExperience(autoEntrepreneur);
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
