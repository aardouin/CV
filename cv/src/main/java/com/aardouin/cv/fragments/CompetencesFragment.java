package com.aardouin.cv.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.aardouin.cv.R;
import com.aardouin.cv.adapters.CategoryCompetencesAdapter;
import com.aardouin.cv.dataProvider.CategoryCompetencesDataProvider;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class CompetencesFragment extends Fragment {

    public final static String TAG = "COMPETENCES_FRAGMENT";
    private View mRootView;
    private ExpandableListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.competences_container, container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListView = (ExpandableListView) mRootView.findViewById(R.id.list_view);
        mListView.setAdapter(new CategoryCompetencesAdapter(CategoryCompetencesDataProvider.getCategoriesCompetences()));
    }
}
