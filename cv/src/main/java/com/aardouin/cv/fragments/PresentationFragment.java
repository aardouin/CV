package com.aardouin.cv.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aardouin.cv.R;
import com.aardouin.cv.libs.textview_justify.TextViewEx;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class PresentationFragment extends AbstractContentFragment {

    public final static String TAG = "PRESENTATION_FRAGMENT";
    private View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.presentation_container, container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((TextViewEx) view.findViewById(R.id.intro)).setText("Depuis le premier Windows 98 que j'ai eu entre les mains, l'informatique a toujours été une passion. À la découverte du développement en TI-Basic, j'ai tout de suite été plus intéressé par le développement de mini jeux pour mes camarades que par les jeux en eux mêmes. La programmation s'est affirmée être une vocation.", true);
        ((TextViewEx) view.findViewById(R.id.part1)).setText("Après avoir fait mes premiers pas dans le développement orienté objet en C++ sur le siteduzero, mes études m'ont permis de consolider mes compétences et d'acquérir des méthodes de travail.", true);
        ((TextViewEx) view.findViewById(R.id.part2)).setText("C'est avec mon  premier smartphone android que j'ai découvert les possibilitées infinies du monde mobile.", true);
        ((TextViewEx) view.findViewById(R.id.conclusion)).setText("Pour en savoir plus, utilisez le menu latéral gauche. Bonne visite !!\n", true);
    }

}
