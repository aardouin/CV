package com.aardouin.cv.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aardouin.cv.dataProvider.ExperienceDataProvider;
import com.aardouin.cv.models.Experience;
import com.aardouin.cv.views.ExperienceView;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class ExperienceItemFragment extends Fragment {
    public static final String EXPERIENCE_ID_KEY = "EXPERIENCE_ID";
    private Experience mExperience;
    private ExperienceView mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (getArguments() != null) {
            if (getArguments().containsKey(EXPERIENCE_ID_KEY)) {
                int id = getArguments().getInt(EXPERIENCE_ID_KEY);
                mExperience = ExperienceDataProvider.getExperience(id);
            } else {
                throw new RuntimeException("ExperienceItemFragment couldn't create view, needs " + EXPERIENCE_ID_KEY);
            }
        } else {
            throw new RuntimeException("ExperienceItemFragment couldn't create view, needs arguments");
        }
        mView = new ExperienceView(inflater.getContext(), mExperience);
        return mView;
    }
}
