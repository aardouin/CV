package com.aardouin.cv.views;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.widget.TextView;

import com.aardouin.cv.R;

/**
 * Created by alexisardouin on 16/02/14.
 */
public class PucedTextView extends TextView {


    public PucedTextView(Context context) {
        this(context, null);
    }

    public PucedTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PucedTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setText(String text, int color) {
        super.setText(text);

        ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
        drawable.getPaint().setColor(color);
        drawable.getPaint().setStyle(Paint.Style.FILL);
        drawable.getPaint().setAntiAlias(true);
        drawable.setIntrinsicHeight((int) getResources().getDimension(R.dimen.puce_size));
        drawable.setIntrinsicWidth((int) getResources().getDimension(R.dimen.puce_size));
        setCompoundDrawablePadding((int) getResources().getDimension(R.dimen.puce_size));
        this.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null, null);
    }


}
