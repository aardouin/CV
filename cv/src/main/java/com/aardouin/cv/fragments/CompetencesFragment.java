package com.aardouin.cv.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aardouin.cv.R;
import com.aardouin.cv.adapters.CategoryCompetencesAdapter;
import com.aardouin.cv.dataProvider.CategoryCompetencesDataProvider;
import com.aardouin.cv.models.CategoryCompetence;
import com.aardouin.cv.models.Competence;
import com.aardouin.cv.views.BorderedRelativeLayout;
import com.aardouin.cv.views.PucedTextView;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class CompetencesFragment extends AbstractContentFragment {

    public final static String TAG = "COMPETENCES_FRAGMENT";
    private View mRootView;
    private ExpandableListView mListView;
    private View popupContainer;
    private BorderedRelativeLayout popupContent;
    private LinearLayout popupDetailsContainer;
    private TextView popupTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.competences_container, container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListView = (ExpandableListView) mRootView.findViewById(R.id.list_view);
        popupContainer = mRootView.findViewById(R.id.popup_container);
        popupContent = (BorderedRelativeLayout) mRootView.findViewById(R.id.popup_content);
        popupTitle = (TextView) mRootView.findViewById(R.id.popup_title);
        popupDetailsContainer = (LinearLayout) mRootView.findViewById(R.id.details_container);

        mListView.setAdapter(new CategoryCompetencesAdapter(CategoryCompetencesDataProvider.getCategoriesCompetences()));
        mListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupIndex, int childIndex, long l) {
                Competence competence = (Competence) expandableListView.getExpandableListAdapter().getChild(groupIndex, childIndex);
                if (competence.getDetailsCompetence() != null) {
                    setPopupDetail(competence, ((CategoryCompetence) expandableListView.getExpandableListAdapter().getGroup(groupIndex)).getColor());
                }
                return true;
            }


        });

        hidePopup();
        popupContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hidePopup();
            }
        });

        popupDetailsContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do nothing  but avoid triggering popupContainer onClick
            }
        });
    }

    private void hidePopup() {
        popupContainer.setVisibility(View.GONE);
    }

    private void setPopupDetail(Competence competence, int color) {
        popupTitle.setText(competence.getName() + " - " + competence.getLevel().toReadable());
        popupTitle.setTextColor(getResources().getColor(color));

        popupDetailsContainer.removeAllViews();
        for (String detail : competence.getDetailsCompetence()) {
            PucedTextView aTextView = new PucedTextView(popupDetailsContainer.getContext());
            aTextView.setText(detail, getResources().getColor(color));
            popupDetailsContainer.addView(aTextView);
        }

        popupContent.setColor(color);
        showPopup();
    }

    private void showPopup() {
        popupContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean doBack() {
        if (View.VISIBLE == popupContainer.getVisibility()) {
            hidePopup();
            return true;
        }
        return false;
    }
}
