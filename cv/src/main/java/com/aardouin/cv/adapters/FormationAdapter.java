package com.aardouin.cv.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.aardouin.cv.models.Formation;
import com.aardouin.cv.views.FormationCell;

import java.util.ArrayList;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class FormationAdapter extends BaseAdapter {


    private final ArrayList<Formation> formations;

    public FormationAdapter(ArrayList<Formation> formations) {
        super();
        this.formations = formations;
    }

    @Override
    public int getCount() {
        return formations.size();
    }

    @Override
    public Object getItem(int i) {
        return formations.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup container) {

        FormationCell formationCell = (FormationCell) convertView;
        if (formationCell == null) {
            formationCell = new FormationCell(container.getContext());
        }

        formationCell.setFormation((Formation) getItem(i));

        return formationCell;
    }
}
