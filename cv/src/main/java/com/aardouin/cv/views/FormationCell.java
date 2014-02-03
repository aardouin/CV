package com.aardouin.cv.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.aardouin.cv.R;
import com.aardouin.cv.models.Formation;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class FormationCell extends FrameLayout{
    private TextView date;
    private TextView location;
    private TextView details;
    private TextView title;

    public FormationCell(Context context) {
        this(context, null);
    }

    public FormationCell(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FormationCell(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.formation_cell,this);
        bind();
    }

    private void bind() {
        this.date = (TextView)findViewById(R.id.date);
        this.title = (TextView)findViewById(R.id.title);
        this.details = (TextView)findViewById(R.id.details);
        this.location = (TextView)findViewById(R.id.location);
    }

    public void setFormation(Formation formation){
        this.date.setText(formation.getDate());
        this.title.setText(formation.getName());
        if( formation.getDetails()!= null){
            this.details.setVisibility(VISIBLE);
            this.details.setText(formation.getDetails());
        }else{
            this.details.setVisibility(GONE);
        }
        this.location.setText(formation.getLocation());
    }
}
