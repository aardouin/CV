package com.aardouin.cv.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.aardouin.cv.adapters.FormationAdapter;
import com.aardouin.cv.dataProvider.FormationDataProvider;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class FormationFragment extends Fragment {
    public static final String TAG = "FORMATION_FRAGMENT";
    private ListView mListView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mListView = new ListView(inflater.getContext());
        return mListView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListView.setAdapter(new FormationAdapter(FormationDataProvider.getFormations()));
    }
}
