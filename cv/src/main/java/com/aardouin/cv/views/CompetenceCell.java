package com.aardouin.cv.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.aardouin.cv.R;
import com.aardouin.cv.models.Competence;

/**
 * Created by Omnium Systems on 03/02/14.
 */
public class CompetenceCell extends FrameLayout {

    private TextView text;
    private LevelView level;
    private View infoButton;

    public CompetenceCell(Context context) {
        this(context, null);
    }

    public CompetenceCell(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CompetenceCell(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.competence_cell, this);
        bind();
    }

    private void bind() {

        this.text = (TextView) findViewById(R.id.text);
        this.level = (LevelView) findViewById(R.id.level);
        this.infoButton = findViewById(R.id.info_button);

    }


    public void setCompetence(Competence competence, int color) {
        this.text.setText(competence.getName());
        this.level.setLevel(competence.getLevel(), color);
        this.infoButton.setVisibility(competence.getDetailsCompetence() != null ? View.VISIBLE : View.GONE);
    }


}
