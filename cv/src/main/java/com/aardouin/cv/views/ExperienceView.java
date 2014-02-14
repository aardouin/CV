package com.aardouin.cv.views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aardouin.cv.R;
import com.aardouin.cv.libs.textview_justify.TextViewEx;
import com.aardouin.cv.models.Experience;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class ExperienceView extends FrameLayout {
    private final Experience mExperience;
    private ImageView logo;
    private TextView title;
    private TextView companyLocation;
    private TextView date;
    private TextView name;
    private LinearLayout paragraphe_container;

    public ExperienceView(Context context, Experience experience) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.experience_item, this);
        this.mExperience = experience;
        bind();
    }


    private void bind() {

        this.logo = (ImageView) findViewById(R.id.company_logo);
        this.name = (TextView) findViewById(R.id.company_name);
        this.title = (TextView) findViewById(R.id.title);
        this.companyLocation = (TextView) findViewById(R.id.company_location);
        this.date = (TextView) findViewById(R.id.date);
        this.paragraphe_container = (LinearLayout) findViewById(R.id.paragraphe_container);


        companyLocation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "geo:0,0?q=";
                uri += Uri.encode(mExperience.getAdress());
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                getContext().startActivity(intent);
            }
        });

        this.logo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, mExperience.getWebsite());
                getContext().startActivity(intent);
            }
        });

        //Fill with mExperience
        if (mExperience.getLogo() > 0) {
            this.logo.setImageDrawable(getResources().getDrawable(mExperience.getLogo()));
        } else {
            this.logo.setVisibility(View.GONE);
            this.name.setText(mExperience.getName());
            this.name.setVisibility(VISIBLE);
        }

        this.title.setText(mExperience.getTitle());

        if (mExperience.getLocation() != null)
            this.companyLocation.setText(mExperience.getLocation());
        else
            this.companyLocation.setVisibility(View.GONE);

        this.date.setText(mExperience.getDate());

        for (int i = 0; i != mExperience.getParagraphes().size(); i++) {

            TextViewEx textView = new TextViewEx(getContext());
            textView.setText(mExperience.getParagraphes().get(i), true);
            paragraphe_container.addView(textView);

            if (i < mExperience.getParagraphes().size() - 1) {
                View separatorView = new View(getContext());
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2);
                separatorView.setBackgroundColor(getResources().getColor(R.color.light_blue));
                int margin = getResources().getDimensionPixelSize(R.dimen.default_margin);
                params.setMargins(margin, margin, margin, margin);
                separatorView.setLayoutParams(params);
                paragraphe_container.addView(separatorView);
            }

        }

    }
}
