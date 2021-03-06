package com.aardouin.cv.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aardouin.cv.R;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class InteretsFragments extends AbstractContentFragment {

    public final static String TAG = "INTERETS_FRAGMENT";
    private View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.interets_container, container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
