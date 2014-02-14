package com.aardouin.cv.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.aardouin.cv.R;
import com.aardouin.cv.models.LevelCompetence;

/**
 * Created by alexisardouin on 14/02/14.
 */
public class LevelView extends View {

    private LevelCompetence level;
    private Path mPath;
    private Paint mPaint;
    private RectF mBoundsFloat;
    private float angleOrigin;
    private float radius;
    private int color;

    public LevelView(Context context) {
        this(context, null);
    }

    public LevelView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LevelView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initDrawingTools();
    }

    //add allochere, to avoid them inside draw
    private void initDrawingTools() {
        mPath = new Path();
        mPaint = new Paint();
        mBoundsFloat = new RectF();
        angleOrigin = -90.0f;
        radius = 0;
    }

    public void setLevel(LevelCompetence level,int color) {
        this.level = level;
        this.color = color;
        invalidate();
    }


    private RectF getFloatBounds() {

        radius = getWidth() / 3;

        mBoundsFloat.set(getWidth() / 2 - radius, getHeight() / 2 - radius, getWidth() / 2 + radius, getHeight() / 2 + radius);
        return mBoundsFloat;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (level != null) {
            mPaint.setStrokeWidth(getResources().getDimension(R.dimen.level_border));

            //draw background circle
            mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            mPaint.setColor(getResources().getColor(R.color.level_back));
            canvas.drawArc(getFloatBounds(), angleOrigin, 360f, false, mPaint);

            //draw colored arc
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(getResources().getColor(color));
            canvas.drawArc(getFloatBounds(), angleOrigin, 360f * level.getPercentValue(), false, mPaint);
        }

    }
}
