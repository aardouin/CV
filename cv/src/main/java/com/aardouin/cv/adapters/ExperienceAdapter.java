package com.aardouin.cv.adapters;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.aardouin.cv.fragments.ExperienceItemFragment;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class ExperienceAdapter extends FragmentStatePagerAdapter {
    private final Integer[] experiences;

    public ExperienceAdapter(FragmentManager manager,Integer[] experiences) {
        super(manager);
        this.experiences = experiences;
    }

    @Override
    public int getCount() {
        return experiences.length;
    }


    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new ExperienceItemFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ExperienceItemFragment.EXPERIENCE_ID_KEY, experiences[i]);
        fragment.setArguments(bundle);
        return fragment;
    }

}
