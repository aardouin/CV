package com.aardouin.cv.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.aardouin.cv.R;

import java.util.ArrayList;

/**
 * Created by Omnium Systems on 25/10/13.
 */
public class PagerIndicator extends LinearLayout {

    private ArrayList<ImageView> indicators;

    public PagerIndicator(Context context) {
        this(context, null);
    }

    public PagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.setOrientation(HORIZONTAL);
        this.setGravity(Gravity.CENTER);
        indicators = new ArrayList<ImageView>();
    }

    public void setTotalCount(int count) {
        this.removeAllViews();
        indicators.clear();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.pagerindicator_size), getResources().getDimensionPixelSize(R.dimen.pagerindicator_size));
        int margin = getResources().getDimensionPixelSize(R.dimen.default_margin);
        params.setMargins(margin, margin, margin, margin);
        for (int i = 0; i != count; i++) {
            ImageView tmpView = new ImageView(getContext());

            tmpView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            tmpView.setLayoutParams(params);
            indicators.add(tmpView);
            setStyle(tmpView, false);
            addView(tmpView);
        }
    }

    private void setStyle(ImageView tmpView, boolean b) {
        if (b) {
            tmpView.setImageDrawable(getResources().getDrawable(R.drawable.ic_selected));
        } else {
            tmpView.setImageDrawable(getResources().getDrawable(R.drawable.ic_unselected));
        }
    }

    public void setPage(int position) {
        for (int i = 0; i != indicators.size(); i++) {
            setStyle(indicators.get(i), i == position);
        }
    }

}
