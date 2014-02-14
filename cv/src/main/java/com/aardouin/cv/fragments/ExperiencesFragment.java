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
import com.aardouin.cv.views.PagerIndicator;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class ExperiencesFragment extends Fragment implements ViewPager.OnPageChangeListener {

    public final static String TAG = "EXPERIENCES_FRAGMENT";

    private PagerIndicator mIndicator;
    private ViewPager mViewPager;
    private View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.experiences_container, container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewPager = (ViewPager) mRootView.findViewById(R.id.experience_pager);
        mIndicator = (PagerIndicator) mRootView.findViewById(R.id.pagerindicator);
        ExperienceAdapter adapter = new ExperienceAdapter(getChildFragmentManager(), ExperienceDataProvider.getExperiencesId());
        mViewPager.setAdapter(adapter);

        mViewPager.setOnPageChangeListener(this);
        mIndicator.setTotalCount(adapter.getCount());
        mIndicator.setPage(0);
    }


    @Override
    public void onPageScrolled(int i, float v, int i2) {
    }

    @Override
    public void onPageSelected(int i) {
        mIndicator.setPage(i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {
    }


}
