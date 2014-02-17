package com.aardouin.cv.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.aardouin.cv.R;

/**
 * Created by alexisardouin on 14/02/14.
 */
public class BorderedRelativeLayout extends RelativeLayout {
    private final float borderWidth;
    private int color = -1;
    private Paint mPaint;

    public BorderedRelativeLayout(Context context) {
        this(context, null);
    }

    public BorderedRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BorderedRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mPaint = new Paint();
        borderWidth = getResources().getDimension(R.dimen.popup_border);
    }

    public void setColor(int color) {
        this.color = color;
        this.invalidate();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if (color != -1) {
            mPaint.setColor(getResources().getColor(color));
            mPaint.setStrokeWidth(borderWidth);
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(borderWidth / 2, borderWidth / 2, getWidth() - (borderWidth / 2), getHeight() - (borderWidth / 2), mPaint);
        }
    }
}
