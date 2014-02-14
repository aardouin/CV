package com.aardouin.cv.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.aardouin.cv.models.CategoryCompetence;
import com.aardouin.cv.models.Competence;
import com.aardouin.cv.views.CategoryCompetenceCell;
import com.aardouin.cv.views.CompetenceCell;

import java.util.ArrayList;

/**
 * Created by alexisardouin on 02/02/14.
 */
public class CategoryCompetencesAdapter extends BaseExpandableListAdapter {
    private final ArrayList<CategoryCompetence> categoriesCompetence;

    public CategoryCompetencesAdapter(ArrayList<CategoryCompetence> categoriesCompetences) {
        this.categoriesCompetence = categoriesCompetences;
    }

    @Override
    public int getGroupCount() {
        return categoriesCompetence.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return ((CategoryCompetence) getGroup(groupPosition)).getCompetences().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return categoriesCompetence.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return ((CategoryCompetence) categoriesCompetence.get(groupPosition)).getCompetences().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        CategoryCompetenceCell cell = (CategoryCompetenceCell) convertView;
        if (cell == null) {
            cell = new CategoryCompetenceCell(parent.getContext());
        }
        cell.setCategoryCompetence((CategoryCompetence) getGroup(groupPosition));
        return cell;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {


        CompetenceCell cell = (CompetenceCell) convertView;
        if (cell == null) {
            cell = new CompetenceCell(parent.getContext());
        }
        cell.setCompetence((Competence) getChild(groupPosition, childPosition) , ((CategoryCompetence)getGroup(groupPosition)).getColor());
        return cell;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true; // 3((Competence) getChild(groupPosition, childPosition)).getDetailCompetence() != null;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }
}
