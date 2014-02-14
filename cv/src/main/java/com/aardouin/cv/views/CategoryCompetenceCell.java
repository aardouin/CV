package com.aardouin.cv.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.aardouin.cv.R;
import com.aardouin.cv.models.CategoryCompetence;

/**
 * Created by Omnium Systems on 03/02/14.
 */
public class CategoryCompetenceCell extends FrameLayout {

    private TextView text;

    public CategoryCompetenceCell(Context context) {
        this(context, null);
    }

    public CategoryCompetenceCell(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CategoryCompetenceCell(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.category_competence_cell, this);
        bind();
    }

    private void bind() {

        this.text = (TextView) findViewById(R.id.text);
    }


    public void setCategoryCompetence(CategoryCompetence categoryCompetence) {
        this.text.setText(categoryCompetence.getName());
        this.text.setBackgroundColor(getResources().getColor(categoryCompetence.getColor()));
    }
}
