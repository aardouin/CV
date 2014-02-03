package com.aardouin.cv.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aardouin.cv.R;
import com.aardouin.cv.adapters.ExperienceAdapter;
import com.aardouin.cv.dataProvider.ExperienceDataProvider;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class PresentationFragment extends Fragment{

   public final static String TAG= "PRESENTATION_FRAGMENT";
    private View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.presentation_container,container,false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
