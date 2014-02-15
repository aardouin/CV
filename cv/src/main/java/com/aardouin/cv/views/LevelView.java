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
import com.aardouin.cv.utils.Utils;

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
    private int darkenedColor;

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
            mPaint.setAntiAlias(true);
            mPaint.setStrokeWidth(getResources().getDimension(R.dimen.level_border));


            //draw background circle
            mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            mPaint.setColor(getResources().getColor(R.color.level_back));
            canvas.drawArc(getFloatBounds(), angleOrigin, 360f, false, mPaint);


            //draw colored outer border arc
            mPaint.setStyle(Paint.Style.STROKE);
            darkenedColor = Utils.darkenColor(getResources().getColor(color));
            mPaint.setColor(darkenedColor);
            //canvas.drawArc(mBoundsFloat, angleOrigin, 360f * level.getPercentValue(), false, mPaint);

            mPath.reset();
            mPath.addArc(mBoundsFloat, angleOrigin, 360f * level.getPercentValue());

            canvas.drawPath(mPath,mPaint);

            int outerBorderSize = 2;
            mPaint.setColor(getResources().getColor(color));
            mPaint.setStrokeWidth(mPaint.getStrokeWidth()-(outerBorderSize*2));

            mPath.reset();
            mPath.addArc(mBoundsFloat, angleOrigin +outerBorderSize, (360f * level.getPercentValue() )-(outerBorderSize*2));

            mBoundsFloat.set(mBoundsFloat.left+outerBorderSize,mBoundsFloat.top+outerBorderSize,mBoundsFloat.right+outerBorderSize,mBoundsFloat.bottom+outerBorderSize);

            canvas.drawPath(mPath,mPaint);



        }

    }
}
